package dev.remylavergne.halo.services

import dev.remylavergne.halo.services.interfaces.ApiHeaders
import dev.remylavergne.halo.services.interfaces.ResponseWrapper

data class ResponseWrapperImpl<T>(override val apiInformations: ApiHeaders? = null, override val data: T? = null) :
    ResponseWrapper<T>