package com.rx.kuzbassmarks.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rx.kuzbassmarks.models.Place
import kotlinx.coroutines.flow.Flow

@Dao
interface PlaceDao {

    @Query("SELECT * FROM places")
    fun getAllPlaces(): Flow<List<Place>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(places: List<Place>)

    @Query("SELECT * FROM places WHERE id = :id")
    fun getPlaceById(id: Int): Flow<Place?>

    @Query("DELETE FROM places")
    suspend fun deleteAll()

    @Query("SELECT COUNT(*) FROM places")
    suspend fun getCount(): Int
}