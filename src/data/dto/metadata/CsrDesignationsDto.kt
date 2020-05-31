package dev.remylavergne.halo.data.dto.metadata

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CsrDesignationsDto(
    val name: String,
    val bannerImageUrl: String,
    val tiers: List<Tiers>,
    val id: String,
    val contentId: String
)

data class Tiers(
    val iconImageUrl: String,
    val id: String,
    val contentId: String
)