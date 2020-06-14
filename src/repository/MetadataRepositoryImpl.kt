package dev.remylavergne.halo.repository

import dev.remylavergne.halo.data.enums.Language
import dev.remylavergne.halo.repository.interfaces.MetadataRepository
import dev.remylavergne.halo.services.interfaces.MetadataService
import dev.remylavergne.halo.services.interfaces.ResponseWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class MetadataRepositoryImpl : MetadataRepository {

    /**
     * Récupère toutes les metadata liées aux fonctions passées dans la lambda
     */
    override suspend fun retrieveMetadata(metadataService: MetadataService, language: Language) =
        withContext(Dispatchers.IO) {
            val results = mutableListOf<ResponseWrapper<List<*>>>()
            // Call all functions inside MetadaService
            metadataService.retrieveTheseMetadata {
                val result = getCampaignMissions(language)
                val result2 = getEnemies(language)
                results.add(result)
                results.add(result2)
            }
        }
}