package com.example.tracktracker

data class Tracks(

    val id: String,
    val name:String,
    var info: List<TrackInfo> = listOf()
    )
data class TrackInfo(
    var LapTime:String,
    var AirTemp:String ,
    var TrackTemp:String,
    var NumberOfLapsOnTires:Int,
    var Rain:Boolean
    )

val tracks: List<Tracks> = listOf(
    Tracks(
        id="1",
        name = "Spa",
        info = listOf(
            TrackInfo("1:50:123","27","45",3,Rain = false),
            TrackInfo("1:50:53","27","45",4,Rain = false),
            TrackInfo("1:50:93","27","45",5,Rain = false)
        )
    ),
    Tracks(
         id="2",
        name = "Monza",
        info = listOf(
        TrackInfo("1:50:123","27","45",3,Rain = false),
        TrackInfo("1:50:53","27","45",4,Rain = false),
        TrackInfo("1:50:93","27","45",5,Rain = false)
    )
)
)