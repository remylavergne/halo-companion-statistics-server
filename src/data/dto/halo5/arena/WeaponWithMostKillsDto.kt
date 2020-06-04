package dev.remylavergne.halo.data.dto.halo5.arena

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import dev.remylavergne.halo.data.dto.halo5.generics.WeaponIdDto


@JsonClass(generateAdapter = true)
data class WeaponWithMostKillsDto(
    @Json(name = "WeaponId") val weaponId: WeaponIdDto,
    @Json(name = "TotalShotsFired") val totalShotsFired: Int,
    @Json(name = "TotalShotsLanded") val totalShotsLanded: Int,
    @Json(name = "TotalHeadshots") val totalHeadshots: Int,
    @Json(name = "TotalKills") val totalKills: Int,
    @Json(name = "TotalDamageDealt") val totalDamageDealt: Double,
    @Json(name = "TotalPossessionTime") val totalPossessionTime: String
)