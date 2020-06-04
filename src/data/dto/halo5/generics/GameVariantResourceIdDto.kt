package dev.remylavergne.halo.data.dto.halo5.generics

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class GameVariantResourceIdDto(
    @Json(name = "ResourceType") val resourceType: Int,
    @Json(name = "ResourceId") val resourceId: String,
    @Json(name = "OwnerType") val ownerType: Int,
    @Json(name = "Owner") val owner: String
)