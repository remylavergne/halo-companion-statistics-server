package dev.remylavergne.halo.data.dto.halo5.matchs.warzone

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import dev.remylavergne.halo.data.dto.halo5.generics.GameVariantResourceIdDto
import dev.remylavergne.halo.data.dto.halo5.generics.MapVariantResourceIdDto
import dev.remylavergne.halo.data.dto.halo5.generics.PlayerStatsDto
import dev.remylavergne.halo.data.dto.halo5.generics.TeamStatsDto


@JsonClass(generateAdapter = true)
data class WarzoneMatchResultDto(
    @Json(name = "PlayerStats") val playerStats: List<PlayerStatsDto>,
    @Json(name = "TeamStats") val teamStats: List<TeamStatsDto>,
    @Json(name = "ObjectivesCompleted") val objectivesCompleted: Int,
    @Json(name = "IsMatchOver") val isMatchOver: Boolean,
    @Json(name = "TotalDuration") val totalDuration: String,
    @Json(name = "MapVariantId") val mapVariantId: String,
    @Json(name = "GameVariantId") val gameVariantId: String,
    @Json(name = "PlaylistId") val playlistId: String,
    @Json(name = "MapId") val mapId: String,
    @Json(name = "GameBaseVariantId") val gameBaseVariantId: String,
    @Json(name = "IsTeamGame") val isTeamGame: Boolean,
    @Json(name = "SeasonId") val seasonId: String,
    @Json(name = "GameVariantResourceId") val gameVariantResourceId: GameVariantResourceIdDto,
    @Json(name = "MapVariantResourceId") val mapVariantResourceId: MapVariantResourceIdDto
)