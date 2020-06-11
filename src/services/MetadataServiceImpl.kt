package dev.remylavergne.halo.services

import dev.remylavergne.halo.data.dto.metadata.*
import dev.remylavergne.halo.data.enums.Language
import dev.remylavergne.halo.helpers.MoshiHelper
import dev.remylavergne.halo.services.interfaces.MetadataService
import dev.remylavergne.halo.services.interfaces.ResponseListWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class MetadataServiceImpl(private val okHttpClient: OkHttpClient) : MetadataService {

    override suspend fun getCampaignMissions(language: Language): ResponseListWrapper<List<CampaignMissionsDto>>? {
        val url = "https://www.haloapi.com/metadata/h5/metadata/campaign-missions"
        return getList<CampaignMissionsDto>(url, language)
    }

    override suspend fun getCommendations(language: Language): ResponseListWrapper<List<CommendationsDto>>? {
        val url = "https://www.haloapi.com/metadata/h5/metadata/commendations"
        return getList<CommendationsDto>(url, language)
    }

    override suspend fun getCompanyCommendations(language: Language): ResponseListWrapper<List<CommendationsDto>>? {
        val url = "https://www.haloapi.com/metadata/h5/metadata/company-commendations"
        return getList<CommendationsDto>(url, language)
    }

    override suspend fun getCsrDesignations(language: Language): ResponseListWrapper<List<CsrDesignationsDto>>? {
        val url = "https://www.haloapi.com/metadata/h5/metadata/csr-designations"
        return getList<CsrDesignationsDto>(url, language)
    }

    override suspend fun getEnemies(language: Language): ResponseListWrapper<List<EnemiesDto>>? {
        val url = "https://www.haloapi.com/metadata/h5/metadata/enemies"
        return getList<EnemiesDto>(url, language)
    }

    override suspend fun getFlexibleStats(language: Language): ResponseListWrapper<List<FlexibleStatsDto>>? {
        val url = "https://www.haloapi.com/metadata/h5/metadata/flexible-stats"
        return getList<FlexibleStatsDto>(url, language)
    }

    override suspend fun getGameBaseVariants(language: Language): ResponseListWrapper<List<GameBaseVariantsDto>>? {
        val url = "https://www.haloapi.com/metadata/h5/metadata/game-base-variants"
        return getList<GameBaseVariantsDto>(url, language)
    }

    override suspend fun getGameVariant(id: String, language: Language): GameVariantsDto? {
        val url = "https://www.haloapi.com/metadata/h5/metadata/game-variants/$id"
        return getObject<GameVariantsDto>(url, language)
    }

    override suspend fun getImpulse(language: Language): ResponseListWrapper<List<ImpulseDto>>? {
        val url = "https://www.haloapi.com/metadata/h5/metadata/game-base-variants"
        return getList<ImpulseDto>(url, language)
    }

    override suspend fun getMapVariants(id: String, language: Language): MapVariants? {
        val url = "https://www.haloapi.com/metadata/h5/metadata/map-variants/$id"
        return getObject<MapVariants>(url, language)
    }

    override suspend fun getMap(language: Language): ResponseListWrapper<List<MapDto>>? {
        val url = "https://www.haloapi.com/metadata/h5/metadata/maps"
        return getList<MapDto>(url, language)
    }

    override suspend fun getMedals(language: Language): ResponseListWrapper<List<MedalDto>>? {
        val url = "https://www.haloapi.com/metadata/h5/metadata/medals"
        return getList<MedalDto>(url, language)
    }

    override suspend fun getPlaylists(language: Language): ResponseListWrapper<List<PlaylistDto>>? {
        val url = "https://www.haloapi.com/metadata/h5/metadata/playlists"
        return getList<PlaylistDto>(url, language)
    }

    override suspend fun getRequisitions(id: String, language: Language): ResponseListWrapper<List<RequisitionDto>>? {
        val url = "https://www.haloapi.com/metadata/h5/metadata/requisitions/$id"
        return getList<RequisitionDto>(url, language)
    }

    override suspend fun getRequisitionPack(id: String, language: Language): RequisitionPacksDto? {
        val url = "https://www.haloapi.com/metadata/h5/metadata/requisition-packs/$id"
        return getObject<RequisitionPacksDto>(url, language)
    }

    override suspend fun getSeasons(language: Language): ResponseListWrapper<List<SeasonDto>>? {
        val url = "https://www.haloapi.com/metadata/h5/metadata/seasons"
        return getList<SeasonDto>(url, language)
    }

    override suspend fun getSkulls(language: Language): ResponseListWrapper<List<SkullDto>>? {
        val url = "https://www.haloapi.com/metadata/h5/metadata/skulls"
        return getList<SkullDto>(url, language)
    }

    override suspend fun getSpartanRanks(language: Language): ResponseListWrapper<List<SpartanRankDto>>? {
        val url = "https://www.haloapi.com/metadata/h5/metadata/spartan-ranks"
        return getList<SpartanRankDto>(url, language)
    }

    override suspend fun getTeamColors(language: Language): ResponseListWrapper<List<TeamColorDto>>? {
        val url = "https://www.haloapi.com/metadata/h5/metadata/team-colors"
        return getList<TeamColorDto>(url, language)
    }

    override suspend fun getVehicules(language: Language): ResponseListWrapper<List<VehiculesDto>>? {
        val url = "https://www.haloapi.com/metadata/h5/metadata/vehicles"
        return getList<VehiculesDto>(url, language)
    }

    override suspend fun getWeapons(language: Language): ResponseListWrapper<List<WeaponDto>>? {
        val url = "https://www.haloapi.com/metadata/h5/metadata/weapons"
        return getList<WeaponDto>(url = url, language = language)
    }

    private suspend inline fun <reified T> getObject(url: String, language: Language): T? {
        val request: Request =
            Request.Builder()
                .url(url)
                .header("Accept-Language", language.value)
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

    private suspend inline fun <reified T> getList(url: String, language: Language): ResponseListWrapper<List<T>>? {
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
                    return@withContext ResponseListWrapperImpl(
                        ApiHeadersImpl(response.headers, language, url),
                        listAdapter.fromJson(it)
                    )
                }
            }
        } catch (error: Throwable) {
            println(error)
            null
        }
    }

    override suspend fun retrieveEveryMetadata(get: suspend MetadataService.() -> Unit) {
        return withContext(Dispatchers.IO) {
            get()
        }
    }
}