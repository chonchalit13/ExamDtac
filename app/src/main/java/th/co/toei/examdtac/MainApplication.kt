package th.co.toei.examdtac

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import th.co.toei.examdtac.di.serviceModule
import th.co.toei.examdtac.di.viewModelModule

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            loadKoinModules(listOf(serviceModule, viewModelModule))
        }
    }
}