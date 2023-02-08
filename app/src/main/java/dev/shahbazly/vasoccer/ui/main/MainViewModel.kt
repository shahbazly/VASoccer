package dev.shahbazly.vasoccer.ui.main

import dev.shahbazly.vasoccer.base.common.BaseViewModel
import dev.shahbazly.vasoccer.base.extension.DataList
import dev.shahbazly.vasoccer.base.extension.Visible
import dev.shahbazly.vasoccer.model.Match
import dev.shahbazly.vasoccer.repositories.MatchesRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.kodein.di.Kodein
import org.kodein.di.generic.instance

class MainViewModel(kodein: Kodein) : BaseViewModel(kodein) {
    private val matchesRepository by instance<MatchesRepository>()

    val matchesDataList = DataList<Match>()

    val loadingProgressBarVisible = Visible(false)
    val errorMessageTextVisible = Visible(false)

    init {
        matchesRepository.fetchMatches(1982L)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                loadingProgressBarVisible.value = true
            }
            .subscribe({
                loadingProgressBarVisible.value = false
                matchesDataList.value = it
            }, {
                loadingProgressBarVisible.value = false
                errorMessageTextVisible.value = true
                it.printStackTrace()
            })
            .addToSubscriptions()
    }

}