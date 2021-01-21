package by.vlfl.fxsuperpro.ui.screens.start.intro

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import by.vlfl.fxsuperpro.android.lifecycle.SingleLiveEvent
import by.vlfl.fxsuperpro.android.lifecycle.emit
import by.vlfl.fxsuperpro.android.lifecycle.emptySingleLiveEvent

class IntroViewModel : ViewModel() {

    private val _navigateToRegisterEvent: SingleLiveEvent<Nothing> = emptySingleLiveEvent()
    val navigateToRegisterEvent: LiveData<Nothing>
        get() = _navigateToRegisterEvent

    fun openRegister() {
        _navigateToRegisterEvent.emit()
    }

}