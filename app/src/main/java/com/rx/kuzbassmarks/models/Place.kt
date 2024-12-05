package com.rx.kuzbassmarks.models

data class Place(
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
