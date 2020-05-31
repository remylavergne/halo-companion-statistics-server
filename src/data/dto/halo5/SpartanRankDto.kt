package dev.remylavergne.halo.data.dto.halo5

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpartanRankDto(
    /** The amount of XP required to enter this rank. */
    val startXp: Int,

    /** The reward the player will receive for earning this Spartan Rank. */
    val reward: Reward,

    /** The ID that uniquely identifies this Spartan Rank.  */
    val id: Int,

    /** Internal use only. Do not use. */
    val contentId: String
)