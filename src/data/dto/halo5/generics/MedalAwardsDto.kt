package dev.remylavergne.halo.data.dto.halo5.generics

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MedalAwardsDto(
    @Json(name = "MedalId")
    val medalId: Long,
    @Json(name = "Count")
    val count: Int
) {
}