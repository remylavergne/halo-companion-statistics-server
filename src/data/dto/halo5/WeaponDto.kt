package dev.remylavergne.halo.data.dto.halo5

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeaponDto(
    /** A localized name for the object, suitable for display to users. The text is title cased. */
    val nameval: String?,

    /** A localized description, suitable for display to users. */
    val description: String?,

    /**
     * The type of the weapon. Options are:
     *   - Grenade
     *   - Turret
     *   - Vehicle
     *   - Standard
     *   - Power
     */
    val type: String,

    /** A reference to a large image for icon use. This may be null if there is no image defined. */
    val largeIconImageUrl: String?,

    /** A reference to a small image for icon use. This may be null if there is no image defined. */
    val smallIconImageUrl: String?,

    /** Indicates whether the weapon is usable by a player. */
    val isUsableByPlayer: Boolean,

    /** The ID that uniquely identifies the weapon. */
    val id: Long,

    /** Internal use only. Do not use. */
    val contentId: String
)