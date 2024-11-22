package edu.iesam.loginexam1eval.app

import android.app.Application
import edu.iesam.loginexam1eval.app.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.ksp.generated.module


class LoginApplication:Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@LoginApplication)
            // Load modules
            modules(
                AppModule().module
            )
        }
    }
}