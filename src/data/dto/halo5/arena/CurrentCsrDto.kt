package dev.remylavergne.halo.data.dto.halo5.arena

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class CurrentCsrDto(
    @Json(name = "Tier") val tier: Int,
    @Json(name = "DesignationId") val designationId: Int,
    @Json(name = "Csr") val csr: Int,
    @Json(name = "PercentToNextTier") val percentToNextTier: Int,
    @Json(name = "Rank") val rank: String?
)