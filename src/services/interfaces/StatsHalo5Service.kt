package dev.remylavergne.halo.services.interfaces

import dev.remylavergne.halo.data.dto.halo5.CompanyCommendationsDto
import dev.remylavergne.halo.data.dto.halo5.CompanyDto

/**
 * API that provides statistical data about Players and Matches.
 */
interface StatsHalo5Service {

    suspend fun getCompany(id: String): CompanyDto?

    suspend fun getCompanyCommendations(companyId: String): CompanyCommendationsDto?
}