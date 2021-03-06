package dev.remylavergne.halo.helpers

import dev.remylavergne.halo.services.ServiceHttpErrorsInterceptor
import io.ktor.application.Application
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor


object OkHttpHelper {

    private lateinit var application: Application

    private val logging = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val request: Request = chain.request().newBuilder()
                    .addHeader(
                        "Ocp-Apim-Subscription-Key",
                        application.environment.config.property("halo-api-statistics.primary_key").getString()
                    ).build()
                return chain.proceed(request)
            }
        })
        .addInterceptor(ServiceHttpErrorsInterceptor())
        .build()

    fun init(application: Application) {
        OkHttpHelper.application = application
    }
}