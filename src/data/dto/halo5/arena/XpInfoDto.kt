package dev.remylavergne.halo.data.dto.halo5.arena

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class XpInfoDto(
    @Json(name = "PrevSpartanRank") val prevSpartanRank: Int,
    @Json(name = "SpartanRank") val spartanRank: Int,
    @Json(name = "PrevTotalXP") val prevTotalXP: Int,
    @Json(name = "TotalXP") val totalXP: Int,
    @Json(name = "SpartanRankMatchXPScalar") val spartanRankMatchXPScalar: Float,
    @Json(name = "PlayerTimePerformanceXPAward") val playerTimePerformanceXPAward: Int,
    @Json(name = "PerformanceXP") val performanceXP: Int?,
    @Json(name = "PlayerRankXPAward") val playerRankXPAward: Int,
    @Json(name = "BoostAmount") val boostAmount: Int,
    @Json(name = "MatchSpeedWinAmount") val matchSpeedWinAmount: Int,
    @Json(name = "ObjectivesCompletedAmount") val objectivesCompletedAmount: Int
)