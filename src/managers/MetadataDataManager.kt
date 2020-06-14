package dev.remylavergne.halo.managers

import dev.remylavergne.halo.data.enums.Language
import dev.remylavergne.halo.helpers.OkHttpHelper
import dev.remylavergne.halo.jobs.MetadataJob
import dev.remylavergne.halo.repository.MetadataRepositoryImpl
import dev.remylavergne.halo.services.MetadataServiceImpl
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MetadataDataManager {

    /**
     * Download all metadata at once
     */
    fun retrieveMetadata(): MetadataDataManager {
        runBlocking {
            launch {
                MetadataRepositoryImpl().retrieveMetadata(
                    metadataService = MetadataServiceImpl(OkHttpHelper.client),
                    language = Language.ENGLISH
                )
            }
        }

        return this
    }

    fun startMetadataJobUpdater() {
        MetadataJob().create()
    }

}