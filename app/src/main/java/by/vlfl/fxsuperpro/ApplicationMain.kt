package by.vlfl.fxsuperpro

import android.app.Application
import by.vlfl.fxsuperpro.modules.networkModule
import by.vlfl.fxsuperpro.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApplicationMain : Application() {

    override fun onCreate() {
        super.onCreate()
        setUpKoin()
    }

    private fun setUpKoin(){
        startKoin {
            androidContext(this@ApplicationMain)
            modules(
                listOf(
                    networkModule,
                    viewModelModule
                )
            )
        }
    }
}