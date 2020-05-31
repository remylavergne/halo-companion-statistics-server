package dev.remylavergne.halo.data.dto.halo5

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MedalDto(
    /** A localized name for the medal, suitable for display to users. */
    val name: String?,

    /** A localized description, suitable for display to users. */
    val description: String?,

    /**
     * The type of this medal. It will be one of the following options:
     *   - Unknown
     *   - Multi-kill
     *   - Spree
     *   - Style
     *   - Vehicle
     *   - Breakout
     *   - Objective
     */
    val classification: String,

    /**
     * The anticipated difficulty, relative to all other medals of this classification.
     * The difficulty is ordered from easiest to most difficult.
     */
    val difficulty: Int,

    /** The location on the sprite sheet for the medal. */
    val spriteLocation: SpriteLocationDto,

    /** The ID that uniquely identifies this map medal. */
    val id: Long,

    /** Internal use only. Do not use. */
    val contentId: String
)

data class SpriteLocationDto(
    /** A reference to an image that contains all the sprites. */
    val spriteSheetUri: String,

    /** The X coordinate where the top-left corner of the sprite is located. */
    val left: Int,

    /** The Y coordinate where the top-left corner of the sprite is located. */
    val top: Int,

    /**
     * The width of the full sprite sheet (in pixels). The dimensions of the full sheet
     * are included so that the sheet can be resized.
     */
    val width: Int,

    /**
     * The height of the full sprite sheet (in pixels). The dimensions of the full
     * sheet are included so that the sheet can be resized.
     */
    val height: Int,

    /** The width of this sprite (in pixels). */
    val spriteWidth: Int,

    /** The height of this sprite (in pixels). */
    val spriteHeight: Int
)