package dev.remylavergne.halo.data.dto.halo5

data class ImpulseDto(
    // Internal use. The non-localized name of the impulse.
    val internalName: String,

    // The ID that uniquely identifies this impulse.
    val id: String,

    // Internal use only. Do not use.
    val contentId: String
)