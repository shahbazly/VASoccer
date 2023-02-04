package dev.shahbazly.vasoccer.base.extension

import androidx.lifecycle.MutableLiveData
import dev.shahbazly.vasoccer.base.livedata.LiveArgEvent
import dev.shahbazly.vasoccer.base.livedata.LiveEvent

typealias Data<T> = MutableLiveData<T>
typealias Text = MutableLiveData<String>
typealias DataList<T> = MutableLiveData<List<T>>

typealias Visible = MutableLiveData<Boolean>

typealias Command = LiveEvent
typealias TCommand<T> = LiveArgEvent<T>