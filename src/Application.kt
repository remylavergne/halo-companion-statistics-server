package dev.remylavergne.halo

import dev.remylavergne.halo.data.enums.Language
import dev.remylavergne.halo.repository.DatabaseHelper
import dev.remylavergne.halo.services.MetadataServiceImpl
import dev.remylavergne.halo.helpers.OkHttpHelper
import dev.remylavergne.halo.services.StatsHalo5ServiceImpl
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
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
import okhttp3.OkHttpClient

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@KtorExperimentalAPI
fun Application.mainModule() {
    installPlugins(this)
    DatabaseHelper(this).initialize()
    OkHttpHelper.init(this)
    routing {
        root()
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
}

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
        val result = StatsHalo5ServiceImpl(OkHttpHelper.client).getPlayerServiceRecordsCampaign(listOf("fakerunner", "IMFRENCHYOUKNOW"))
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

