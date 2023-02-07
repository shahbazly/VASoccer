package dev.shahbazly.vasoccer

import android.content.Context
import dev.shahbazly.vasoccer.api.apiModule
import dev.shahbazly.vasoccer.base.common.KodeinApplication
import dev.shahbazly.vasoccer.repositories.repositoriesModule
import kotlinx.coroutines.DEBUG_PROPERTY_NAME
import kotlinx.coroutines.DEBUG_PROPERTY_VALUE_ON
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.singleton
import org.kodein.di.generic.bind

class SoccerApplication : KodeinApplication(), KodeinAware {

    init {
        if (BuildConfig.DEBUG) {
            System.setProperty(DEBUG_PROPERTY_NAME, DEBUG_PROPERTY_VALUE_ON)
        }

        instance = this
    }

    override val rootModule = Kodein.Module("Root") {
        import(module)
        import(apiModule)
        import(repositoriesModule)
    }

    companion object {
        private val module = Kodein.Module("Application") {
            bind() from singleton {
                instance.applicationContext.getSharedPreferences("soccer_app", Context.MODE_PRIVATE)
            }
        }

        lateinit var instance: SoccerApplication

        fun applicationContext(): Context {
            return instance.applicationContext
        }
    }
}