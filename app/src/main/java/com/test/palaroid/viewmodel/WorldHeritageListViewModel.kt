package com.test.palaroid.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.palaroid.data.entity.WorldHeritageSite
import com.test.palaroid.domain.WorldHeritageRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WorldHeritageListViewModel(
    repository: WorldHeritageRepository
) : ViewModel() {
    private val _state = MutableStateFlow(WorldHeritageListState())
    val state: StateFlow<WorldHeritageListState> = _state

    init {
        viewModelScope.launch {
            val list = repository.getWorldHeritageSiteList()
            _state.value = WorldHeritageListState(list)
        }
    }
}

data class WorldHeritageListState(
    val list: List<WorldHeritageSite> = emptyList()
)