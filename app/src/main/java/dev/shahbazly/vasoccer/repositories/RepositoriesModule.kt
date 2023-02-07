package dev.shahbazly.vasoccer.repositories

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

val repositoriesModule = Kodein.Module("Repositories") {
    bind() from provider { MatchesRepository(instance(), instance()) }
}