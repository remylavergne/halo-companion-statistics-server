package dev.remylavergne.halo.data.dto.halo5

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VehiculesDto(
    /** A localized name for the object, suitable for display to users. The text is title cased. */
    val nameval: String?,

    /** A localized description, suitable for display to users. */
    val descriptionval: String?,

    /** A reference to a large image for icon use. This may be null if there is no image defined. */
    val largeIconImageUrlval: String?,

    /** A reference to a small image for icon use. This may be null if there is no image defined. */
    val smallIconImageUrlval: String?,

    /** Indicates whether the vehicle is usable by a player. */
    val isUsableByPlayerval: Boolean,

    /** The ID that uniquely identifies this vehicle. */
    val idval: Int,

    /** Internal use only. Do not use. */
    val contentIdval: String
)