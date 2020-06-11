package dev.remylavergne.halo.services

import dev.remylavergne.halo.data.enums.Language
import dev.remylavergne.halo.services.interfaces.ApiHeaders
import okhttp3.Headers

class ApiHeadersImpl(headers: Headers, language: Language = Language.ENGLISH, requestUrl: String) : ApiHeaders {
    override var apiVersion: String = ""
    override var apiInstance: String = ""
    override var apiActivityId: String = ""
    override var apiRequestUrl: String = ""
    override var apiLanguage: String = ""
    override var apiRequestDate: String = ""

    init {
        headers["X-343-Version"]?.let { apiVersion = it }
        headers["X-343-Instance"]?.let { apiInstance = it }
        headers["X-343-Activity-ID"]?.let { apiActivityId = it }
        headers["Date"]?.let { apiRequestDate = it }
        apiLanguage = language.value
        apiRequestUrl = requestUrl
    }
}