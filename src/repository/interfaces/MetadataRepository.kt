package dev.remylavergne.halo.repository.interfaces

import dev.remylavergne.halo.data.enums.Language
import dev.remylavergne.halo.services.interfaces.MetadataService

interface MetadataRepository {

    suspend fun retrieveMetadata(metadataService: MetadataService, language: Language)
}