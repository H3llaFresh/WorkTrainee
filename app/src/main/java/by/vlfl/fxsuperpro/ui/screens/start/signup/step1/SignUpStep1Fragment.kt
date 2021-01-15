package by.vlfl.fxsuperpro.ui.screens.start.signup.step1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.vlfl.fxsuperpro.databinding.FragmentSignUpStep1Binding
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

        observeUiEvents()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeUiEvents() {
        viewModel.apply {
            openNextStepEvent.observe(viewLifecycleOwner, {
                val action = SignUpStep1FragmentDirections.openNextStep()
                findNavController().navigate(action)
            })
        }
    }

}