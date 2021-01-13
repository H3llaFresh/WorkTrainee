package by.vlfl.fxsuperpro.modules

import by.vlfl.fxsuperpro.config.API_URL
import by.vlfl.fxsuperpro.data.remote.network.provideHttpApi
import by.vlfl.fxsuperpro.data.remote.network.provideHttpLoggingInterceptor
import by.vlfl.fxsuperpro.data.remote.network.provideOkHttpClient
import by.vlfl.fxsuperpro.ui.screens.splash.SplashViewModel
import by.vlfl.fxsuperpro.ui.screens.start.AuthorizationViewModel
import by.vlfl.fxsuperpro.ui.screens.start.intro.IntroViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val networkModule: Module = module {

    single { provideHttpLoggingInterceptor() }

    single { provideOkHttpClient(logging = get()) }

    single { provideHttpApi(
        baseUrl = API_URL,
        moshi = get(),
        okHttpClient = get()
    )}
}

val viewModelModule: Module = module {
    viewModel { SplashViewModel() }

    viewModel { AuthorizationViewModel() }

    viewModel { IntroViewModel() }
}