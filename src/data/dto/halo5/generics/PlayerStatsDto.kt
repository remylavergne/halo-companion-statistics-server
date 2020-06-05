package dev.remylavergne.halo.data.dto.halo5.generics

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import dev.remylavergne.halo.data.dto.halo5.arena.*


@JsonClass(generateAdapter = true)
data class PlayerStatsDto(
    @Json(name = "XpInfo") val xpInfo: XpInfoDto?,
    @Json(name = "PreviousCsr") val previousCsr: PreviousCsrDto?,
    @Json(name = "CurrentCsr") val currentCsr: CurrentCsrDto?,
    @Json(name = "MeasurementMatchesLeft") val measurementMatchesLeft: Int?,
    @Json(name = "RewardSets") val rewardSets: List<RewardSetsDto>?,
    @Json(name = "KilledOpponentDetails") val killedOpponentDetails: List<KilledByOpponentDetailsDto>?,
    @Json(name = "KilledByOpponentDetails") val killedByOpponentDetails: List<KilledByOpponentDetailsDto>?,
    @Json(name = "FlexibleStats") val flexibleStats: FlexibleStatsDto,
    @Json(name = "CreditsEarned") val creditsEarned: CreditsEarnedDto?,
    @Json(name = "MetaCommendationDeltas") val metaCommendationDeltas: List<String>?,
    @Json(name = "ProgressiveCommendationDeltas") val progressiveCommendationDeltas: List<ProgressiveCommendationDeltasDto>?,
    @Json(name = "BoostInfo") val boostInfo: BoostInfoDto?,
    @Json(name = "Player") val player: PlayerDto,
    @Json(name = "TeamId") val teamId: Int,
    @Json(name = "Rank") val rank: Int,
    @Json(name = "DNF") val dNF: Boolean,
    @Json(name = "AvgLifeTimeOfPlayer") val avgLifeTimeOfPlayer: String,
    @Json(name = "PreMatchRatings") val preMatchRatings: String?,
    @Json(name = "PostMatchRatings") val postMatchRatings: String?,
    @Json(name = "PlayerScore") val playerScore: Int?,
    @Json(name = "GameEndStatus") val gameEndStatus: Int,
    @Json(name = "TotalKills") val totalKills: Int,
    @Json(name = "TotalHeadshots") val totalHeadshots: Int,
    @Json(name = "TotalWeaponDamage") val totalWeaponDamage: Double,
    @Json(name = "TotalShotsFired") val totalShotsFired: Int,
    @Json(name = "TotalShotsLanded") val totalShotsLanded: Int,
    @Json(name = "WeaponWithMostKills") val weaponWithMostKills: WeaponWithMostKillsDto,
    @Json(name = "TotalMeleeKills") val totalMeleeKills: Int,
    @Json(name = "TotalMeleeDamage") val totalMeleeDamage: Double,
    @Json(name = "TotalAssassinations") val totalAssassinations: Int,
    @Json(name = "TotalGroundPoundKills") val totalGroundPoundKills: Int,
    @Json(name = "TotalGroundPoundDamage") val totalGroundPoundDamage: Double,
    @Json(name = "TotalShoulderBashKills") val totalShoulderBashKills: Int,
    @Json(name = "TotalShoulderBashDamage") val totalShoulderBashDamage: Double,
    @Json(name = "TotalGrenadeDamage") val totalGrenadeDamage: Double,
    @Json(name = "TotalPowerWeaponKills") val totalPowerWeaponKills: Int,
    @Json(name = "TotalPowerWeaponDamage") val totalPowerWeaponDamage: Double,
    @Json(name = "TotalPowerWeaponGrabs") val totalPowerWeaponGrabs: Int,
    @Json(name = "TotalPowerWeaponPossessionTime") val totalPowerWeaponPossessionTime: String,
    @Json(name = "TotalDeaths") val totalDeaths: Int,
    @Json(name = "TotalAssists") val totalAssists: Int,
    @Json(name = "TotalGamesCompleted") val totalGamesCompleted: Int,
    @Json(name = "TotalGamesWon") val totalGamesWon: Int,
    @Json(name = "TotalGamesLost") val totalGamesLost: Int,
    @Json(name = "TotalGamesTied") val totalGamesTied: Int,
    @Json(name = "TotalTimePlayed") val totalTimePlayed: String,
    @Json(name = "TotalGrenadeKills") val totalGrenadeKills: Int,
    @Json(name = "MedalAwards") val medalAwards: List<MedalAwardsDto>,
    @Json(name = "DestroyedEnemyVehicles") val destroyedEnemyVehicles: List<EnemyDto>,
    @Json(name = "EnemyKills") val enemyKills: List<EnemyKillsDto>,
    @Json(name = "WeaponStats") val weaponStats: List<WeaponStatsDto>,
    @Json(name = "Impulses") val impulses: List<ImpulsesDto>,
    @Json(name = "TotalSpartanKills") val totalSpartanKills: Int,
    @Json(name = "FastestMatchWin") val fastestMatchWin: String?
)