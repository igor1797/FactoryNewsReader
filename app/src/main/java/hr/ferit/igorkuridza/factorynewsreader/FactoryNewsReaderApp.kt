package hr.ferit.igorkuridza.factorynewsreader

import android.app.Application
import android.content.Context

class FactoryNewsReaderApp: Application() {
    companion object {
        lateinit var instance: FactoryNewsReaderApp
            private set

        fun getAppContext(): Context = instance.applicationContext
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}