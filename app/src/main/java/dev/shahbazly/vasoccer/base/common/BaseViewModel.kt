package dev.shahbazly.vasoccer.base.common

import androidx.annotation.StringRes
import dev.shahbazly.vasoccer.SoccerApplication
import dev.shahbazly.vasoccer.base.extension.Command
import dev.shahbazly.vasoccer.base.extension.TCommand
import io.reactivex.disposables.Disposable
import org.kodein.di.Kodein

abstract class BaseViewModel(kodein: Kodein) : KodeinViewModel(kodein) {
    private val subscriptions: MutableList<Disposable> = mutableListOf()

    val closeCommand = dev.shahbazly.vasoccer.base.extension.Command()
    val showShortToastCommand = dev.shahbazly.vasoccer.base.extension.TCommand<String>()

    fun Disposable.addToSubscriptions() {
        subscriptions.add(this)
    }

    protected fun getString(@StringRes resId: Int, vararg formatArgs: Any): String =
        SoccerApplication.applicationContext().getString(resId, *formatArgs)

    override fun onCleared() {
        super.onCleared()

        subscriptions.forEach { it.dispose() }
        subscriptions.clear()
    }
}

