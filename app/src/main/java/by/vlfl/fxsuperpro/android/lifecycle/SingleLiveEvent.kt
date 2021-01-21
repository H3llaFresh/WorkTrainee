package by.vlfl.fxsuperpro.android.lifecycle

import android.annotation.SuppressLint
import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

class SingleLiveEvent<T> : MutableLiveData<T>() {

    private val hasNotBeenHandled = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner, { t ->
            if (hasNotBeenHandled.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        })
    }

    @MainThread
    override fun setValue(value: T?) {
        hasNotBeenHandled.set(true)
        super.setValue(value)
    }
}

@SuppressLint("NullSafeMutableLiveData")
@MainThread
fun SingleLiveEvent<Nothing>.emit() {
    this.value = null
}

@SuppressLint("NullSafeMutableLiveData")
fun SingleLiveEvent<Nothing>.postEmit() {
    this.postValue(null)
}

@MainThread
fun <T> SingleLiveEvent<T>.emit(value: T) {
    this.value = value
}

@SinceKotlin("1.1")
fun <T> emptySingleLiveEvent(): SingleLiveEvent<T> = SingleLiveEvent()


