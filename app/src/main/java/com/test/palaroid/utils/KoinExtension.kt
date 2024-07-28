package com.test.palaroid.utils

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.Qualifier

inline fun <reified T> getKoinInstance(qualifier: Qualifier? = null): T {
    return object : KoinComponent {
        val value: T by inject(qualifier)
    }.value
}