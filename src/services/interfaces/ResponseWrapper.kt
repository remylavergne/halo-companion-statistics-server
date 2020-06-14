package dev.remylavergne.halo.services.interfaces

interface ResponseWrapper<T> {
    val apiInformations: ApiHeaders?
    val data: T?
}