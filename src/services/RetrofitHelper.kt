package dev.remylavergne.halo.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {

    private val retrofitInstance: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getMetadataService(): MetadataService = this.retrofitInstance.create(MetadataService::class.java)

    fun getProfileService(): ProfileService = this.retrofitInstance.create(ProfileService::class.java)

    fun getStatsService(): StatsService = this.retrofitInstance.create(StatsService::class.java)

    fun getUgcService(): UgcService = this.retrofitInstance.create(UgcService::class.java)

}