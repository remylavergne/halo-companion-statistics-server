package dev.remylavergne.halo

import dev.remylavergne.halo.helpers.ApiKey
import dev.remylavergne.halo.helpers.ApiKeyHelper
import dev.remylavergne.halo.helpers.Client
import dev.remylavergne.halo.helpers.OkHttpHelper
import dev.remylavergne.halo.repository.DatabaseHelper
import dev.remylavergne.halo.services.StatsHalo5ServiceImpl
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.auth.UserIdPrincipal
import io.ktor.auth.authenticate
import io.ktor.auth.basic
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.features.StatusPages
import io.ktor.gson.gson
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.util.KtorExperimentalAPI

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@KtorExperimentalAPI
fun Application.mainModule() {
    installPlugins(this)
    DatabaseHelper(this).initialize()
    OkHttpHelper.init(this)
    routing {
        root()
        admin()
    }
}

fun installPlugins(application: Application) {
    application.install(StatusPages) {
        exception { cause: Throwable ->
            call.respond(HttpStatusCode.InternalServerError)
        }
    }
    application.install(CallLogging)
    application.install(ContentNegotiation) {
        gson {
            // Configure Gson here
        }
    }
    application.install(DefaultHeaders)
    application.install(Authentication) {
        basic(name = "admin") {
            realm = "Api Stats"
            validate { credentials ->
                if (credentials.name == application.environment.config.property("admin-authentication.username")
                        .getString() && credentials.password == application.environment.config.property("admin-authentication.username")
                        .getString()
                ) {
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
        }
    }
}

/**
 * Cette route permet pour le moment de tester les implémentations. Avant l'implémentation de la couche business.
 */
fun Routing.root() {
    get("/") {
        // val result = MetadataServiceImpl(OkHttpHelper.client).getWeapons(Language.FRENCH)
        //val result = StatsHalo5ServiceImpl(OkHttpHelper.client).getCampaignMatchResult("3824b687-8809-4ccf-9f26-b597e7495c47") // Stats FakeRunner Arena game
        // Custom Match Id => e75675c7-4bba-4914-bcb4-2984876b03bd
        // Campaign Match Id => 3824b687-8809-4ccf-9f26-b597e7495c47
        // val result = StatsHalo5ServiceImpl(OkHttpHelper.client).getCustomMatchResult("e75675c7-4bba-4914-bcb4-2984876b03bd") // Stats FakeRunner Custom game
        // val result = StatsHalo5ServiceImpl(OkHttpHelper.client).getWarzoneMatchResult("01968171-4b8c-4a7c-ba93-b1ea8ae291c7") // Stats FakeRunner Warzone game
        // val result = StatsHalo5ServiceImpl(OkHttpHelper.client).getPlayerCommendations("fakerunner")
        // val result = StatsHalo5ServiceImpl(OkHttpHelper.client).getPlayerMatchHistory("fakerunner")
        // val result = StatsHalo5ServiceImpl(OkHttpHelper.client).getPlayerServiceRecordsArena(listOf("fakerunner"))
        // val result = StatsHalo5ServiceImpl(OkHttpHelper.client).getPlayerServiceRecordsArena(listOf("fakerunner", "IMFRENCHYOUKNOW"))
        val result = StatsHalo5ServiceImpl(OkHttpHelper.client).getPlayerServiceRecordsCampaign(
            listOf(
                "fakerunner",
                "IMFRENCHYOUKNOW"
            )
        )
        this.call.respond(result.toString())
    }


    get("/health_check") {
        // Check databases/other services.
        call.respondText("OK")
    }
}

fun Routing.player() {
    get("/player/{id}") {
        // TODO => Example de récupération d'un paramètre
        this.call.respond("P")
    }
}

fun Routing.admin() {
    authenticate("admin") {
        get("/generate-api-key/{client}") {
            val client = call.parameters["client"]?.toLowerCase()

            if (client == null) {
                call.respond(HttpStatusCode.NotFound, "Unknown client")
            }

            client?.let { c: String ->
                val isFound: Boolean = Client.values().any { it.value == c }

                if (isFound) {
                    val apiKey: ApiKey = ApiKeyHelper.generate(c)
                    // Store Api Key

                    // Send it
                    call.respondText(apiKey.key)
                } else {
                    call.respond(HttpStatusCode.NotFound, "Unknown client")
                }
            }
        }
    }
}

