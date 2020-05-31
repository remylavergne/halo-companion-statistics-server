package dev.remylavergne.halo

import dev.remylavergne.halo.data.enums.Language
import dev.remylavergne.halo.repository.DatabaseHelper
import dev.remylavergne.halo.services.MetadataServiceImpl
import dev.remylavergne.halo.services.OkHttpHelper
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

/*fun main(args: Array<String>) {
    // TODO => Récupérer le port via la config HOCON
    embeddedServer(Netty, port = 8080, module = Application::mainModule).start(wait = true)
}*/

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
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
    // Send automatically API KEY into header
    application.install(DefaultHeaders)
}

fun Routing.root() {
    get("/") {
        val result = MetadataServiceImpl(OkHttpHelper.client).getCommendations(Language.FRENCH)
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

