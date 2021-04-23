package th.co.toei.examdtac.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import th.co.toei.examdtac.network.ApiService
import th.co.toei.examdtac.network.EndpointInterface
import th.co.toei.examdtac.viewmodel.MainViewModel

val serviceModule = module {
    single { ApiService() }
}

val viewModelModule = module {
    viewModel {
        val apiService: ApiService = get()
        MainViewModel(apiService.getEndpointInterface(EndpointInterface::class.java))
    }
}
