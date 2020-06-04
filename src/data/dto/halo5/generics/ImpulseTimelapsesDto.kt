package dev.remylavergne.halo.data.dto.halo5.generics

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ImpulseTimelapsesDto(
    @Json(name = "Id") val id: String,
    @Json(name = "Timelapse") val timelapse: String
)