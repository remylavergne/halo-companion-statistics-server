package dev.remylavergne.halo.helpers

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


object MoshiHelper {

    fun <T> getAdapter(jsonClass: Class<T>): JsonAdapter<T> {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return moshi.adapter(jsonClass)
    }

    fun <T> getListAdapter(jsonClass: Class<T>): JsonAdapter<List<T>> {
        val type =
            Types.newParameterizedType(List::class.java, jsonClass)
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        return moshi.adapter(type)
    }

}