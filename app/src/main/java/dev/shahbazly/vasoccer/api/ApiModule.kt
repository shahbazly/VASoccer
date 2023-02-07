package dev.shahbazly.vasoccer.api

import dev.shahbazly.vasoccer.network.AUTHORIZED
import dev.shahbazly.vasoccer.network.retrofitModule
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import retrofit2.Retrofit

val apiModule = Kodein.Module("Api") {
    importOnce(retrofitModule)

    bind() from provider { instance<Retrofit>(AUTHORIZED).create(MatchApi::class.java) }

}
