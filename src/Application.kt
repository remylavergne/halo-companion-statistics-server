package dev.remylavergne.halo

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
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
    routing {
       root()
    }
}

fun Routing.root() {
    get("/") {
        this.call.respond("Hello World!")
    }
}

fun Routing.player() {
    get("/player/{id}") {

    }
}

