package com.example.tracktracker

data class Tracks
    (
    var id: String = "",
    val name: String="",
    val category:String="",
    val trackDays: List<TrackDay> = emptyList()
    )

data class TrackDay(
    val day: String="",
    val month: String="",
    val year: String="",
    val bestTime: String="",
    val lapsCompleted: Long = 0,
    val topSpeed: Long = 0,
    val trackTemp: Long = 0
)