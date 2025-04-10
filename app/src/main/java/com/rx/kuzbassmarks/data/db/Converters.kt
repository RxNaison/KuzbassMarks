package com.rx.kuzbassmarks.data.db

import androidx.room.TypeConverter
import com.rx.kuzbassmarks.models.Place
import kotlinx.serialization.json.Json
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.serializer

class Converters {
    private val json = Json { ignoreUnknownKeys = true }

    @TypeConverter
    fun fromStringList(value: String?): List<String>? {
        return value?.let { json.decodeFromString(ListSerializer(serializer<String>()), it) }
    }

    @TypeConverter
    fun toStringList(list: List<String>?): String? {
        return list?.let { json.encodeToString(ListSerializer(serializer<String>()), it) }
    }

    @TypeConverter
    fun fromPlaceList(value: String?): List<Place>? {
        return value?.let { json.decodeFromString(ListSerializer(Place.serializer()), it) }
    }

    @TypeConverter
    fun toPlaceList(list: List<Place>?): String? {
        return list?.let { json.encodeToString(ListSerializer(Place.serializer()), it) }
    }
}