package dev.remylavergne.halo.data.dto.halo5.campaignmatch

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import dev.remylavergne.halo.data.dto.halo5.generics.GameVariantResourceIdDto
import dev.remylavergne.halo.data.dto.halo5.generics.MapVariantResourceIdDto
import dev.remylavergne.halo.data.dto.halo5.generics.PlayerStatsDto

@JsonClass(generateAdapter = true) data class CampaignMatchResultDto (
	@Json(name = "PlayerStats") val playerStats : List<PlayerStatsDto>,
	@Json(name = "TotalMissionPlaythroughTime") val totalMissionPlaythroughTime : String,
	@Json(name = "Difficulty") val difficulty : Int,
	@Json(name = "Skulls") val skulls : List<Int>,
	@Json(name = "MissionCompleted") val missionCompleted : Boolean,
	@Json(name = "IsMatchOver") val isMatchOver : Boolean,
	@Json(name = "TotalDuration") val totalDuration : String,
	@Json(name = "MapVariantId") val mapVariantId : String,
	@Json(name = "GameVariantId") val gameVariantId : String,
	@Json(name = "PlaylistId") val playlistId : String,
	@Json(name = "MapId") val mapId : String,
	@Json(name = "GameBaseVariantId") val gameBaseVariantId : String,
	@Json(name = "IsTeamGame") val isTeamGame : Boolean,
	@Json(name = "SeasonId") val seasonId : String,
	@Json(name = "GameVariantResourceId") val gameVariantResourceId : GameVariantResourceIdDto,
	@Json(name = "MapVariantResourceId") val mapVariantResourceId : MapVariantResourceIdDto
)