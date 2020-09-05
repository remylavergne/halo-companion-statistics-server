package dev.remylavergne.halo.data.dto.halo5.generics

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class FlexibleStatsDto(
    @Json(name = "MedalStatCounts") val medalStatCounts: List<MedalStatCountsDto>,
    @Json(name = "ImpulseStatCounts") val impulseStatCounts: List<ImpulseStatCountsDto>,
    @Json(name = "MedalTimelapses") val medalTimelapses: List<String>,
    @Json(name = "ImpulseTimelapses") val impulseTimelapses: List<ImpulseTimelapsesDto>
)