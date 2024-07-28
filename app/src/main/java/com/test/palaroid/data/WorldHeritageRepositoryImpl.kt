package com.test.palaroid.data

import android.content.Context
import com.test.palaroid.R
import com.test.palaroid.data.entity.WorldHeritageSite
import com.test.palaroid.domain.WorldHeritageRepository
import kotlinx.serialization.json.Json

class WorldHeritageRepositoryImpl(
    private val context: Context
) : WorldHeritageRepository {

    override fun getWorldHeritageSiteList() =
        parseJsonFromRaw<List<WorldHeritageSite>>(context, R.raw.world_heritage)

    private inline fun <reified T> parseJsonFromRaw(context: Context, resId: Int): T {
        val inputStream = context.resources.openRawResource(resId)
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        return Json.decodeFromString(jsonString)
    }
}