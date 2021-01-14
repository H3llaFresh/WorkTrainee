package by.vlfl.fxsuperpro.android.lifecycle

import androidx.lifecycle.MutableLiveData

@SinceKotlin("1.1")
fun <T> emptyMutableLiveData(): MutableLiveData<T> = MutableLiveData()