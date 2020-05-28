package dev.remylavergne.halo.services

import dev.remylavergne.halo.data.dto.profile.ProfileDto
import dev.remylavergne.halo.services.interfaces.ProfileService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class ProfileServiceImpl(private val okHttpClient: OkHttpClient) : ProfileService {

    override val appearanceEndpoint: String
        get() = "https://www.haloapi.com/profile/h5/profiles/{player}/appearance"
    override val emblemEndpoint: String
        get() = "https://www.haloapi.com/profile/h5/profiles/{player}/emblem"


    override suspend fun getAppearance(player: String): ProfileDto? {
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/profile/h5/profiles/$player/appearance").build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val adapter = MoshiHelper.getAdapter(ProfileDto::class.java)
                return@withContext adapter.fromJson(response.body?.string())
            }
        } catch (error: Throwable) {
            println(error)
            null
        }
    }

    override suspend fun getEmblem(player: String, size: String): String {
        TODO("Not yet implemented")
    }


}