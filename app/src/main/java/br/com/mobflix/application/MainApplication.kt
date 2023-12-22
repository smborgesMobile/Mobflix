package br.com.mobflix.application

import android.app.Application
import br.com.mobflix.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)

            // Load Modules
            AppModule().loadModules()
        }
    }
}