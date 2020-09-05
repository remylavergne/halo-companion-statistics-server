package dev.remylavergne.halo.data.dto.halo5

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MetRequirementsDto(
    @Json(name = "Data1")
    val data1: Double,
    @Json(name = "Data2")
    val data2: Double,
    @Json(name = "Data3")
    val data3: Double,
    @Json(name = "Data4")
    val data4: Double
)