package dev.remylavergne.halo.data.dto.metadata

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TeamColorDto(
    /** A localized name, suitable for display to users. */
    val name: String?,

    /** A localized description, suitable for display to users. */
    val description: String?,

    /**
     * A seven-character string representing the team color in val RGB Hex notation. This
     * notation uses a val #val  followed by a hex triplet.
     */
    val color: String,

    /**
     * A reference to an image for icon use. This may be null if there is no image
     * defined.
     */
    val iconUrl: String?,

    /**
     * The ID that uniquely identifies this color. This will be the same as the team's ID
     * in responses from the Stats API.
     */
    val id: Int,

    /** Internal use only. Do not use. */
    val contentId: String
)