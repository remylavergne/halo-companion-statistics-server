package dev.remylavergne.halo.data.dto.halo5

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EnemiesDto(
    // The faction that this enemy is affiliated with. One of the following options:
    //   - UNSC
    //   - Covenant
    //   - Promethean
    val faction: String,
    // A localized name for the object, suitable for display to users. The text is title
    // cased.
    val name: String,
    // A localized description, suitable for display to users. Note: This may be null.
    val description: String?,
    // A reference to a large image for icon use. This may be null if there is no image
    // defined.
    val largeIconImageUrl: String?,
    // A reference to a small image for icon use. This may be null if there is no image
    // defined.
    val smallIconImageUrl: String?,
    // The ID that uniquely identifies this enemy.
    val id: String,
    // Internal use only. Do not use.
    val contentId: String
)