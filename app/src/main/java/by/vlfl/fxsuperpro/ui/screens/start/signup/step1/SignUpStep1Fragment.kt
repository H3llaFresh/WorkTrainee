package by.vlfl.fxsuperpro.ui.screens.start.signup.step1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import by.vlfl.fxsuperpro.R
import by.vlfl.fxsuperpro.config.KEY_RESIDENCE_COUNTRY_REQUEST
import by.vlfl.fxsuperpro.config.KEY_RESIDENCE_COUNTRY_RESULT
import by.vlfl.fxsuperpro.databinding.FragmentSignUpStep1Binding
import by.vlfl.fxsuperpro.domain.models.CountryOfResidence
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpStep1Fragment : Fragment() {

    private var _binding: FragmentSignUpStep1Binding? = null
    private val binding get() = _binding!!

    private val viewModel: SignUpStep1ViewModel by viewModel()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpStep1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel

        setUpToolbar()

        observeUiEvents()
        observeCountryOfResidenceResult()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpToolbar() {
        binding.toolbarSignUpStep1.tvToolbar.setText(R.string.toolbar_sign_up_step1__title)
    }

    private fun observeUiEvents() {
        viewModel.apply {

            openCountryOfResidenceScreenEvent.observe(viewLifecycleOwner, {
                val action = SignUpStep1FragmentDirections.openCountryOfResidence()
                findNavController().navigate(action)
            })

            openNextStepEvent.observe(viewLifecycleOwner, {
                val action = SignUpStep1FragmentDirections.openNextStep(
                        countryOfResidence = countryOfResidence.value!!
                )
                findNavController().navigate(action)
            })
        }
    }

    private fun observeCountryOfResidenceResult() {
        setFragmentResultListener(KEY_RESIDENCE_COUNTRY_REQUEST) { _, bundle ->
            val result = bundle.getParcelable<CountryOfResidence>(KEY_RESIDENCE_COUNTRY_RESULT)
            if (result != null) {
                viewModel.countryOfResidence.value = result
                binding.inputCountryOfResidenceSignUpStep1.setText(result.name)
            }
        }
    }

}