package dev.remylavergne.halo.services

import dev.remylavergne.halo.data.dto.halo5.CompanyDto
import dev.remylavergne.halo.services.interfaces.StatsHalo5Service
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
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
}