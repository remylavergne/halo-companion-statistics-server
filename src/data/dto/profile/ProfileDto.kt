package dev.remylavergne.halo.data.dto.profile

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProfileDto(
    @Json(name = "Gamertag")
    val gamertag: String,
    @Json(name = "LastModifiedUtc")
    val lastModifiedUtc: DateUtcDto,
    @Json(name = "FirstModifiedUtc")
    val firstModifiedUtc: DateUtcDto,
    @Json(name = "ServiceTag")
    val serviceTag: String,
    @Json(name = "Company")
    val company: String?

)

data class DateUtcDto(val ISO8601Date: String)