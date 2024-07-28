package com.test.palaroid.data

import android.content.Context
import kotlinx.serialization.json.Json

inline fun <reified T> parseJsonFromRaw(context: Context, resId: Int): T {
    val inputStream = context.resources.openRawResource(resId)
    val jsonString = inputStream.bufferedReader().use { it.readText() }
    return Json.decodeFromString(jsonString)
}