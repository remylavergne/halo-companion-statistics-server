package dev.remylavergne.halo.data.dto.halo5

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import dev.remylavergne.halo.data.dto.profile.DateUtcDto

@JsonClass(generateAdapter = true)
data class CompanyDto(
    @Json(name = "Id")
    val id: String,
    @Json(name = "Name")
    val name: String,
    @Json(name = "Creator")
    val creator: Player,
    @Json(name = "PeakMembershipCount")
    val peakMembershipCount: String,
    @Json(name = "SuspendedUntilDate")
    val suspendedUntilDate: DateUtcDto,
    @Json(name = "Members")
    val members: List<Member>,
    @Json(name = "CreatedDate")
    val createdDate: DateUtcDto,
    @Json(name = "LastModifiedDate")
    val lastModifiedDate: DateUtcDto
)

data class Player(
    @Json(name = "Gamertag")
    val gamertag: String,
    @Json(name = "Xuid")
    val xuid: String?
)

data class Member(
    @Json(name = "Player")
    val player: Player,
    @Json(name = "Role")
    val role: Int,
    @Json(name = "JoinedDate")
    val joinedDate: DateUtcDto,
    @Json(name = "LastModifiedDate")
    val lastModifiedDate: DateUtcDto
)

