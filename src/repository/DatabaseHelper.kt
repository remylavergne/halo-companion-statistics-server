package dev.remylavergne.halo.repository

import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.mongodb.client.MongoDatabase
import io.ktor.application.Application
import io.ktor.util.KtorExperimentalAPI
import org.litote.kmongo.KMongo

@KtorExperimentalAPI
object DatabaseHelper {

    lateinit var client: MongoClient
    lateinit var database: MongoDatabase

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
            client = KMongo.createClient(uri = uri)
            database = client.getDatabase(application.environment.config.property("mongodb.name").getString())
        } catch (e: Exception) {
            throw e
        }

        return this
    }

    /** Créer une collection dans la base de données en instance */
    fun createCollection(collection: Halo5Collections) {
        database.createCollection(collection.value)
        println("DEBUG => Collection ${collection.value} created into database ${database.name}")
    }

}