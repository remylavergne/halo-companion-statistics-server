package dev.remylavergne.halo.services.interfaces

import dev.remylavergne.halo.data.dto.halo5.CommendationsDto
import dev.remylavergne.halo.data.dto.metadata.CampaignMissionsDto
import dev.remylavergne.halo.data.enums.Language

/** API that provides Metadata information. */
interface MetadataService {

    suspend fun getCampaignMissions(language: Language): List<CampaignMissionsDto>

    suspend fun getCommendations(language: Language): List<CommendationsDto>
}