package dev.remylavergne.halo.data.dto.halo5

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GameVariantsDto(
    /**  A localized name, suitable for display to users. */
    val name: String?,

    /**  A localized description, suitable for display to users. */
    val description: String?,

    /**
     *  The ID of the game base variant this is a variant for. Game Base Variants are
     *  available via the Metadata API.
     */
    val gameBaseVariantId: String?,

    /**  An icon image for the game variant. */
    val iconUrl: String?,

    /**  The ID that uniquely identifies this game variant. */
    val id: String,

    /** Internal use only. Do not use. */
    val contentId: String
)