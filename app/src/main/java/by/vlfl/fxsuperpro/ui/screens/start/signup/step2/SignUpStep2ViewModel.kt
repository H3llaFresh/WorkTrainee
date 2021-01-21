package by.vlfl.fxsuperpro.ui.screens.start.signup.step2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import by.vlfl.fxsuperpro.android.lifecycle.*
import by.vlfl.fxsuperpro.domain.models.CountryOfResidence

class SignUpStep2ViewModel : ViewModel() {

    val streetAndNumber: MutableLiveData<String> = emptyMutableLiveData()
    val postalCode: MutableLiveData<String> = emptyMutableLiveData()
    val city: MutableLiveData<String> = emptyMutableLiveData()
    val countryOfResidence: MutableLiveData<CountryOfResidence> = emptyMutableLiveData()

    private val validStreetAndNumber: LiveData<Boolean> = streetAndNumber.map { !it.isNullOrEmpty() }
    private val validPostalCode: LiveData<Boolean> = postalCode.map { !it.isNullOrEmpty() }
    private val validCity: LiveData<Boolean> = city.map { !it.isNullOrEmpty() }
    private val validCountryOfResidence:LiveData<Boolean> = countryOfResidence.map { it != null }

    private val _openCountryOfResidenceScreenEvent: SingleLiveEvent<Nothing> = emptySingleLiveEvent()
    val openCountryOfResidenceScreenEvent: LiveData<Nothing>
        get() = _openCountryOfResidenceScreenEvent

    private val _openStep3Event: SingleLiveEvent<Nothing> = emptySingleLiveEvent()
    val openStep3Event: LiveData<Nothing>
        get() = _openStep3Event

    val allFieldsValid: LiveData<Boolean> = combineLatest(
        validStreetAndNumber,
        validPostalCode,
        validCity,
        validCountryOfResidence
    ) {
        validStreetAndNumber.value == true
                && validPostalCode.value == true
                && validCity.value == true
                && validCountryOfResidence.value == true
    }

    fun openCountryOfResidenceScreen() {
        _openCountryOfResidenceScreenEvent.emit()
    }

    fun openStep3() {
        _openStep3Event.emit()
    }
}