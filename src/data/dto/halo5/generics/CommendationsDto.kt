package dev.remylavergne.halo.data.dto.halo5.generics

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import dev.remylavergne.halo.data.dto.halo5.MetaCommendationsDto
import dev.remylavergne.halo.data.dto.halo5.ProgressiveCommendationsDto
import dev.remylavergne.halo.data.dto.profile.DateUtcDto

@JsonClass(generateAdapter = true)
data class CommendationsDto(
   /* @Json(name = "Links")
    val links: String?,*/
    @Json(name = "ProgressiveCommendations")
    val progressiveCommendations: List<ProgressiveCommendationsDto>,
    @Json(name = "MetaCommendations")
    val metaCommendations: List<MetaCommendationsDto>,
    @Json(name = "LastUpdatedDateUtc")
    val lastUpdatedDateUtc: DateUtcDto
)
