package dev.remylavergne.halo.data.dto.halo5.generics

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlayerDto(
    @Json(name = "Gamertag") val gamertag: String,
    @Json(name = "Xuid") val xuid: String?
)