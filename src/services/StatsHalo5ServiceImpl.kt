package dev.remylavergne.halo.services

import dev.remylavergne.halo.data.dto.halo5.CompanyDto
import dev.remylavergne.halo.data.dto.halo5.arena.MatchResultArenaDto
import dev.remylavergne.halo.data.dto.halo5.campaignmatch.CampaignMatchResultDto
import dev.remylavergne.halo.data.dto.halo5.generics.CommendationsDto
import dev.remylavergne.halo.data.dto.halo5.matchs.custom.CustomMatchResultDto
import dev.remylavergne.halo.data.dto.halo5.matchs.history.PlayerMatchHistoryDto
import dev.remylavergne.halo.data.dto.halo5.matchs.warzone.WarzoneMatchResultDto
import dev.remylavergne.halo.data.dto.halo5.service.ArenaServiceRecordDto
import dev.remylavergne.halo.data.dto.halo5.service.CampaignServiceRecordDto
import dev.remylavergne.halo.data.enums.Language
import dev.remylavergne.halo.data.enums.MatchMode
import dev.remylavergne.halo.helpers.MoshiHelper
import dev.remylavergne.halo.services.interfaces.StatsHalo5Service
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class StatsHalo5ServiceImpl(private val okHttpClient: OkHttpClient) : StatsHalo5Service {

    override suspend fun getCompany(id: String): CompanyDto? {
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/stats/h5/companies/$id").build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val adapter = MoshiHelper.getAdapter(CompanyDto::class.java)
                response.body?.string()?.let { json: String ->
                    return@withContext adapter.fromJson(json)
                }
            }
        } catch (error: Throwable) {
            println(error)
            null
        }
    }

    override suspend fun getCompanyCommendations(companyId: String): CommendationsDto? {
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/stats/h5/companies/$companyId/commendations").build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val adapter = MoshiHelper.getAdapter(CommendationsDto::class.java)
                response.body?.string()?.let { json: String ->
                    return@withContext adapter.fromJson(json)
                }
            }
        } catch (error: Throwable) {
            println(error)
            null
        }
    }

    override suspend fun getArenaMatchResultStats(matchId: String): MatchResultArenaDto? {
        val url = "https://www.haloapi.com/stats/h5/arena/matches/$matchId"
        return getObject<MatchResultArenaDto>(url)
    }

    override suspend fun getCampaignMatchResult(matchId: String): CampaignMatchResultDto? {
        val url = "https://www.haloapi.com/stats/h5/custom/matches/$matchId"
        return getObject<CampaignMatchResultDto>(url)
    }

    override suspend fun getCustomMatchResult(matchId: String): CustomMatchResultDto? {
        val url = "https://www.haloapi.com/stats/h5/custom/matches/$matchId"
        return getObject<CustomMatchResultDto>(url)
    }

    override suspend fun getWarzoneMatchResult(matchId: String): WarzoneMatchResultDto? {
        val url = "https://www.haloapi.com/stats/h5/warzone/matches/$matchId"
        return getObject<WarzoneMatchResultDto>(url)
    }

    override suspend fun getPlayerCommendations(player: String): CommendationsDto? {
        val url = "https://www.haloapi.com/stats/h5/players/$player/commendations\n"
        return getObject<CommendationsDto>(url)
    }


    override suspend fun getPlayerMatchHistory(
        player: String,
        mode: MatchMode?,
        start: String?,
        count: String?,
        includeTimes: Boolean?
    ): PlayerMatchHistoryDto? {
        // Make Query Parameters
        val queryParams = mutableMapOf<String, String>()
        mode?.let { queryParams["mode"] = it.value }
        start?.let { queryParams["start"] = it }
        count?.let { queryParams["count"] = it }
        includeTimes?.let { queryParams["include-times"] = it.toString() }

        val url = "https://www.haloapi.com/stats/h5/players/$player/matches"
        return getObject<PlayerMatchHistoryDto>(url, queryParams)
    }


    override suspend fun getPlayerServiceRecordsArena(
        players: List<String>,
        seasonId: String?
    ): ArenaServiceRecordDto? {
        // Make Query Parameters
        val queryParams = mutableMapOf<String, String>()
        seasonId?.let { queryParams["seasonId"] = it }

        val url = "https://www.haloapi.com/stats/h5/servicerecords/arena?players=${players.joinToString(",")}"
        return getObject(url, queryParams)
    }

    override suspend fun getPlayerServiceRecordsCampaign(players: List<String>): CampaignServiceRecordDto? {
        val url = "https://www.haloapi.com/stats/h5/servicerecords/campaign?players=${players.joinToString(",")}"
        return getObject(url)
    }
/*

    override suspend fun getPlayerServiceRecordsCustom(players: List<String>): PlayerServiceRecordsCustom? {
        TODO("Not yet implemented")
    }

    override suspend fun getPlayerServiceRecordsWarzone(players: List<String>): PlayerServiceRecordsWarzone? {
        TODO("Not yet implemented")
    }
*/

    /**
     * Generics functions
     */

    private suspend inline fun <reified T> getObject(url: String, queryParams: Map<String, String>? = null): T? {
        // Make HttpUrl
        val httpBuilder = url.toHttpUrl().newBuilder()
        // Add Query Parameters
        queryParams?.forEach { params ->
            httpBuilder.addQueryParameter(params.key, params.value)
        }

        val request: Request =
            Request.Builder()
                .url(httpBuilder.build())
                .build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val listAdapter = MoshiHelper.getAdapter(T::class.java)
                response.body?.string()?.let {
                    return@withContext listAdapter.fromJson(it)
                }
            }
        } catch (error: Throwable) {
            println(error)
            null
        }
    }

    private suspend inline fun <reified T> getList(url: String, language: Language): List<T> {
        val request: Request =
            Request.Builder()
                .url(url)
                .header("Accept-Language", language.value)
                .build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val listAdapter = MoshiHelper.getListAdapter(T::class.java)
                response.body?.string()?.let {
                    return@withContext listAdapter.fromJson(it)
                }
            }
        } catch (error: Throwable) {
            println(error)
            emptyList<T>()
        } ?: emptyList<T>()
    }
}