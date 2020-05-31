package dev.remylavergne.halo.data.dto.metadata

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MapVariants(
    /** A localized name, suitable for display to users. */
    val name: String?,

    /** A localized description, suitable for display to users.*/
    val description: String?,

    /** A reference to an image. This may be null if there is no image defined.*/
    val mapImageUrl: String?,

    /** The ID of the map this is a variant for. Maps are available via the Metadata API.*/
    val mapId: String,

    /** The ID that uniquely identifies this map variant.*/
    val id: String,

    /** Internal use only. Do not use.*/
    val contentId: String
)