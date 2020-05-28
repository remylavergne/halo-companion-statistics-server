package dev.remylavergne.halo.services

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dev.remylavergne.halo.data.dto.profile.ModifiedUtcDto
import dev.remylavergne.halo.data.dto.profile.ProfileDto
import dev.remylavergne.halo.services.interfaces.ProfileService
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class ProfileServiceImpl(private val okHttpClient: OkHttpClient) : ProfileService {

    override val appearanceEndpoint: String
        get() = "https://www.haloapi.com/profile/h5/profiles/{player}/appearance"
    override val emblemEndpoint: String
        get() = "https://www.haloapi.com/profile/h5/profiles/{player}/emblem"


    override suspend fun getAppearance(player: String): ProfileDto? {
        val request: Request = Request.Builder().url("https://www.haloapi.com/profile/h5/profiles/$player/appearance").build()

        return try {
            val response: Response = okHttpClient.newCall(request).execute()
            val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            val jsonAdapter: JsonAdapter<ProfileDto> = moshi.adapter(ProfileDto::class.java)
            val profileDto: ProfileDto? = jsonAdapter.fromJson(response.body?.string())

            profileDto
        } catch (error: Throwable) {
            println(error)
            null
        }
    }

    override suspend fun getEmblem(player: String, size: String): String {
        TODO("Not yet implemented")
    }


}