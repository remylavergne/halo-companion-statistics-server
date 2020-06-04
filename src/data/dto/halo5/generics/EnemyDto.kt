package dev.remylavergne.halo.data.dto.halo5.generics

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class EnemyDto(
    @Json(name = "BaseId") val baseId: Long?,
    @Json(name = "Attachments") val attachments: List<Long>?
)