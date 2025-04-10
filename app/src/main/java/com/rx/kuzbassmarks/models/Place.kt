package com.rx.kuzbassmarks.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.rx.kuzbassmarks.data.db.Converters
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "places")
@TypeConverters(Converters::class)
data class Place(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    val x: Float,
    val y: Float,
    val title: String,
    val quickAbout: String,
    val fullStory: String,
    val years: List<String>,
    val storyLine: List<String>,
    val latitude: Double,
    val longitude: Double,
    var modelPath: String,
    val subPlaces: List<Place>? = null
)