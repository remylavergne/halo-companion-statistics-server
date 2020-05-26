package dev.remylavergne.halo.services

import dev.remylavergne.halo.data.dto.profile.ProfileDto
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * API that provides Profile information about Players.
 */
interface ProfileService {

    @GET("profile/h5/profiles/{player}/appearance")
    suspend fun getAppearance(@Path("player") player: String): ProfileDto

}