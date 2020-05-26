package dev.remylavergne.halo.data.dto.profile

import com.google.gson.annotations.SerializedName

data class ProfileDto(
    @SerializedName("Gamertag")
    val gamertag: String,
    @SerializedName("LastModifiedUtc")
    val lastModifiedUtc: ModifiedUtcDto,
    @SerializedName("FirstModifiedUtc")
    val firstModifiedUtc: ModifiedUtcDto,
    @SerializedName("ServiceTag")
    val serviceTag: String,
    @SerializedName("Company")
    val company: String?

)

data class ModifiedUtcDto(val ISO8601Date: String)