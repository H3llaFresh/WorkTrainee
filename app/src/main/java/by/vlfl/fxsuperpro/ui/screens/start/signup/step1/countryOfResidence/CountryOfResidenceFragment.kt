package by.vlfl.fxsuperpro.ui.screens.start.signup.step1.countryOfResidence

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.vlfl.fxsuperpro.R
import by.vlfl.fxsuperpro.config.KEY_RESIDENCE_COUNTRY_REQUEST
import by.vlfl.fxsuperpro.config.KEY_RESIDENCE_COUNTRY_RESULT
import by.vlfl.fxsuperpro.databinding.FragmentCountryOfResidenceBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CountryOfResidenceFragment : Fragment() {

    private var _binding: FragmentCountryOfResidenceBinding? = null
    private val binding get() = _binding!!

    private lateinit var countriesAdapter: CountriesOfResidenceAdapter

    private val viewModel: CountryOfResidenceViewModel by viewModel()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountryOfResidenceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpAdapter()
        setUpToolbar()

        observeCountries()

        viewModel.getCountries()
    }

    private fun observeCountries() {
        viewModel.countries.observe(viewLifecycleOwner, { countries ->
            countriesAdapter.replaceItems(countries)
        })
    }

    private fun setUpAdapter() {
        countriesAdapter = CountriesOfResidenceAdapter(CountryOfResidenceItemHandler { countryOfResidence ->
            setFragmentResult(KEY_RESIDENCE_COUNTRY_REQUEST, bundleOf(
                    KEY_RESIDENCE_COUNTRY_RESULT to countryOfResidence
            ))
            findNavController().popBackStack()
        })

        binding.rvCountriesOfResidence.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countriesAdapter
        }
    }

    private fun setUpToolbar() {
        binding.toolbarCountryOfResidence.apply {
            buttonBackToolbar.visibility = View.VISIBLE
            buttonBackToolbar.setOnClickListener {
                findNavController().popBackStack()
            }
            tvToolbar.setText(R.string.toolbar_residence_country__title)
        }
    }
}