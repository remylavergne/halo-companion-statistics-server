package dev.remylavergne.halo.data.dto.halo5

import com.squareup.moshi.JsonClass

// TODO => Mapper Enum
@JsonClass(generateAdapter = true)
data class MapDto(
    // A localized name, suitable for display to users.
    val name: String?,

    // A localized description, suitable for display to users.
    val description: String?,

    // This lists all the game modes to which this map is available. Options are:
    //   - Arena
    //   - Campaign
    //   - Custom
    //   - Warzone
    val supportedGameModes: List<String>?,

    // A reference to an image. This may be null if there is no image defined.
    val imageUrl: String?,

    // The ID that uniquely identifies this map.
    val id: String,

    // Internal use only. Do not use.
    val contentId: String
)