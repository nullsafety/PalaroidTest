package com.test.palaroid.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.palaroid.core.ui.theme.PalaroidTestTheme
import com.test.palaroid.data.entity.WorldHeritageSite
import com.test.palaroid.viewmodel.WorldHeritageListState
import com.test.palaroid.viewmodel.WorldHeritageListViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun WorldHeritageListUi(
    viewModel: WorldHeritageListViewModel = koinViewModel()
) {
    val state = viewModel.state.collectAsState()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(Modifier.padding(innerPadding)) {
            SearchField(state, viewModel::onSearchTextChanged)
            if (state.value.showLoading) {
                CircularProgressIndicator(modifier = Modifier.fillMaxSize())
            } else {
                LazyColumn(Modifier.padding(horizontal = 12.dp)) {
                    items(state.value.filteredList) { worldHeritageSite ->
                        WorldHeritageNode(worldHeritageSite)
                    }
                }
            }
        }
    }
}

@Composable
private fun SearchField(
    state: State<WorldHeritageListState>,
    onSearchTextChanged: (String) -> Unit
) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = state.value.searchText,
        onValueChange = onSearchTextChanged
    )
}

@Composable
private fun WorldHeritageNode(worldHeritageSite: WorldHeritageSite) {
    Card(modifier = Modifier.padding(top = 12.dp)) {
        Column(modifier = Modifier.padding(12.dp)) {
            worldHeritageSite.name?.let { name ->
                WorldHeritageField(fieldVal = name, fieldName = "name")
            }
            worldHeritageSite.shortInfo?.let { shortInfo ->
                WorldHeritageField(fieldVal = shortInfo, fieldName = "shortInfo")
            }
            worldHeritageSite.year?.let { year ->
                WorldHeritageField(fieldVal = year.toString(), fieldName = "year")
            }
            worldHeritageSite.regionLong?.let { region ->
                WorldHeritageField(fieldVal = region, fieldName = "region")
            }
        }
    }
}

@Composable
private fun WorldHeritageField(fieldVal: String, fieldName: String) {
    Column {
        Text(style = MaterialTheme.typography.titleMedium, text = fieldName)
        Text(style = MaterialTheme.typography.bodyMedium, text = fieldVal)
    }
}


@Preview(showBackground = true)
@Composable
fun WorldHeritageNodePreview() {
    PalaroidTestTheme {
        WorldHeritageNode(
            WorldHeritageSite(
                id = 1,
                year = 1000,
                target = "target",
                name = "WorldHeritage",
                type = "type",
                region = "region",
                regionLong = "regionLong",
                coordinates = "",
                lat = 52.32113F,
                lng = 67.67821F,
                page = "",
                image = "",
                imageAuthor = "imageAuthor",
                shortInfo = "shortInfo",
                longInfo = "longInfo",
            )
        )
    }
}