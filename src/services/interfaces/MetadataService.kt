package dev.remylavergne.halo.services.interfaces

import dev.remylavergne.halo.data.dto.halo5.*
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


    /**
     * A list of game base variants for the title. There is no mechanism to determine which
     * game base variants are currently available for play. To determine which game base
     * variants a specific player has played, view the Service Record stats for that
     * player.There is no significance to the ordering.
     */
    suspend fun getGameBaseVariants(language: Language): List<GameBaseVariantsDto>

    /** A list of game variants for the title. There is no significance to the ordering. */
    suspend fun getGameVariant(id: String, language: Language): GameVariantsDto?


}