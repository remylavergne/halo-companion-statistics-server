package dev.remylavergne.halo.data.dto.halo5

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import dev.remylavergne.halo.data.dto.profile.DateUtcDto

@JsonClass(generateAdapter = true)
data class CompletedLevelsDto(
    @Json(name = "Id")
    val id: String,
    @Json(name = "CompletedDateUtc")
    val completedDateUtc: DateUtcDto
)