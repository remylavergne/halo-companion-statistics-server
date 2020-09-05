package dev.remylavergne.halo.data.dto.metadata

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CampaignMissionsDto(
    val missionNumber: Int,
    val name: String,
    val description: String,
    val imageUrl: String,
    val type: String,
    val id: String,
    val contentId: String
)