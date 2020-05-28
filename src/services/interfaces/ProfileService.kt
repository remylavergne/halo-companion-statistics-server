package dev.remylavergne.halo.services.interfaces

import dev.remylavergne.halo.data.dto.profile.ProfileDto

/**
 * API that provides Profile information about Players.
 */
interface ProfileService {

    val appearanceEndpoint: String
    val emblemEndpoint: String

    suspend fun getAppearance(player: String): ProfileDto?

    suspend fun getEmblem(player: String, size: String = "128"): String

}