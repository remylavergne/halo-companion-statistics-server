package dev.remylavergne.halo.data.dto.halo5.arena

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class CreditsEarnedDto(
    @Json(name = "Result") val result: Int,
    @Json(name = "TotalCreditsEarned") val totalCreditsEarned: Int,
    @Json(name = "SpartanRankModifier") val spartanRankModifier: Int,
    @Json(name = "PlayerRankAmount") val playerRankAmount: Int,
    @Json(name = "TimePlayedAmount") val timePlayedAmount: Double,
    @Json(name = "BoostAmount") val boostAmount: Int,
    @Json(name = "MatchSpeedWinAmount") val matchSpeedWinAmount: Int,
    @Json(name = "ObjectivesCompletedAmount") val objectivesCompletedAmount: Int
)