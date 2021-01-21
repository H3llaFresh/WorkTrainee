package by.vlfl.fxsuperpro.ui.screens.start.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.vlfl.fxsuperpro.android.navigation.navigateSafe
import by.vlfl.fxsuperpro.databinding.FragmentIntroBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class IntroFragment : Fragment() {

    private var _binding: FragmentIntroBinding? = null
    private val binding get() = _binding!!

    private val viewModel: IntroViewModel by viewModel()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIntroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        observeUiEvents()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeUiEvents() {
        viewModel.apply {
            navigateToRegisterEvent.observe(viewLifecycleOwner, {
                val action = IntroFragmentDirections.openSignUpStep1()
                findNavController().navigateSafe(action)
            })
        }
    }
}