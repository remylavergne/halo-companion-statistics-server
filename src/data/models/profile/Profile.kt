package dev.remylavergne.halo.data.models.profile

import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("Gamertag")
    val gamertag: String,
    @SerializedName("LastModifiedUtc")
    val lastModifiedUtc: ModifiedUtc,
    @SerializedName("FirstModifiedUtc")
    val firstModifiedUtc: ModifiedUtc,
    @SerializedName("ServiceTag")
    val serviceTag: String,
    @SerializedName("Company")
    val company: String?

)

data class ModifiedUtc(val ISO8601Date: String)