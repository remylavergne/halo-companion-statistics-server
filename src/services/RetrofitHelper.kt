package dev.remylavergne.halo.services

import io.ktor.application.Application
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {

    private lateinit var application: Application

    private val logging = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    private val client = OkHttpClient.Builder()
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
        .build()

    private val retrofitInstance: Retrofit = Retrofit.Builder()
        .baseUrl("https://www.haloapi.com/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun init(application: Application) {
        this.application = application
    }

    fun getMetadataService(): MetadataService = this.retrofitInstance.create(MetadataService::class.java)

    fun getProfileService(): ProfileService = this.retrofitInstance.create(ProfileService::class.java)

    fun getStatsService(): StatsService = this.retrofitInstance.create(StatsService::class.java)

    fun getUgcService(): UgcService = this.retrofitInstance.create(UgcService::class.java)

}