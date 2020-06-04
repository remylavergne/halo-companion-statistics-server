package dev.remylavergne.halo.data.dto.halo5.generics

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class WeaponIdDto(
    @Json(name = "StockId") val stockId: Long,
    @Json(name = "Attachments") val attachments: List<String>
)