package by.vlfl.fxsuperpro.ui.screens.start.signup.step2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.vlfl.fxsuperpro.R
import by.vlfl.fxsuperpro.config.KEY_RESIDENCE_COUNTRY_REQUEST
import by.vlfl.fxsuperpro.config.KEY_RESIDENCE_COUNTRY_RESULT
import by.vlfl.fxsuperpro.databinding.FragmentSignUpStep2Binding
import by.vlfl.fxsuperpro.domain.models.CountryOfResidence
import by.vlfl.fxsuperpro.ui.latinCharInputFilter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpStep2Fragment : Fragment() {

    private var _binding: FragmentSignUpStep2Binding? = null
    private val binding get() = _binding!!

    private val args: SignUpStep2FragmentArgs by navArgs()

    private val viewModel: SignUpStep2ViewModel by viewModel()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpStep2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        setUpToolbar()
        setUpContent()
        setUpInputs()

        observeUiEvents()
        observeCountryOfResidenceResult()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpToolbar() {
        binding.toolbarResidentialAddress.apply {
            buttonBackToolbar.visibility = View.VISIBLE
            buttonBackToolbar.setOnClickListener {
                findNavController().popBackStack()
            }
            tvToolbar.setText(R.string.toolbar_sign_up__title)
        }
    }

    private fun setUpInputs() {
        binding.apply {
            inputStreetAndNumberSignUpStep2.filters = latinCharInputFilter
            inputPostalCodeStep2.filters = latinCharInputFilter
            inputCitySignUpStep2.filters = latinCharInputFilter
        }
    }

    private fun setUpContent() {
        viewModel.countryOfResidence.value = args.countryOfResidence
    }

    private fun observeUiEvents() {
        viewModel.apply {
            openCountryOfResidenceScreenEvent.observe(viewLifecycleOwner, {
                val action = SignUpStep2FragmentDirections.openCountryOfResidence()
                findNavController().navigate(action)
            })

            openStep3Event.observe(viewLifecycleOwner, {
                val action = SignUpStep2FragmentDirections.openStep3()
                findNavController().navigate(action)
            })
        }
    }

    private fun observeCountryOfResidenceResult() {
        setFragmentResultListener(KEY_RESIDENCE_COUNTRY_REQUEST) { _, bundle ->
            val result = bundle.getParcelable<CountryOfResidence>(KEY_RESIDENCE_COUNTRY_RESULT)
            if (result != null) {
                viewModel.countryOfResidence.value = result
            }
        }
    }
}