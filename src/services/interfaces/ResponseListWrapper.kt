package dev.remylavergne.halo.services.interfaces

interface ResponseListWrapper<T> {
    val apiInformations: ApiHeaders?
    val data: T?
}