package dev.remylavergne.halo.data.dto.halo5.generics

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class TeamStatsDto(
    @Json(name = "TeamId") val teamId: Int,
    @Json(name = "Score") val score: Int,
    @Json(name = "Rank") val rank: Int,
    @Json(name = "RoundStats") val roundStats: List<RoundStatsDto>
)