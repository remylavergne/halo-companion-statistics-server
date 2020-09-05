package dev.remylavergne.halo.services.interfaces

import dev.remylavergne.halo.data.dto.profile.ProfileCrop
import dev.remylavergne.halo.data.dto.profile.ProfileDto
import dev.remylavergne.halo.data.dto.profile.ProfileImageSize

/**
 * API that provides Profile information about Players.
 */
interface ProfileService {

    suspend fun getAppearance(player: String): ProfileDto?

    suspend fun getEmblem(player: String, size: String): String?

    suspend fun getSpartanImage(player: String, size: ProfileImageSize, crop: ProfileCrop): String?

}