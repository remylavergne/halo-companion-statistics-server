package dev.remylavergne.halo.data.dto.halo5.generics

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class RoundStatsDto (
	@Json(name = "RoundNumber") val roundNumber : Int,
	@Json(name = "Rank") val rank : Int,
	@Json(name = "Score") val score : Int
)