package dev.remylavergne.halo.services

import dev.remylavergne.halo.data.dto.halo5.*
import dev.remylavergne.halo.data.dto.metadata.CampaignMissionsDto
import dev.remylavergne.halo.data.enums.Language
import dev.remylavergne.halo.services.interfaces.MetadataService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

// TODO => Save all these informations into our database
// TODO => Refactor avec une méthode générique.
class MetadataServiceImpl(private val okHttpClient: OkHttpClient) : MetadataService {

    override suspend fun getCampaignMissions(language: Language): List<CampaignMissionsDto> {
        val url = "https://www.haloapi.com/metadata/h5/metadata/campaign-missions"
        return getList<CampaignMissionsDto>(url, language)
    }

    override suspend fun getCommendations(language: Language): List<CommendationsDto> {
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/metadata/h5/metadata/commendations")
                .header("Accept-Language", language.value).build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val listAdapter = MoshiHelper.getListAdapter(CommendationsDto::class.java)
                response.body?.string()?.let {
                    return@withContext listAdapter.fromJson(it)
                }
            }
        } catch (error: Throwable) {
            println(error)
            emptyList<CommendationsDto>()
        } ?: emptyList<CommendationsDto>()
    }

    override suspend fun getCompanyCommendations(language: Language): List<CommendationsDto> {
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/metadata/h5/metadata/company-commendations")
                .header("Accept-Language", language.value).build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val listAdapter = MoshiHelper.getListAdapter(CommendationsDto::class.java)
                response.body?.string()?.let {
                    return@withContext listAdapter.fromJson(it)
                }
            }
        } catch (error: Throwable) {
            println(error)
            emptyList<CommendationsDto>()
        } ?: emptyList<CommendationsDto>()
    }

    override suspend fun getCsrDesignations(language: Language): List<CsrDesignationsDto> {
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/metadata/h5/metadata/csr-designations")
                .header("Accept-Language", language.value).build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val listAdapter = MoshiHelper.getListAdapter(CsrDesignationsDto::class.java)
                response.body?.string()?.let {
                    return@withContext listAdapter.fromJson(it)
                }
            }
        } catch (error: Throwable) {
            println(error)
            emptyList<CsrDesignationsDto>()
        } ?: emptyList<CsrDesignationsDto>()
    }

    override suspend fun getEnemies(language: Language): List<EnemiesDto> {
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/metadata/h5/metadata/enemies")
                .header("Accept-Language", language.value).build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val listAdapter = MoshiHelper.getListAdapter(EnemiesDto::class.java)
                response.body?.string()?.let {
                    return@withContext listAdapter.fromJson(it)
                }
            }
        } catch (error: Throwable) {
            println(error)
            emptyList<EnemiesDto>()
        } ?: emptyList<EnemiesDto>()
    }

    override suspend fun getFlexibleStats(language: Language): List<FlexibleStatsDto> {
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/metadata/h5/metadata/flexible-stats")
                .header("Accept-Language", language.value).build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val listAdapter = MoshiHelper.getListAdapter(FlexibleStatsDto::class.java)
                response.body?.string()?.let {
                    return@withContext listAdapter.fromJson(it)
                }
            }
        } catch (error: Throwable) {
            println(error)
            emptyList<FlexibleStatsDto>()
        } ?: emptyList<FlexibleStatsDto>()
    }

    override suspend fun getGameBaseVariants(language: Language): List<GameBaseVariantsDto> {
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/metadata/h5/metadata/game-base-variants")
                .header("Accept-Language", language.value).build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val listAdapter = MoshiHelper.getListAdapter(GameBaseVariantsDto::class.java)
                response.body?.string()?.let {
                    return@withContext listAdapter.fromJson(it)
                }
            }
        } catch (error: Throwable) {
            println(error)
            emptyList<GameBaseVariantsDto>()
        } ?: emptyList<GameBaseVariantsDto>()
    }

    override suspend fun getGameVariant(id: String, language: Language): GameVariantsDto? {
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/metadata/h5/metadata/game-variants/$id")
                .header("Accept-Language", language.value).build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val listAdapter = MoshiHelper.getAdapter(GameVariantsDto::class.java)
                response.body?.string()?.let {
                    return@withContext listAdapter.fromJson(it)
                }
            }
        } catch (error: Throwable) {
            println(error)
            null
        }
    }

    override suspend fun getImpulse(language: Language): List<ImpulseDto> {
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/metadata/h5/metadata/game-base-variants")
                .header("Accept-Language", language.value).build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val listAdapter = MoshiHelper.getListAdapter(ImpulseDto::class.java)
                response.body?.string()?.let {
                    return@withContext listAdapter.fromJson(it)
                }
            }
        } catch (error: Throwable) {
            println(error)
            emptyList<ImpulseDto>()
        } ?: emptyList<ImpulseDto>()
    }

    override suspend fun getMapVariants(id: String, language: Language): MapVariants? {
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/metadata/h5/metadata/map-variants/$id")
                .header("Accept-Language", language.value).build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val listAdapter = MoshiHelper.getAdapter(MapVariants::class.java)
                response.body?.string()?.let {
                    return@withContext listAdapter.fromJson(it)
                }
            }
        } catch (error: Throwable) {
            println(error)
            null
        }
    }

    override suspend fun getMap(language: Language): List<MapDto> {
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/metadata/h5/metadata/maps")
                .header("Accept-Language", language.value).build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val listAdapter = MoshiHelper.getListAdapter(MapDto::class.java)
                response.body?.string()?.let {
                    return@withContext listAdapter.fromJson(it)
                }
            }
        } catch (error: Throwable) {
            println(error)
            emptyList<MapDto>()
        } ?: emptyList<MapDto>()
    }

    override suspend fun getMedals(language: Language): List<MedalDto> {
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/metadata/h5/metadata/medals")
                .header("Accept-Language", language.value).build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val listAdapter = MoshiHelper.getListAdapter(MedalDto::class.java)
                response.body?.string()?.let {
                    return@withContext listAdapter.fromJson(it)
                }
            }
        } catch (error: Throwable) {
            println(error)
            emptyList<MedalDto>()
        } ?: emptyList<MedalDto>()
    }

    override suspend fun getPlaylists(language: Language): List<PlaylistDto> {
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/metadata/h5/metadata/playlists")
                .header("Accept-Language", language.value).build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val listAdapter = MoshiHelper.getListAdapter(PlaylistDto::class.java)
                response.body?.string()?.let {
                    return@withContext listAdapter.fromJson(it)
                }
            }
        } catch (error: Throwable) {
            println(error)
            emptyList<PlaylistDto>()
        } ?: emptyList<PlaylistDto>()
    }

    override suspend fun getRequisitions(id: String, language: Language): List<RequisitionDto> {
        val url = "https://www.haloapi.com/metadata/h5/metadata/requisitions/$id"
        return getList<RequisitionDto>(url, language)
    }

    override suspend fun getRequisitionPack(id: String, language: Language): RequisitionPacksDto? {
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/metadata/h5/metadata/requisition-packs/$id")
                .header("Accept-Language", language.value).build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val listAdapter = MoshiHelper.getAdapter(RequisitionPacksDto::class.java)
                response.body?.string()?.let {
                    return@withContext listAdapter.fromJson(it)
                }
            }
        } catch (error: Throwable) {
            println(error)
            null
        }
    }

    override suspend fun getSeasons(language: Language): List<SeasonDto> {
        val url = "https://www.haloapi.com/metadata/h5/metadata/seasons"
        return getList<SeasonDto>(url, language)
    }

    override suspend fun getSkulls(language: Language): List<SkullDto> {
        val url = "https://www.haloapi.com/metadata/h5/metadata/skulls"
        return getList<SkullDto>(url, language)
    }

    override suspend fun getSpartanRanks(language: Language): List<SpartanRankDto> {
        val url = "https://www.haloapi.com/metadata/h5/metadata/spartan-ranks"
        return getList<SpartanRankDto>(url, language)
    }

    override suspend fun getTeamColors(language: Language): List<TeamColorDto> {
        val url = "https://www.haloapi.com/metadata/h5/metadata/team-colors"
        return getList<TeamColorDto>(url, language)
    }

    override suspend fun getVehicules(language: Language): List<VehiculesDto> {
        val url = "https://www.haloapi.com/metadata/h5/metadata/vehicles"
        return getList<VehiculesDto>(url, language)
    }

    override suspend fun getWeapons(language: Language): List<WeaponDto> {
        val url = "https://www.haloapi.com/metadata/h5/metadata/weapons"
        return getList<WeaponDto>(url = url, language = language)
    }

    private fun getObject(url: String, language: Language, id: String? = null) {

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