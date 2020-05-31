package dev.remylavergne.halo.data.dto.halo5

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SeasonDto(
    /** One or more playlists that are available in this season. */
    val playlists: List<PlaylistDto>,

    /** An icon used to represent this season. */
    val iconUrl: String?,

    /** A localized name for the season, suitable for display to users. */
    val name: String?,

    /**
     * The start date and time of this season. This is expressed as an ISO 8601 combined
     * Date and Time.
     */
    val startDate: String,

    /**
     * The end date and time of this season. This is expressed as an ISO 8601 combined
     * Date and Time.
     */
    val endDate: String?,

    /** Indicates if this season is currently active. */
    val isActive: Boolean,

    /** The ID that uniquely identifies this season. */
    val id: String,

    /** Internal use only. Do not use. */
    val contentId: String
)