package dev.shahbazly.vasoccer.network

import dev.shahbazly.vasoccer.BuildConfig
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import org.kodein.di.generic.with
import retrofit2.Retrofit

const val AUTHORIZED = "Retrofit"

const val SUPABASE_URL = "apiUrl"

val retrofitModule = Kodein.Module("RetrofitModule") {
    constant(SUPABASE_URL) with BuildConfig.BASE_URL

    bind<Retrofit>(AUTHORIZED) with singleton { RetrofitFactory.createRx(instance(SUPABASE_URL)) }
}
