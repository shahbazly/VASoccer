package dev.shahbazly.vasoccer.network

import dev.shahbazly.vasoccer.BuildConfig
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitFactory {
    private val loggingInterceptor = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    fun createRx(
        baseUrl: String,
        connectTimeOutSeconds: Long = 5,
        readTimeoutSeconds: Long = 5
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(createOkHttpClientRx(connectTimeOutSeconds, readTimeoutSeconds))
            .build()

    private fun createOkHttpClientRx(connectTimeoutSeconds: Long, readTimeoutSeconds: Long) =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(connectTimeoutSeconds, TimeUnit.SECONDS)
            .readTimeout(readTimeoutSeconds, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val original = chain.request()
                val rb = original.newBuilder()
                val token = runBlocking { BuildConfig.API_KEY }
                val authHeader = original.headers["apikey"]
                if (authHeader.isNullOrEmpty()) rb.header("apikey", token)
                val request = rb.build()
                chain.proceed(request)
            }
            .build()
}
