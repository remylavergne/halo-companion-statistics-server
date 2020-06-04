package dev.remylavergne.halo.services.interfaces

import dev.remylavergne.halo.data.dto.halo5.generics.CommendationsDto
import dev.remylavergne.halo.data.dto.halo5.CompanyDto
import dev.remylavergne.halo.data.dto.halo5.arena.MatchResultArenaDto
import dev.remylavergne.halo.data.dto.halo5.campaignmatch.CampaignMatchResultDto
import dev.remylavergne.halo.data.dto.halo5.matchs.custom.CustomMatchResultDto
import dev.remylavergne.halo.data.dto.halo5.matchs.history.PlayerMatchHistoryDto
import dev.remylavergne.halo.data.dto.halo5.matchs.warzone.WarzoneMatchResultDto
import dev.remylavergne.halo.data.dto.halo5.service.ArenaServiceRecordDto
import dev.remylavergne.halo.data.dto.halo5.service.CampaignServiceRecordDto
import dev.remylavergne.halo.data.enums.MatchMode

/**
 * API that provides statistical data about Players and Matches.
 */
interface StatsHalo5Service {

    suspend fun getCompany(id: String): CompanyDto?

    suspend fun getCompanyCommendations(companyId: String): CommendationsDto?

    suspend fun getArenaMatchResultStats(matchId: String): MatchResultArenaDto?

    /** Retrieves detailed statistics for a Match with the Campaign Game Mode. */
    suspend fun getCampaignMatchResult(matchId: String): CampaignMatchResultDto?

    /** Retrieves detailed statistics for a Match with the Custom Game Mode. */
    suspend fun getCustomMatchResult(matchId: String): CustomMatchResultDto?

    /** Retrieves detailed statistics for a Match with the Warzone Game Mode. */
    suspend fun getWarzoneMatchResult(matchId: String): WarzoneMatchResultDto?

    /** Retrieves the commendation state for a Player. */
    suspend fun getPlayerCommendations(player: String): CommendationsDto? //TODO => Test, si ce sont les mêmes données, renommer générique CommendationsDto

    /**
     * Retrieves a list of Matches that the Player has participated in and which have completed processing. If the Player is currently in a match, it is not returned in this API.
     * This endpoint will include games played on Local Servers with the Custom Local Game Mode for games that occurred or after December 22, 2017.
     * @param mode Mode -> custom, arena, ...
     * @param start pick up all matchs after this number. 0 == first match ever, 10 == pickup 11 and forward matches
     * @param count maximum items returned by service
     * @param
     */
    suspend fun getPlayerMatchHistory(
        player: String,
        mode: MatchMode? = null,
        start: String? = null,
        count: String? = null,
        includeTimes: Boolean? = null
    ): PlayerMatchHistoryDto?

    /** Retrieves Service Records for the Arena Game Mode for one or more players. A Service Record contains a player's lifetime statistics in the Game Mode. */
    suspend fun getPlayerServiceRecordsArena(
        players: List<String>,
        seasonId: String? = null
    ): ArenaServiceRecordDto?

    suspend fun getPlayerServiceRecordsCampaign(players: List<String>): CampaignServiceRecordDto?

}

    /** Retrieves Service Records for the Arena Game Mode for one or more players. A Service Record contains a player's lifetime statistics in the Game Mode. *//*


    /*/** Retrieves Service Records for the Campaign Game Mode for one or more players. A Service Record contains a player's lifetime statistics in the Game Mode. *//*


    *//**
     * Retrieves Service Records for the Custom Game Mode for one or more players. A Service Record contains a player's
     * lifetime statistics in the Game Mode. Games with the Custom Game Mode are played on Xbox Live Servers. For games
     * played on Local Servers, use the "Halo 5 - Player Service Records - Custom Local" Endpoint.
     *//*
    suspend fun getPlayerServiceRecordsCustom(players: List<String>): PlayerServiceRecordsCustomDto?

    *//** Retrieves Service Records for the Warzone Game Mode for one or more players. A Service Record contains a player's lifetime statistics in the Game Mode. *//*
    suspend fun getPlayerServiceRecordsWarzone(players: List<String>): PlayerServiceRecordsWarzoneDto?*/*/*/

