package com.test.palaroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.test.palaroid.core.ui.theme.PalaroidTestTheme
import com.test.palaroid.ui.WorldHeritageListUi

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            PalaroidTestTheme {
                WorldHeritageListUi()
            }
        }
    }
}