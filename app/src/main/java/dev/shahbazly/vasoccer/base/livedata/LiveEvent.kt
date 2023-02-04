package dev.shahbazly.vasoccer.base.livedata

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

class LiveEvent : () -> Unit {
    private val liveData = SingleLiveEvent<Void>()

    fun observe(owner: LifecycleOwner, observer: Observer<Void>) = liveData.observe(owner, observer)

    @MainThread
    fun call() {
        liveData.value = null
    }

    override fun invoke() = call()
}