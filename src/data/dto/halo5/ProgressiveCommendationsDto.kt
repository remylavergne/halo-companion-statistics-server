package dev.remylavergne.halo.data.dto.halo5

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProgressiveCommendationsDto(
    @Json(name = "Id")
    val id: String,
    @Json(name = "Progress")
    val progress: Int,
    @Json(name = "CompletedLevels")
    val completedLevels: List<CompletedLevelsDto>
)