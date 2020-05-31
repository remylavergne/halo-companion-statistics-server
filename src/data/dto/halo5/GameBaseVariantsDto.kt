package dev.remylavergne.halo.data.dto.halo5

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GameBaseVariantsDto(
    /**
     * A localized name for the game base variant, suitable for display to users. The
     * text is title cased.
     */
    val name: String?,

    /**  Internal use. The internal non-localized name for the the game base variant. */
    val internalName: String,

    /** An image to use as the game base variant for the designation. */
    val iconUrl: String?,

    /**
     * * A list that indicates what game modes this base variant is available within.
     * Options are:
     *   - Arena
     *   - Campaign
     *   - Custom
     *   - Warzone
     */
    val supportedGameModes: List<String>,

    /** The ID that uniquely identifies this game base variant. */
    val id: String,

    /** Internal use only. Do not use. */
    val contentId: String
)