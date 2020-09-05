package dev.remylavergne.halo.services

import dev.remylavergne.halo.data.dto.profile.ProfileCrop
import dev.remylavergne.halo.data.dto.profile.ProfileDto
import dev.remylavergne.halo.data.dto.profile.ProfileImageSize
import dev.remylavergne.halo.helpers.MoshiHelper
import dev.remylavergne.halo.services.interfaces.ProfileService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class ProfileServiceImpl(private val okHttpClient: OkHttpClient) : ProfileService {

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

    override suspend fun getEmblem(player: String, size: String): String? {
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/profile/h5/profiles/$player/emblem?size=$size").build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                return@withContext response.request.url.toString()
            }
        } catch (error: Throwable) {
            println(error)
            null
        }
    }

    override suspend fun getSpartanImage(player: String, size: ProfileImageSize, crop: ProfileCrop): String? {
        val request: Request =
            Request.Builder()
                .url("https://www.haloapi.com/profile/h5/profiles/$player/spartan?size=${size.value}&crop=${crop.value}")
                .build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                return@withContext response.request.url.toString()
            }
        } catch (error: Throwable) {
            println(error)
            null
        }
    }
}