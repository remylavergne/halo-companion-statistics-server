package dev.remylavergne.halo.data.dto.halo5

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MetaCommendationsDto(
    @Json(name = "Id")
    val id: String,
    @Json(name = "MetRequirements")
    val metRequirements: List<MetRequirementsDto>
) {
}