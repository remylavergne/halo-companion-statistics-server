package dev.remylavergne.halo.data.dto.halo5.generics

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class EnemyKillsDto(
    @Json(name = "Enemy") val enemy: EnemyDto,
    @Json(name = "TotalKills") val totalKills: Int
)