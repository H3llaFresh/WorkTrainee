package by.vlfl.fxsuperpro.ui.screens.start.signup.step1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.vlfl.fxsuperpro.android.lifecycle.SingleLiveEvent
import by.vlfl.fxsuperpro.android.lifecycle.emit
import by.vlfl.fxsuperpro.android.lifecycle.emptyMutableLiveData
import by.vlfl.fxsuperpro.android.lifecycle.emptySingleLiveEvent
import by.vlfl.fxsuperpro.domain.models.CountryOfResidence

class SignUpStep1ViewModel : ViewModel() {

    val countryOfResidence: MutableLiveData<CountryOfResidence> = emptyMutableLiveData()

    private val _openCountryOfResidenceScreenEvent: SingleLiveEvent<Nothing> = emptySingleLiveEvent()
    val openCountryOfResidenceScreenEvent: LiveData<Nothing>
        get() = _openCountryOfResidenceScreenEvent

    private val _openNextStepEvent: SingleLiveEvent<Nothing> = emptySingleLiveEvent()
    val openNextStepEvent: LiveData<Nothing>
        get() = _openNextStepEvent

    fun openCountryOfResidenceScreen() {
        _openCountryOfResidenceScreenEvent.emit()
    }

    fun openNextStep() {
        _openNextStepEvent.emit()
    }
}