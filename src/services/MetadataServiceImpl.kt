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
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/metadata/h5/metadata/campaign-missions")
                .header("Accept-Language", language.value).build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val listAdapter = MoshiHelper.getListAdapter(CampaignMissionsDto::class.java)
                response.body?.string()?.let {
                    return@withContext listAdapter.fromJson(it)
                }
            }
        } catch (error: Throwable) {
            println(error)
            emptyList<CampaignMissionsDto>()
        } ?: emptyList<CampaignMissionsDto>()
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
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/metadata/h5/metadata/requisitions/$id")
                .header("Accept-Language", language.value).build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val listAdapter = MoshiHelper.getListAdapter(RequisitionDto::class.java)
                response.body?.string()?.let {
                    return@withContext listAdapter.fromJson(it)
                }
            }
        } catch (error: Throwable) {
            println(error)
            emptyList<RequisitionDto>()
        } ?: emptyList<RequisitionDto>()
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
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/metadata/h5/metadata/seasons")
                .header("Accept-Language", language.value).build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val listAdapter = MoshiHelper.getListAdapter(SeasonDto::class.java)
                response.body?.string()?.let {
                    return@withContext listAdapter.fromJson(it)
                }
            }
        } catch (error: Throwable) {
            println(error)
            emptyList<SeasonDto>()
        } ?: emptyList<SeasonDto>()
    }

    override suspend fun getSkulls(language: Language): List<SkullDto> {
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/metadata/h5/metadata/skulls")
                .header("Accept-Language", language.value).build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val listAdapter = MoshiHelper.getListAdapter(SkullDto::class.java)
                response.body?.string()?.let {
                    return@withContext listAdapter.fromJson(it)
                }
            }
        } catch (error: Throwable) {
            println(error)
            emptyList<SkullDto>()
        } ?: emptyList<SkullDto>()
    }

    override suspend fun getSpartanRanks(language: Language): List<SpartanRankDto> {
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/metadata/h5/metadata/spartan-ranks")
                .header("Accept-Language", language.value).build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val listAdapter = MoshiHelper.getListAdapter(SpartanRankDto::class.java)
                response.body?.string()?.let {
                    return@withContext listAdapter.fromJson(it)
                }
            }
        } catch (error: Throwable) {
            println(error)
            emptyList<SpartanRankDto>()
        } ?: emptyList<SpartanRankDto>()
    }

    override suspend fun getTeamColors(language: Language): List<TeamColorDto> {
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/metadata/h5/metadata/team-colors")
                .header("Accept-Language", language.value).build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val listAdapter = MoshiHelper.getListAdapter(TeamColorDto::class.java)
                response.body?.string()?.let {
                    return@withContext listAdapter.fromJson(it)
                }
            }
        } catch (error: Throwable) {
            println(error)
            emptyList<TeamColorDto>()
        } ?: emptyList<TeamColorDto>()
    }

    override suspend fun getVehicules(language: Language): List<VehiculesDto> {
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/metadata/h5/metadata/vehicles")
                .header("Accept-Language", language.value).build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val listAdapter = MoshiHelper.getListAdapter(VehiculesDto::class.java)
                response.body?.string()?.let {
                    return@withContext listAdapter.fromJson(it)
                }
            }
        } catch (error: Throwable) {
            println(error)
            emptyList<VehiculesDto>()
        } ?: emptyList<VehiculesDto>()
    }

    override suspend fun getWeapons(language: Language): List<WeaponDto> {
        val request: Request =
            Request.Builder().url("https://www.haloapi.com/metadata/h5/metadata/weapons")
                .header("Accept-Language", language.value).build()

        return try {
            withContext(Dispatchers.IO) {
                val response: Response = okHttpClient.newCall(request).execute()
                val listAdapter = MoshiHelper.getListAdapter(WeaponDto::class.java)
                response.body?.string()?.let {
                    return@withContext listAdapter.fromJson(it)
                }
            }
        } catch (error: Throwable) {
            println(error)
            emptyList<WeaponDto>()
        } ?: emptyList<WeaponDto>()
    }
}