package dev.remylavergne.halo.services.interfaces

import dev.remylavergne.halo.data.dto.metadata.*
import dev.remylavergne.halo.data.enums.Language
import dev.remylavergne.halo.services.ResponseListWrapperImpl

/** API that provides Metadata information. */
interface MetadataService {

    suspend fun getCampaignMissions(language: Language): ResponseListWrapper<List<CampaignMissionsDto>>?

    suspend fun getCommendations(language: Language): ResponseListWrapper<List<CommendationsDto>>?

    suspend fun getCompanyCommendations(language: Language): ResponseListWrapper<List<CommendationsDto>>?

    suspend fun getCsrDesignations(language: Language): ResponseListWrapper<List<CsrDesignationsDto>>?

    suspend fun getEnemies(language: Language): ResponseListWrapper<List<EnemiesDto>>?

    suspend fun getFlexibleStats(language: Language): ResponseListWrapper<List<FlexibleStatsDto>>?


    /**
     * A list of game base variants for the title. There is no mechanism to determine which
     * game base variants are currently available for play. To determine which game base
     * variants a specific player has played, view the Service Record stats for that
     * player.There is no significance to the ordering.
     */
    suspend fun getGameBaseVariants(language: Language): ResponseListWrapper<List<GameBaseVariantsDto>>?

    /** A list of game variants for the title. There is no significance to the ordering. */
    suspend fun getGameVariant(id: String, language: Language): GameVariantsDto?

    /**
     * A list of impulses (essentially invisible medals) for the title. There is no
     * significance to the ordering.
     */
    suspend fun getImpulse(language: Language): ResponseListWrapper<List<ImpulseDto>>?

    /** A list of map variants for the title. There is no significance to the ordering. */
    suspend fun getMapVariants(id: String, language: Language): MapVariants?

    /** A list of maps for the title. There is no significance to the ordering. */
    suspend fun getMap(language: Language): ResponseListWrapper<List<MapDto>>?

    /** A list of medals for the title. There is no significance to the ordering. */
    suspend fun getMedals(language: Language): ResponseListWrapper<List<MedalDto>>?

    /**
     * A list of playlists for the title. To determine which playlists a specific player has
     * played within, view the Service Record stats for that player. There is no significance
     * to the ordering.
     */
    suspend fun getPlaylists(language: Language): ResponseListWrapper<List<PlaylistDto>>?

    /** A list of requisitions for the title. There is no significance to the ordering. */
    suspend fun getRequisitions(id: String, language: Language): ResponseListWrapper<List<RequisitionDto>>?

    /** A requisition pack for the title. */
    suspend fun getRequisitionPack(id: String, language: Language): RequisitionPacksDto?

    /** A list of seasons for the title. There is no significance to the ordering. */
    suspend fun getSeasons(language: Language): ResponseListWrapper<List<SeasonDto>>?

    /** A list of skulls for the title. There is no significance to the ordering. */
    suspend fun getSkulls(language: Language): ResponseListWrapper<List<SkullDto>>?

    /** A list of Spartan Ranks for the title. There is no significance to the ordering. */
    suspend fun getSpartanRanks(language: Language): ResponseListWrapper<List<SpartanRankDto>>?

    /** A listing of team colors supported in the title. There is no significance to the ordering. */
    suspend fun getTeamColors(language: Language): ResponseListWrapper<List<TeamColorDto>>?

    /** A list of vehicles for the title. There is no significance to the ordering. */
    suspend fun getVehicules(language: Language): ResponseListWrapper<List<VehiculesDto>>?

    /** A listing of weapons supported in the title. There is no significance to the ordering. */
    suspend fun getWeapons(language: Language): ResponseListWrapper<List<WeaponDto>>?

    suspend fun retrieveEveryMetadata(get: suspend MetadataService.() -> Unit)

}