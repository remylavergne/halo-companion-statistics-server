package dev.remylavergne.halo.repository

import org.litote.kmongo.*

object Database {

   /* private lateinit var client: MongoClient
    private lateinit var database: MongoDatabase
    private lateinit var collection: MongoCollection<Email>
    private lateinit var smtpDetailsCollection: MongoCollection<SmtpDetails>

    private val uri =
        MongoClientURI("mongodb://${EnvironmentVariables.mongoUsername}:${EnvironmentVariables.mongoPassword}@${EnvironmentVariables.mongoHostname}:${EnvironmentVariables.mongoPort}")

    @Throws(Exception::class)
    fun initialization() {
        try {
            client = KMongo.createClient(uri = uri)
            database = client.getDatabase(DATABASE_NAME)
            collection = database.getCollection<Email>()
            smtpDetailsCollection = database.getCollection<SmtpDetails>()
        } catch (e: Exception) {
            throw e
        }
    }

    */

}