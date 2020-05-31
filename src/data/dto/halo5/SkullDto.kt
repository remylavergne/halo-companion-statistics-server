package dev.remylavergne.halo.data.dto.halo5

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SkullDto(
    /** A localized name, suitable for display to users. The text is title cased. */
    val name: String?,

    /** A localized description, suitable for display to users. */
    val description: String?,

    /** A reference to the image for the skull. */
    val imageUrl: String?,

    /**
     * Indicates what mission this skull can be located within. Null when the skull is
     * not found in a mission. Missions are available via the Metadata API.
     */
    val missionId: String,

    /** The ID that uniquely identifies this skull. */
    val id: Int,

    /** Internal use only. Do not use. */
    val contentId: String
)