package dev.remylavergne.halo.data.dto.halo5.matchs.history

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class PlayerMatchHistoryDto(
    @Json(name = "Start") val start: Int,
    @Json(name = "Count") val count: Int,
    @Json(name = "ResultCount") val resultCount: Int,
    @Json(name = "Results") val results: List<ResultsDto>,
    @Json(name = "Links") val links: LinksDto
)

@JsonClass(generateAdapter = true)
data class LinksDto(
    @Json(name = "Self") val self: SelfDto
)

@JsonClass(generateAdapter = true)
data class SelfDto(
    @Json(name = "AuthorityId") val authorityId: String,
    @Json(name = "Path") val path: String,
    @Json(name = "QueryString") val queryString: String,
    @Json(name = "RetryPolicyId") val retryPolicyId: String,
    @Json(name = "TopicName") val topicName: String,
    @Json(name = "AcknowledgementTypeId") val acknowledgementTypeId: Int,
    @Json(name = "AuthenticationLifetimeExtensionSupported") val authenticationLifetimeExtensionSupported: Boolean,
    @Json(name = "ClearanceAware") val clearanceAware: Boolean
)

@JsonClass(generateAdapter = true)
data class ResultsDto(
    @Json(name = "Links") val resultLinks: ResultLinkDto,
    @Json(name = "Id") val id: IdDto,
    @Json(name = "HopperId") val hopperId: String?,
    @Json(name = "MapId") val mapId: String,
    @Json(name = "MapVariant") val mapVariant: MapVariantDto,
    @Json(name = "GameBaseVariantId") val gameBaseVariantId: String,
    @Json(name = "GameVariant") val gameVariant: GameVariantDto,
    @Json(name = "MatchDuration") val matchDuration: String,
    @Json(name = "MatchCompletedDate") val matchCompletedDate: MatchCompletedDateDto,
    @Json(name = "Teams") val teams: List<TeamsDto>,
    @Json(name = "Players") val players: List<PlayersDto>,
    @Json(name = "IsTeamGame") val isTeamGame: Boolean,
    @Json(name = "SeasonId") val seasonId: String,
    @Json(name = "MatchCompletedDateFidelity") val matchCompletedDateFidelity: Int
)

@JsonClass(generateAdapter = true)
data class PlayersDto(
    @Json(name = "Player")
    val player: PlayerDto,
    @Json(name = "TeamId")
    val teamId: Int,
    @Json(name = "Rank")
    val rank: Int,
    @Json(name = "Result")
    val result: Int,
    @Json(name = "TotalKills")
    val totalKills: Int,
    @Json(name = "TotalDeaths")
    val totalDeaths: Int,
    @Json(name = "TotalAssists")
    val totalAssists: Int,
    @Json(name = "PreMatchRatings")
    val preMatchRatings: String?,
    @Json(name = "PostMatchRatings")
    val postMatchRatings: String?
)

@JsonClass(generateAdapter = true)
data class PlayerDto(
    @Json(name = "Gamertag")
    val gamertag: String,
    @Json(name = "Xuid")
    val xuid: String?
)

@JsonClass(generateAdapter = true)
data class TeamsDto(
    @Json(name = "Id")
    val id: Int,
    @Json(name = "Score")
    val score: Int,
    @Json(name = "Rank")
    val rank: Int
)

@JsonClass(generateAdapter = true)
data class IdDto(
    @Json(name = "MatchId")
    val matchId: String,
    @Json(name = "GameMode")
    val gameMode: Int
)

@JsonClass(generateAdapter = true)
data class MatchCompletedDateDto(
    @Json(name = "ISO8601Date")
    val iso8601Date: String
)

@JsonClass(generateAdapter = true)
data class MapVariantDto(
    @Json(name = "ResourceType")
    val resourceType: Int,
    @Json(name = "ResourceId")
    val resourceId: String,
    @Json(name = "OwnerType")
    val ownerType: Int,
    @Json(name = "Owner")
    val owner: String
)

@JsonClass(generateAdapter = true)
data class GameVariantDto(
    @Json(name = "ResourceType")
    val resourceType: Int,
    @Json(name = "ResourceId")
    val resourceId: String,
    @Json(name = "OwnerType")
    val ownerType: Int,
    @Json(name = "Owner")
    val owner: String
)

@JsonClass(generateAdapter = true)
data class ResultLinkDto(
    @Json(name = "StatsMatchDetails") val statsMatchDetails: StatsMatchDetailsDto,
    @Json(name = "UgcFilmManifest") val ugcFilmManifest: UgcFilmManifestDto
)

@JsonClass(generateAdapter = true)
data class StatsMatchDetailsDto(
    @Json(name = "AuthorityId")
    val authorityId: String,
    @Json(name = "Path")
    val path: String,
    @Json(name = "QueryString")
    val queryString: String?,
    @Json(name = "RetryPolicyId")
    val retryPolicyId: String,
    @Json(name = "TopicName")
    val topicName: String,
    @Json(name = "AcknowledgementTypeId")
    val acknowledgementTypeId: Int,
    @Json(name = "AuthenticationLifetimeExtensionSupported")
    val authenticationLifetimeExtensionSupported: Boolean,
    @Json(name = "ClearanceAware")
    val clearanceAware: Boolean
)

@JsonClass(generateAdapter = true)
data class UgcFilmManifestDto(
    @Json(name = "AuthorityId")
    val authorityId: String,
    @Json(name = "Path")
    val path: String,
    @Json(name = "QueryString")
    val queryString: String?,
    @Json(name = "RetryPolicyId")
    val retryPolicyId: String,
    @Json(name = "TopicName")
    val topicName: String,
    @Json(name = "AcknowledgementTypeId")
    val acknowledgementTypeId: Int,
    @Json(name = "AuthenticationLifetimeExtensionSupported")
    val authenticationLifetimeExtensionSupported: Boolean,
    @Json(name = "ClearanceAware")
    val clearanceAware: Boolean
)







