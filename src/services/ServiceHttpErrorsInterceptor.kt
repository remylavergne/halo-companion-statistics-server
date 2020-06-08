package dev.remylavergne.halo.services

import dev.remylavergne.halo.helpers.LocalStorageHelper
import io.ktor.http.HttpStatusCode
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ServiceHttpErrorsInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val response: Response = chain.proceed(request)

        when (response.code) {
            HttpStatusCode.OK.value -> {
                // No problem
            }
            else -> {
                // Log error into file
                LocalStorageHelper.httpErrorsLogs.appendText("\n Error ${response.code} on request ${request.url}")
            }
        }
        return response
    }
}