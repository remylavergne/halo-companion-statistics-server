package dev.remylavergne.halo.services.interfaces

import dev.remylavergne.halo.data.dto.halo5.CommendationsDto
import dev.remylavergne.halo.data.dto.halo5.CsrDesignationsDto
import dev.remylavergne.halo.data.dto.halo5.EnemiesDto
import dev.remylavergne.halo.data.dto.halo5.FlexibleStatsDto
import dev.remylavergne.halo.data.dto.metadata.CampaignMissionsDto
import dev.remylavergne.halo.data.enums.Language

/** API that provides Metadata information. */
interface MetadataService {

    suspend fun getCampaignMissions(language: Language): List<CampaignMissionsDto>

    suspend fun getCommendations(language: Language): List<CommendationsDto>

    suspend fun getCompanyCommendations(language: Language): List<CommendationsDto>

    suspend fun getCsrDesignations(language: Language): List<CsrDesignationsDto>

    suspend fun getEnemies(language: Language): List<EnemiesDto>

    suspend fun getFlexibleStats(language: Language): List<FlexibleStatsDto>
}