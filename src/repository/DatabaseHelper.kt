package dev.remylavergne.halo.repository

import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.mongodb.client.MongoDatabase
import io.ktor.application.Application
import io.ktor.util.KtorExperimentalAPI
import org.litote.kmongo.KMongo

@KtorExperimentalAPI
object DatabaseHelper {

    private lateinit var client: MongoClient
    private lateinit var database: MongoDatabase

    @Throws(Exception::class)
    fun initialize(application: Application): DatabaseHelper {
        val uri =
            MongoClientURI(
                "mongodb://${application.environment.config.property("mongodb.username")
                    .getString()}:${application.environment.config.property(
                    "mongodb.password"
                ).getString()}@${application.environment.config.property("mongodb.hostname")
                    .getString()}:${application.environment.config.property(
                    "mongodb.port"
                ).getString()}"
            )

        try {
            this.client = KMongo.createClient(uri = uri)
            this.database = this.client.getDatabase(application.environment.config.property("mongodb.name").getString())
        } catch (e: Exception) {
            throw e
        }

        return this
    }

    /** Créer une collection dans la base de données en instance */
    fun createCollection(collection: Halo5Collections) {
        if (!this.isCollectionExists(collection)) {
            this.database.createCollection(collection.value)
            println("DEBUG => Collection ${collection.value} created into database ${database.name}")
        }
    }

    /** Vérifie si une collection existe déjà */
    private fun isCollectionExists(collection: Halo5Collections): Boolean {
        return try {
            this.database.getCollection(collection.value)
            true
        } catch (e: IllegalArgumentException) {
            println("DEBUG => $e")
            false
        }
    }

}