package dev.remylavergne.halo.data.dto.halo5.generics

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class KilledByOpponentDetailsDto(
    @Json(name = "GamerTag") val gamerTag: String,
    @Json(name = "TotalKills") val totalKills: Int
)