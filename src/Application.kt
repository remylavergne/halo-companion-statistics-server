package dev.remylavergne.halo

import io.ktor.application.*
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.features.StatusPages
import io.ktor.gson.gson
import io.ktor.http.HttpStatusCode
import io.ktor.response.*
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main(args: Array<String>) {
    // TODO => Récupérer le port via la config HOCON
    embeddedServer(Netty, port = 8080, module = Application::mainModule).start(wait = true)
}

@Suppress("unused") // Referenced in application.conf
fun Application.mainModule() {
    installPlugins(this)
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
    application.install(DefaultHeaders)
    application.install(CallLogging)
    application.install(ContentNegotiation) {
        gson {
            // Configure Gson here
        }
    }
}

fun Routing.root() {
    get("/") {
        this.call.respond("Hello World!")
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

