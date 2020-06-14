package dev.remylavergne.halo.services.interfaces

import dev.remylavergne.halo.data.enums.Language

/** API that provides Metadata information. */
interface MetadataService {

    suspend fun getCampaignMissions(language: Language): ResponseWrapper<List<*>>

    suspend fun getCommendations(language: Language): ResponseWrapper<List<*>>

    suspend fun getCompanyCommendations(language: Language): ResponseWrapper<List<*>>

    suspend fun getCsrDesignations(language: Language): ResponseWrapper<List<*>>

    suspend fun getEnemies(language: Language): ResponseWrapper<List<*>>

    suspend fun getFlexibleStats(language: Language): ResponseWrapper<List<*>>


    /**
     * A list of game base variants for the title. There is no mechanism to determine which
     * game base variants are currently available for play. To determine which game base
     * variants a specific player has played, view the Service Record stats for that
     * player.There is no significance to the ordering.
     */
    suspend fun getGameBaseVariants(language: Language): ResponseWrapper<List<*>>

    /** A list of game variants for the title. There is no significance to the ordering. */
    suspend fun getGameVariant(id: String, language: Language): ResponseWrapper<*>?

    /**
     * A list of impulses (essentially invisible medals) for the title. There is no
     * significance to the ordering.
     */
    suspend fun getImpulse(language: Language): ResponseWrapper<List<*>>

    /** A list of map variants for the title. There is no significance to the ordering. */
    suspend fun getMapVariants(id: String, language: Language): ResponseWrapper<*>?

    /** A list of maps for the title. There is no significance to the ordering. */
    suspend fun getMap(language: Language): ResponseWrapper<List<*>>

    /** A list of medals for the title. There is no significance to the ordering. */
    suspend fun getMedals(language: Language): ResponseWrapper<List<*>>

    /**
     * A list of playlists for the title. To determine which playlists a specific player has
     * played within, view the Service Record stats for that player. There is no significance
     * to the ordering.
     */
    suspend fun getPlaylists(language: Language): ResponseWrapper<List<*>>

    /** A list of requisitions for the title. There is no significance to the ordering. */
    suspend fun getRequisitions(id: String, language: Language): ResponseWrapper<List<*>>

    /** A requisition pack for the title. */
    suspend fun getRequisitionPack(id: String, language: Language): ResponseWrapper<*>?

    /** A list of seasons for the title. There is no significance to the ordering. */
    suspend fun getSeasons(language: Language): ResponseWrapper<List<*>>

    /** A list of skulls for the title. There is no significance to the ordering. */
    suspend fun getSkulls(language: Language): ResponseWrapper<List<*>>

    /** A list of Spartan Ranks for the title. There is no significance to the ordering. */
    suspend fun getSpartanRanks(language: Language): ResponseWrapper<List<*>>

    /** A listing of team colors supported in the title. There is no significance to the ordering. */
    suspend fun getTeamColors(language: Language): ResponseWrapper<List<*>>

    /** A list of vehicles for the title. There is no significance to the ordering. */
    suspend fun getVehicules(language: Language): ResponseWrapper<List<*>>

    /** A listing of weapons supported in the title. There is no significance to the ordering. */
    suspend fun getWeapons(language: Language): ResponseWrapper<List<*>>

    suspend fun retrieveTheseMetadata(get: suspend MetadataService.() -> Unit)

}