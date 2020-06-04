package dev.remylavergne.halo.data.dto.halo5.arena

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RewardSetsDto(
    @Json(name = "RewardSet")
    val rewardSet: String,
    @Json(name = "RewardSourceType")
    val rewardSourceType: Int,
    @Json(name = "SpartanRankSource")
    val spartanRankSource: String?,
    @Json(name = "CommendationLevelId")
    val commendationLevelId: String?,
    @Json(name = "CommendationSource")
    val commendationSource: String?
) {
}