package dev.shahbazly.vasoccer.ui.webview

import dev.shahbazly.vasoccer.base.common.BaseViewModel
import dev.shahbazly.vasoccer.base.extension.Data
import dev.shahbazly.vasoccer.base.extension.Visible
import org.kodein.di.Kodein

const val MAX_PROGRESS = 100

class WebViewModel(kodein: Kodein) : BaseViewModel(kodein) {

    val progressViewVisible = Visible(true)
    val pageLoadingProgress = Data<Int>()

    fun changeProgress(newProgress: Int) {
        pageLoadingProgress.value = newProgress
        progressViewVisible.value = newProgress != MAX_PROGRESS
    }
}