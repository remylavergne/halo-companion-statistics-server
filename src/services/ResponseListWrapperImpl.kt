package dev.remylavergne.halo.services

import dev.remylavergne.halo.services.interfaces.ApiHeaders
import dev.remylavergne.halo.services.interfaces.ResponseListWrapper

data class ResponseListWrapperImpl<T>(override val apiInformations: ApiHeaders, override val data: T?) : ResponseListWrapper<T>