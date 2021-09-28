package com.kts_android.strava

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class SavestateModel(private val state: SavedStateHandle) : ViewModel() {

    val filteredData: LiveData<String> = state.getLiveData<String>("query")
    val filteredData_password: LiveData<String> = state.getLiveData<String>("password")

    fun setQuery(query: String) {
        state["query"] = query
    }

    fun setpass(query: String) {
        state["password"] = query
    }

    }