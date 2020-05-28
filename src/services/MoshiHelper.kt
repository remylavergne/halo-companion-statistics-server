package dev.remylavergne.halo.services

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object MoshiHelper {

    fun <T> getAdapter(jsonClass: Class<T>): JsonAdapter<T> {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return moshi.adapter(jsonClass)
    }
}