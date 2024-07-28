package com.test.palaroid.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.palaroid.data.entity.WorldHeritageSite
import com.test.palaroid.domain.WorldHeritageRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class WorldHeritageListViewModel(
    repository: WorldHeritageRepository
) : ViewModel() {
    private val _state = MutableStateFlow(WorldHeritageListState())
    val state: StateFlow<WorldHeritageListState> =
        _state.stateIn(viewModelScope, SharingStarted.Eagerly, WorldHeritageListState())

    init {
        viewModelScope.launch {
            val list = repository.getWorldHeritageSiteList()
            _state.value = WorldHeritageListState(
                list = list,
                filteredList = list,
                showLoading = false
            )
        }
    }

    fun onSearchTextChanged(searchText: String) {
        _state.value = _state.value.copy(
            searchText = searchText,
            showLoading = true
        )
        val filteredList = if (searchText.isEmpty()) {
            _state.value.list
        } else {
            _state.value.list.filter { checkByFilter(worldHeritageSite = it, searchText) }
        }
        _state.value = _state.value.copy(
            filteredList = filteredList,
            showLoading = false
        )
    }

    private fun checkByFilter(
        worldHeritageSite: WorldHeritageSite,
        searchText: String
    ) = worldHeritageSite.name?.contains(searchText, ignoreCase = true) == true ||
            worldHeritageSite.shortInfo?.contains(searchText, ignoreCase = true) == true
}

data class WorldHeritageListState(
    val list: List<WorldHeritageSite> = emptyList(),
    val filteredList: List<WorldHeritageSite> = emptyList(),
    val searchText: String = "",
    val showLoading: Boolean = true,
)