package dev.remylavergne.halo.data.dto.halo5.arena

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProgressiveCommendationDeltasDto(
    @Json(name = "Id")
    val id: String,
    @Json(name = "PreviousProgress")
    val previousProgress: Int,
    @Json(name = "Progress")
    val progress: Int
)