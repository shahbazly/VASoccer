package dev.shahbazly.vasoccer.base.common

import android.view.View
import android.widget.TextView
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import dev.shahbazly.vasoccer.base.extension.Text
import dev.shahbazly.vasoccer.base.extension.Visible
import dev.shahbazly.vasoccer.base.livedata.LiveArgEvent
import dev.shahbazly.vasoccer.base.livedata.LiveEvent

interface FragmentScene {
    val self: Fragment

    fun <T> LifecycleOwner.bind(liveData: MutableLiveData<T>, action: (T) -> Unit) {
        liveData.observe(this) { action(it) }
    }

    fun LifecycleOwner.bindVisible(
        liveData: Visible,
        view: View,
        invisible: Boolean = false,
        action: ((Boolean) -> Unit)? = null
    ) =
        liveData.observe(self.viewLifecycleOwner) {
            if (invisible) view.isInvisible = it
            else view.isVisible = it

            action?.invoke(it)
        }

    fun <T> LifecycleOwner.bindCommand(liveEvent: LiveArgEvent<T>, action: (T) -> Unit) {
        liveEvent.observe(this) { action(it) }
    }

    fun LifecycleOwner.bindCommand(liveEvent: LiveEvent, action: () -> Unit) {
        liveEvent.observe(this) { action() }
    }

    fun LifecycleOwner.bindText(liveData: Text, textView: TextView) {
        liveData.observe(self.viewLifecycleOwner) { textView.text = liveData.value }
    }
}

