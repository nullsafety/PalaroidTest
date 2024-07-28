package com.test.palaroid.data

import android.content.Context
import com.test.palaroid.R
import com.test.palaroid.data.entity.WorldHeritageSite
import com.test.palaroid.domain.WorldHeritageRepository
import com.test.palaroid.utils.getKoinInstance

class WorldHeritageRepositoryImpl : WorldHeritageRepository {

    override fun getWorldHeritageSiteList() =
        parseJsonFromRaw<List<WorldHeritageSite>>(getKoinInstance<Context>(), R.raw.world_heritage)
}