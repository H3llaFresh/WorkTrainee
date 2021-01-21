package by.vlfl.fxsuperpro.ui.screens.start.signup.step1.countryOfResidence

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.vlfl.fxsuperpro.android.lifecycle.emptyMutableLiveData
import by.vlfl.fxsuperpro.domain.models.CountryOfResidence
import by.vlfl.fxsuperpro.domain.usecase.GetCountriesOfResidence
import kotlinx.coroutines.launch

class CountryOfResidenceViewModel(private val getCountriesOfResidence: GetCountriesOfResidence) : ViewModel() {

    private val _countries: MutableLiveData<List<CountryOfResidence>> = emptyMutableLiveData()
    val countries: LiveData<List<CountryOfResidence>>
        get() = _countries

    fun getCountries() {
        viewModelScope.launch {
            _countries.value = getCountriesOfResidence()
        }
    }
}