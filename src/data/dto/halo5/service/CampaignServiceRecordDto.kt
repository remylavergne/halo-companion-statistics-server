package dev.remylavergne.halo.data.dto.halo5.service

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import dev.remylavergne.halo.data.dto.halo5.generics.EnemyKillsDto
import dev.remylavergne.halo.data.dto.halo5.generics.ImpulsesDto

@JsonClass(generateAdapter = true)
data class CampaignServiceRecordDto(
    val Results: List<CampaignResultsDto>,
    val Links: LinksDto
)

@JsonClass(generateAdapter = true)
data class CampaignResultsDto(
    @Json(name = "Id")
    val id: String,
    @Json(name = "ResultCode")
    val resultCode: Int,
    @Json(name = "Result")
    val result: CampaignResultDto
)

@JsonClass(generateAdapter = true)
data class CampaignResultDto(
    @Json(name = "CampaignStat")
    val campaignStat: CampaignStatDto,
    @Json(name = "PlayerId")
    val playerId: PlayerIdDto,
    @Json(name = "SpartanRank")
    val spartanRank: Int,
    @Json(name = "Xp")
    val xp: Long
)

data class CoopStatsDto(
    @Json(name = "1")
    val one: CoopStatsGroupDto?,
    @Json(name = "2")
    val two: CoopStatsGroupDto?,
    @Json(name = "3")
    val three: CoopStatsGroupDto?,
    @Json(name = "4")
    val four: CoopStatsGroupDto?
)

data class CoopStatsGroupDto(
    @Json(name = "HighestScore")
    val highestScore: Int,
    @Json(name = "FastestCompletionTime")
    val fastestCompletionTime: String,
    @Json(name = "Skulls")
    val skulls: List<Int>,
    @Json(name = "TotalTimesCompleted")
    val totalTimesCompleted: Int,
    @Json(name = "AllSkullsOn")
    val allSkullsOn: Boolean
)

data class SoloStatsDto(
    @Json(name = "1")
    val one: CoopStatsGroupDto?,
    @Json(name = "2")
    val two: CoopStatsGroupDto?,
    @Json(name = "3")
    val three: CoopStatsGroupDto?,
    @Json(name = "4")
    val four: CoopStatsGroupDto?
)

@JsonClass(generateAdapter = true)
data class CampaignMissionStatsDto(
    @Json(name = "FlexibleStats")
    val flexibleStats: FlexibleStatsDto,
    @Json(name = "CoopStats")
    val coopStats: CoopStatsDto,
    @Json(name = "SoloStats")
    val soloStats: SoloStatsDto,
    @Json(name = "MissionId")
    val missionId: String,
    @Json(name = "TotalKills")
    val totalKills: Int,
    @Json(name = "TotalHeadshots")
    val totalHeadshots: Int,
    @Json(name = "TotalWeaponDamage")
    val totalWeaponDamage: Double,
    @Json(name = "TotalShotsFired")
    val totalShotsFired: Int,
    @Json(name = "TotalShotsLanded")
    val totalShotsLanded: Int,
    @Json(name = "WeaponWithMostKills")
    val weaponWithMostKills: WeaponWithMostKillsDto,
    @Json(name = "TotalMeleeKills")
    val totalMeleeKills: Int,
    @Json(name = "TotalMeleeDamage")
    val totalMeleeDamage: Double,
    @Json(name = "TotalAssassinations")
    val totalAssassinations: Int,
    @Json(name = "TotalGroundPoundKills")
    val totalGroundPoundKills: Int,
    @Json(name = "TotalGroundPoundDamage")
    val totalGroundPoundDamage: Double,
    @Json(name = "TotalShoulderBashKills")
    val totalShoulderBashKills: Int,
    @Json(name = "TotalShoulderBashDamage")
    val totalShoulderBashDamage: Double,
    @Json(name = "TotalGrenadeDamage")
    val totalGrenadeDamage: Double,
    @Json(name = "TotalPowerWeaponKills")
    val totalPowerWeaponKills: Int,
    @Json(name = "TotalPowerWeaponDamage")
    val totalPowerWeaponDamage: Double,
    @Json(name = "TotalPowerWeaponGrabs")
    val TotalPowerWeaponGrabs: Int,
    @Json(name = "TotalPowerWeaponPossessionTime")
    val TotalPowerWeaponPossessionTime: String,
    @Json(name = "TotalDeaths")
    val TotalDeaths: Int,
    @Json(name = "TotalAssists")
    val TotalAssists: Int,
    @Json(name = "TotalGamesCompleted")
    val TotalGamesCompleted: Int,
    @Json(name = "TotalGamesWon")
    val TotalGamesWon: Int,
    @Json(name = "TotalGamesLost")
    val TotalGamesLost: Int,
    @Json(name = "TotalGamesTied")
    val TotalGamesTied: Int,
    @Json(name = "TotalTimePlayed")
    val TotalTimePlayed: String,
    @Json(name = "TotalGrenadeKills")
    val TotalGrenadeKills: Int,
    @Json(name = "MedalAwards")
    val MedalAwards: List<MedalAwardsDto>,
    @Json(name = "DestroyedEnemyVehicles")
    val DestroyedEnemyVehicles: List<DestroyedEnemyVehiclesDto>,
    @Json(name = "EnemyKills")
    val EnemyKills: List<EnemyKillsDto>,
    @Json(name = "WeaponStats")
    val WeaponStats: List<WeaponStatsDto>,
    @Json(name = "Impulses")
    val Impulses: List<ImpulsesDto>,
    @Json(name = "TotalSpartanKills")
    val TotalSpartanKills: Int,
    @Json(name = "FastestMatchWin")
    val FastestMatchWin: String?
)

