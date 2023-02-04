package dev.shahbazly.vasoccer.base.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

abstract class KodeinViewModel(override val kodein: Kodein) : ViewModel(), KodeinAware {

    fun <T> mutableLiveData(initValue: T) = MutableLiveData<T>().apply { value = initValue }

    fun <T> MutableLiveData<T>.immutable() = this as LiveData<T>
}