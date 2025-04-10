package com.rx.kuzbassmarks.models // Adjust package as needed

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.rx.kuzbassmarks.data.PlaceRepository
import com.rx.kuzbassmarks.data.db.AppDatabase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class MapViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PlaceRepository

    init {
        val placeDao = AppDatabase.getDatabase(application).placeDao()
        repository = PlaceRepository(placeDao)
    }

    val places: StateFlow<List<Place>> = repository.allPlaces
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )

    class MapViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MapViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MapViewModel(application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}