package dev.remylavergne.halo.data.dto.metadata

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CommendationsDto(
    val type: String,
    val name: String,
    val description: String,
    val iconImageUrl: String,
    val levels: List<CommendationsLevelsDto>,
    val requiredLevels: List<RequiredLevel>,
    val reward: Reward?,
    val category: CommendationsCategory,
    val id: String,
    val contentId: String
)

data class CommendationsLevelsDto(
    val reward: Reward,
    val threshold: Int,
    val id: String,
    val contentId: String
)

data class Reward(
    val xp: Int,
    val requisitionPacks: List<RequisitionPacksDto>,
    val id: String,
    val contentId: String
)

data class RequiredLevel(
    val threshold: Int,
    val id: String,
    val contentId: String
)

data class CommendationsCategory(
    val name: String,
    val iconImageUrl: String?,
    val order: Int,
    val id: String,
    val contentId: String
)