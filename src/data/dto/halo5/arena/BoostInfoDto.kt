package dev.remylavergne.halo.data.dto.halo5.arena

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BoostInfoDto(
    @Json(name = "DefinitionId") val definitionId: String,
    @Json(name = "CardConsumed") val cardConsumed: Boolean
)