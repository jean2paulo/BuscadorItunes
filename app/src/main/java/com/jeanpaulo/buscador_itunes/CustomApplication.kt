package com.jeanpaulo.buscador_itunes

import android.app.Application
import android.content.res.Configuration
import com.facebook.stetho.Stetho
import com.jeanpaulo.buscador_itunes.datasource.IDataSource
import com.jeanpaulo.buscador_itunes.datasource.ServiceLocator

class CustomApplication : Application() {

    // Called when the application is starting, before any other application objects have been created.
    // Overriding this method is totally optional!

    // Depends on the flavor,
    val musicRepository: IDataSource
        get() = ServiceLocator.provideMusicRepository(this)

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)
        //DEBUG CODE
        if (BuildConfig.DEBUG) {
            //Timber.plant(Timber.DebugTree());
        }
    }

    // Called by the system when the device configuration changes while your component is running.
    // Overriding this method is totally optional!
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    // This is called when the overall system is running low on memory,
    // and would like actively running processes to tighten their belts.
    // Overriding this method is totally optional!
    override fun onLowMemory() {
        super.onLowMemory()
    }

    fun isDebuging() = BuildConfig.DEBUG
}