package dev.remylavergne.halo.repository

import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.mongodb.client.MongoDatabase
import io.ktor.application.Application
import io.ktor.util.KtorExperimentalAPI
import org.litote.kmongo.KMongo

@KtorExperimentalAPI
class DatabaseHelper(private val application: Application) {

    private lateinit var client: MongoClient
    private lateinit var database: MongoDatabase

    @Throws(Exception::class)
    fun initialize(): DatabaseHelper {
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
            client = KMongo.createClient(uri = uri)
            database = client.getDatabase(application.environment.config.property("mongodb.name").getString())
        } catch (e: Exception) {
            throw e
        }

        return this
    }

}