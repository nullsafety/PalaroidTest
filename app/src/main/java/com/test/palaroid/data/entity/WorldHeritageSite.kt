package com.test.palaroid.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class WorldHeritageSite(
    val id: Long,
    val year: Int?,
    val target: String?,
    val name: String?,
    val type: String?,
    val region: String?,
    val regionLong: String?,
    val coordinates: String?,
    val lat: Float?,
    val lng: Float?,
    val page: String?,
    val image: String?,
    val imageAuthor: String?,
    val shortInfo: String?,
    val longInfo: String?,
)
