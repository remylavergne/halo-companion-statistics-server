package dev.remylavergne.halo.data.dto.halo5.service


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ArenaServiceRecordDto(
    @Json(name = "Results")
    val result: List<ResultsDto>,
    @Json(name = "Links")
    val links: LinksDto
)

@JsonClass(generateAdapter = true)
data class LinksDto(
    @Json(name = "Self")
    val self: SelfDto
)

@JsonClass(generateAdapter = true)
data class SelfDto(
    @Json(name = "AuthorityId")
    val authorityId: String,
    @Json(name = "Path")
    val path: String,
    @Json(name = "QueryString")
    val queryString: String,
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
data class ResultsDto(
    @Json(name = "Id")
    val id: String,
    @Json(name = "ResultCode")
    val resultCode: Int,
    @Json(name = "Result")
    val result: ResultDto
)

@JsonClass(generateAdapter = true)
data class PlayerIdDto(
    @Json(name = "Gamertag")
    val gamertag: String,
    @Json(name = "Xuid")
    val xuid: String?
)

@JsonClass(generateAdapter = true)
data class ResultDto(
    @Json(name = "ArenaStats")
    val arenaStats: ArenaStatsDto,
    @Json(name = "PlayerId")
    val playerId: PlayerIdDto,
    @Json(name = "SpartanRank")
    val spartanRank: Int,
    @Json(name = "Xp")
    val xp: Long
)

@JsonClass(generateAdapter = true)
data class HighestCsrDto(
    @Json(name = "Tier")
    val tier: Int,
    @Json(name = "DesignationId")
    val designationId: Int,
    @Json(name = "Csr")
    val csr: Int,
    @Json(name = "PercentToNextTier")
    val percentToNextTier: Int,
    @Json(name = "Rank")
    val rank: String?
)

@JsonClass(generateAdapter = true)
data class CsrDto(
    @Json(name = "Tier")
    val Tier: Int,
    @Json(name = "DesignationId")
    val DesignationId: Int,
    @Json(name = "Csr")
    val Csr: Int,
    @Json(name = "PercentToNextTier")
    val PercentToNextTier: Int,
    @Json(name = "Rank")
    val Rank: String?
)

data class WeaponWithMostKillsDto(
    @Json(name = "WeaponId")
    val weaponId: WeaponIdDto,
    @Json(name = "TotalShotsFired")
    val totalShotsFired: Int,
    @Json(name = "TotalShotsLanded")
    val totalShotsLanded: Int,
    @Json(name = "TotalHeadshots")
    val totalHeadshots: Int,
    @Json(name = "TotalKills")
    val totalKills: Int,
    @Json(name = "TotalDamageDealt")
    val totalDamageDealt: Double,
    @Json(name = "TotalPossessionTime")
    val totalPossessionTime: String
)


@JsonClass(generateAdapter = true)
data class ArenaPlaylistStatsDto(
    @Json(name = "PlaylistId")
    val playlistId: String,
    @Json(name = "MeasurementMatchesLeft")
    val measurementMatchesLeft: Int,
    @Json(name = "HighestCsr")
    val highestCsr: HighestCsrDto?,
    @Json(name = "Csr")
    val csr: CsrDto?,
    @Json(name = "CsrPercentile")
    val csrPercentile: Int?,
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
    val enemyKills: List<String>,
    @Json(name = "WeaponStats")
    val weaponStats: List<WeaponStatsDto>,
    @Json(name = "Impulses")
    val impulses: List<ImpulseStatCountsDto>,
    @Json(name = "TotalSpartanKills")
    val totalSpartanKills: Int,
    @Json(name = "FastestMatchWin")
    val fastestMatchWin: String?
)

@JsonClass(generateAdapter = true)
data class WeaponStatsDto(
    @Json(name = "WeaponId")
    val weaponId: WeaponIdDto,
    @Json(name = "TotalShotsFired")
    val totalShotsFired: Int,
    @Json(name = "TotalShotsLanded")
    val totalShotsLanded: Int,
    @Json(name = "TotalHeadshots")
    val totalHeadshots: Int,
    @Json(name = "TotalKills")
    val totalKills: Int,
    @Json(name = "TotalDamageDealt")
    val totalDamageDealt: Double,
    @Json(name = "TotalPossessionTime")
    val totalPossessionTime: String
)

@JsonClass(generateAdapter = true)
data class WeaponIdDto(
    @Json(name = "StockId")
    val stockId: Long,
    @Json(name = "Attachments")
    val attachments: List<String>
)

@JsonClass(generateAdapter = true)
data class MedalAwardsDto(
    @Json(name = "MedalId")
    val medalId: Long,
    @Json(name = "Count")
    val count: Int
)

@JsonClass(generateAdapter = true)
data class HighestCsrAttainedDto(
    @Json(name = "Tier")
    val tier: Int,
    @Json(name = "DesignationId")
    val designationId: Int,
    @Json(name = "Csr")
    val csr: Int,
    @Json(name = "PercentToNextTier")
    val percentToNextTier: Int,
    @Json(name = "Rank")
    val rank: Int?
)

@JsonClass(generateAdapter = true)
data class ArenaGameBaseVariantStatsDto(
    @Json(name = "FlexibleStats")
    val flexibleStats: FlexibleStatsDto,
    @Json(name = "GameBaseVariantId")
    val gameBaseVariantId: String,
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
    val enemyKills: List<String>, // TODO => Unknown type !
    @Json(name = "WeaponStats")
    val weaponStats: List<WeaponStatsDto>,
    @Json(name = "Impulses")
    val impulses: List<ImpulseStatCountsDto>,
    @Json(name = "TotalSpartanKills")
    val totalSpartanKills: Int,
    @Json(name = "FastestMatchWin")
    val fastestMatchWin: String?
)

@JsonClass(generateAdapter = true)
data class DestroyedEnemyVehiclesDto(
    @Json(name = "Enemy")
    val enemy: EnemyDto,
    @Json(name = "TotalKills")
    val totalKills: Int
)

@JsonClass(generateAdapter = true)
data class EnemyDto(
    @Json(name = "BaseId")
    val baseId: Long,
    @Json(name = "Attachments")
    val attachments: List<String>
)

@JsonClass(generateAdapter = true)
data class FlexibleStatsDto(
    @Json(name = "MedalStatCounts")
    val medalStatCounts: List<MedalStatCountsDto>,
    @Json(name = "ImpulseStatCounts")
    val impulseStatCounts: List<ImpulseStatCountsDto>,
    @Json(name = "MedalTimelapses")
    val medalTimelapses: List<String>,
    @Json(name = "ImpulseTimelapses")
    val impulseTimelapses: List<ImpulseTimelapsesDto>
)

@JsonClass(generateAdapter = true)
data class ImpulseTimelapsesDto(
    @Json(name = "Id")
    val id: String,
    @Json(name = "Timelapse")
    val timelapse: String
)

@JsonClass(generateAdapter = true)
data class ImpulseStatCountsDto(
    @Json(name = "Id")
    val id: String,
    @Json(name = "Count")
    val count: Int
)

@JsonClass(generateAdapter = true)
data class MedalStatCountsDto(
    @Json(name = "Id")
    val id: String,
    @Json(name = "Count")
    val count: Int
)

@JsonClass(generateAdapter = true)
data class TopGameBaseVariantsDto(
    @Json(name = "GameBaseVariantRank")
    val gameBaseVariantRank: Int,
    @Json(name = "NumberOfMatchesCompleted")
    val numberOfMatchesCompleted: Int,
    @Json(name = "GameBaseVariantId")
    val gameBaseVariantId: String,
    @Json(name = "NumberOfMatchesWon")
    val numberOfMatchesWon: Int
)

@JsonClass(generateAdapter = true)
data class ArenaStatsDto(
    @Json(name = "ArenaPlaylistStats")
    val arenaPlaylistStats: List<ArenaPlaylistStatsDto>,
    @Json(name = "HighestCsrAttained")
    val highestCsrAttained: HighestCsrAttainedDto,
    @Json(name = "ArenaGameBaseVariantStats")
    val arenaGameBaseVariantStats: List<ArenaGameBaseVariantStatsDto>,
    @Json(name = "TopGameBaseVariants")
    val topGameBaseVariants: List<TopGameBaseVariantsDto>, // HERE
    @Json(name = "HighestCsrPlaylistId")
    val highestCsrPlaylistId: String,
    @Json(name = "HighestCsrSeasonId")
    val highestCsrSeasonId: String,
    @Json(name = "ArenaPlaylistStatsSeasonId")
    val arenaPlaylistStatsSeasonId: String,
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
    val enemyKills: List<String>, // TODO: Unknown type...
    @Json(name = "WeaponStats") val weaponStats: List<WeaponStatsDto>,
    @Json(name = "Impulses")
    val impulses: List<ImpulseStatCountsDto>,
    @Json(name = "TotalSpartanKills")
    val totalSpartanKills: Int,
    @Json(name = "FastestMatchWin")
    val FastestMatchWin: String?
)
