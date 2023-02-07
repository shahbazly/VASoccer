package dev.shahbazly.vasoccer.ui.main

import dev.shahbazly.vasoccer.base.common.BaseViewModel
import dev.shahbazly.vasoccer.base.extension.DataList
import dev.shahbazly.vasoccer.model.Match
import dev.shahbazly.vasoccer.repositories.MatchesRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.kodein.di.Kodein
import org.kodein.di.generic.instance

class MainViewModel(kodein: Kodein) : BaseViewModel(kodein) {
    private val matchesRepository by instance<MatchesRepository>()

    val matchesDataList = DataList<Match>()

    init {
        matchesRepository.fetchMatches(1982L)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                matchesDataList.value = it
            }, {
                it.printStackTrace()
            })
            .addToSubscriptions()
    }

}