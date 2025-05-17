package com.artforyou.difa.utils.extension

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.navigation.NavType
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlin.reflect.KClass

class CustomNavType<T: Parcelable> (
    private val clazz: KClass<T>,
    private val serializer: KSerializer<T>
) : NavType<T>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): T? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, clazz.java)
        } else {
            bundle.getParcelable(key)
        }
    }

    override fun parseValue(value: String): T {
        Log.d("CustomNavType", "Parsing: $value to ${clazz.simpleName}")
        return Json.decodeFromString(serializer, value)
    }

    override fun put(bundle: Bundle, key: String, value: T) {
        bundle.putParcelable(key, value)
    }

    override fun serializeAsValue(value: T): String {
        val jsonString = Json.encodeToString(serializer, value)
        Log.d("CustomNavType", "Serializing: $value to $jsonString")
        return jsonString
    }

}