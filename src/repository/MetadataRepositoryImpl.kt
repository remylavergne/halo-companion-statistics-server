package dev.remylavergne.halo.repository

import dev.remylavergne.halo.data.enums.Language
import dev.remylavergne.halo.repository.interfaces.MetadataRepository
import dev.remylavergne.halo.services.interfaces.MetadataService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class MetadataRepositoryImpl : MetadataRepository {

    override suspend fun retrieveMetadata(metadataService: MetadataService, language: Language) =
        withContext(Dispatchers.IO) {
            // Call all functions inside MetadaService
            metadataService.retrieveEveryMetadata {
                val campaignMissions = getCampaignMissions(language)

                println()
            }

        }
}