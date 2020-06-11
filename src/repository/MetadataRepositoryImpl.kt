package dev.remylavergne.halo.repository

import dev.remylavergne.halo.data.enums.Language
import dev.remylavergne.halo.repository.interfaces.MetadataRepository
import dev.remylavergne.halo.services.interfaces.MetadataService


class MetadataRepositoryImpl : MetadataRepository {

    override suspend fun persistAllMetadata(metadataService: MetadataService, language: Language) {
        // Call all functions inside MetadaService
        metadataService.retrieveEveryMetadata {
            val campaignMissions = getCampaignMissions(language)
            val commendations = getCommendations(language)

            println()
        }

    }
}