@JsonClass(generateAdapter = true)
data class CampaignStatDto(
    @Json(name = "CampaignMissionStats")
    val campaignMissionStats: List<CampaignMissionStatsDto>,
    @Json(name = "TotalKills")
    val totalKills: Int,
    @Json(name = "TotalHeadshots")
    val totalHeadshots: Int,
    @Json(name = "TotalWeaponDamage")
    val totalWeaponDamage: Double,
    @Json(name = "TotalShotsFired")
    val totalShotsFired: Int,
    @Json(name = "TotalShotsLanded")
    val totalShotsLanded: Int,
    @Json(name = "WeaponWithMostKills")
    val weaponWithMostKills: WeaponWithMostKillsDto,
    @Json(name = "TotalMeleeKills")
    val totalMeleeKills: Int,
    @Json(name = "TotalMeleeDamage")
    val totalMeleeDamage: Double,
    @Json(name = "TotalAssassinations")
    val totalAssassinations: Int,
    @Json(name = "TotalGroundPoundKills")
    val totalGroundPoundKills: Int,
    @Json(name = "TotalGroundPoundDamage")
    val totalGroundPoundDamage: Double,
    @Json(name = "TotalShoulderBashKills")
    val totalShoulderBashKills: Int,
    @Json(name = "TotalShoulderBashDamage")
    val totalShoulderBashDamage: Double,
    @Json(name = "TotalGrenadeDamage")
    val totalGrenadeDamage: Double,
    @Json(name = "TotalPowerWeaponKills")
    val totalPowerWeaponKills: Int,
    @Json(name = "TotalPowerWeaponDamage")
    val totalPowerWeaponDamage: Double,
    @Json(name = "TotalPowerWeaponGrabs")
    val totalPowerWeaponGrabs: Int,
    @Json(name = "TotalPowerWeaponPossessionTime")
    val totalPowerWeaponPossessionTime: String,
    @Json(name = "TotalDeaths")
    val totalDeaths: Int,
    @Json(name = "TotalAssists")
    val totalAssists: Int,
    @Json(name = "TotalGamesCompleted")
    val totalGamesCompleted: Int,
    @Json(name = "TotalGamesWon")
    val totalGamesWon: Int,
    @Json(name = "TotalGamesLost")
    val totalGamesLost: Int,
    @Json(name = "TotalGamesTied")
    val totalGamesTied: Int,
    @Json(name = "TotalTimePlayed")
    val totalTimePlayed: String,
    @Json(name = "TotalGrenadeKills")
    val totalGrenadeKills: Int,
    @Json(name = "MedalAwards")
    val medalAwards: List<MedalAwardsDto>,
    @Json(name = "DestroyedEnemyVehicles")
    val destroyedEnemyVehicles: List<DestroyedEnemyVehiclesDto>,
    @Json(name = "EnemyKills")
    val enemyKills: List<EnemyKillsDto>,
    @Json(name = "WeaponStats")
    val weaponStats: List<WeaponStatsDto>,
    @Json(name = "Impulses")
    val impulses: List<ImpulsesDto>,
    @Json(name = "TotalSpartanKills")
    val totalSpartanKills: Int,
    @Json(name = "FastestMatchWin")
    val fastestMatchWin: String?
)



