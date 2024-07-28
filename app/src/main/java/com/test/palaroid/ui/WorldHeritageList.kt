package com.test.palaroid.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.test.palaroid.core.ui.theme.PalaroidTestTheme
import com.test.palaroid.data.entity.WorldHeritageSite
import com.test.palaroid.viewmodel.WorldHeritageListViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun WorldHeritageList(
    viewModel: WorldHeritageListViewModel = koinViewModel()
) {
    val state = viewModel.state.collectAsState()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        LazyColumn(Modifier.padding(innerPadding)) {
            state.value.list.forEach { worldHeritageSite ->
                item {
                    WorldHeritageNode(worldHeritageSite)
                }
            }
        }
    }
}

@Composable
private fun WorldHeritageNode(worldHeritageSite: WorldHeritageSite) {
    worldHeritageSite.name?.let { name ->
        Text(text = name)
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PalaroidTestTheme {

    }
}