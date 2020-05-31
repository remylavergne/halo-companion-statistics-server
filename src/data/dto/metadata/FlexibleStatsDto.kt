package dev.remylavergne.halo.data.dto.metadata

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FlexibleStatsDto(
    // A localized name for the data point, suitable for display to users. The text is
    // title cased.
    val name: String,
    // The type of stat this represents, it is one of the following options:
    //   - Count
    //   - Duration
    val type: String,
    // The ID that uniquely identifies this stat.
    val id: String,
    // Internal use only. Do not use.
    val contentId: String
)
