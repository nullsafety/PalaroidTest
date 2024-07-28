package com.test.palaroid.domain

import com.test.palaroid.data.entity.WorldHeritageSite

interface WorldHeritageRepository {
    fun getWorldHeritageSiteList(): List<WorldHeritageSite>
}