package com.rx.kuzbassmarks.data

import com.rx.kuzbassmarks.data.db.PlaceDao
import com.rx.kuzbassmarks.models.Place
import kotlinx.coroutines.flow.Flow


class PlaceRepository(private val placeDao: PlaceDao) {

    val allPlaces: Flow<List<Place>> = placeDao.getAllPlaces()


    suspend fun isEmpty(): Boolean {
        return placeDao.getCount() == 0
    }
}