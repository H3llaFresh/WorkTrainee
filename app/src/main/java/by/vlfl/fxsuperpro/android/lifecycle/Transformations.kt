package by.vlfl.fxsuperpro.android.lifecycle

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer

@MainThread
fun <R> combineLatest(vararg dependencies: LiveData<out Any?>, combiner: () -> R?): LiveData<R> {
    return MediatorLiveData<R>().also { mediatorLiveData ->
        val observer = Observer<Any?> { mediatorLiveData.value = combiner() }
        dependencies.forEach { dependencyLiveData ->
            mediatorLiveData.addSource(dependencyLiveData, observer)
        }
    }
}