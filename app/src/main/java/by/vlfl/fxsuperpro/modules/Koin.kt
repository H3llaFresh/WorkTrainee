package by.vlfl.fxsuperpro.modules

import by.vlfl.fxsuperpro.data.IRemoteReferencesDataSource
import by.vlfl.fxsuperpro.data.remote.ReferencesDataSource
import by.vlfl.fxsuperpro.domain.ICountryGateway
import by.vlfl.fxsuperpro.domain.usecase.GetCountriesOfResidence
import by.vlfl.fxsuperpro.gateway.CountryGateway
import by.vlfl.fxsuperpro.ui.screens.main.MainViewModel
import by.vlfl.fxsuperpro.ui.screens.splash.SplashViewModel
import by.vlfl.fxsuperpro.ui.screens.start.AuthorizationViewModel
import by.vlfl.fxsuperpro.ui.screens.start.intro.IntroViewModel
import by.vlfl.fxsuperpro.ui.screens.start.signup.step1.SignUpStep1ViewModel
import by.vlfl.fxsuperpro.ui.screens.start.signup.step1.countryOfResidence.CountryOfResidenceViewModel
import by.vlfl.fxsuperpro.ui.screens.start.signup.step2.SignUpStep2ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

//val networkModule: Module = module {
//
//    single { provideHttpLoggingInterceptor() }
//
//    single { provideOkHttpClient(logging = get()) }
//
//    single { provideHttpApi(
//        baseUrl = API_URL,
//        moshi = get(),
//        okHttpClient = get()
//    )}
//}

val viewModelModule: Module = module {
    viewModel { SplashViewModel() }

    viewModel { AuthorizationViewModel() }

    viewModel { IntroViewModel() }

    viewModel { MainViewModel() }

    viewModel { SignUpStep1ViewModel() }

    viewModel { SignUpStep2ViewModel() }

    viewModel { CountryOfResidenceViewModel(getCountriesOfResidence = get()) }
}

val dataSourceModule: Module = module {
    single<IRemoteReferencesDataSource> { ReferencesDataSource() }
}

val gatewayModule: Module = module {
    single<ICountryGateway> { CountryGateway(remote = get()) }
}

val useCaseModule: Module = module {
    factory { GetCountriesOfResidence(countryGateway = get()) }
}