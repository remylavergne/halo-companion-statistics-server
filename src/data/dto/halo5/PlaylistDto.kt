package dev.remylavergne.halo.data.dto.halo5

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlaylistDto(
    /**
     * A localized name for the playlist, suitable for display to users. The text is
     * title cased.
     */
    val name: String?,

    /** A localized description for the playlist, suitable for display to users. */
    val description: String?,

    /**
     * Indicates if a CSR (competitive skill rank) is shown for players who participate
     * in this playlist.
     */
    val isRanked: Boolean,

    /** An image used to illustrate this playlist. */
    val imageUrl: String?,

    /**
     *  The game mode played in this playlist. Options are:
     *   - Arena
     *   - Campaign
     *   - Custom
     *   - Warzone
     */
    val gameMode: String,

    /** Indicates if this playlist is currently available for play. */
    val isActive: Boolean,

    /** The ID that uniquely identifies this playlist. */
    val id: String,

    /** Internal use only. Do not use. */
    val contentId: String
) {
}