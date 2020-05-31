package dev.remylavergne.halo.services

import dev.remylavergne.halo.data.dto.halo5.CommendationsDto
import dev.remylavergne.halo.data.dto.halo5.CsrDesignationsDto
import dev.remylavergne.halo.data.dto.halo5.EnemiesDto
import dev.remylavergne.halo.data.dto.halo5.FlexibleStatsDto
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
}