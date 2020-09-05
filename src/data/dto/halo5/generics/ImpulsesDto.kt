package dev.remylavergne.halo.data.dto.halo5.generics

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImpulsesDto(
    @Json(name = "Id")
    val id: Long,
    @Json(name = "Count")
    val count: Int
)