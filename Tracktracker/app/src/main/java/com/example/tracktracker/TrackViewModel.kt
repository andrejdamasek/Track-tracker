package com.example.tracktracker

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class TrackViewModel: ViewModel() {
    private val db = Firebase.firestore

    val tracksData = mutableStateListOf<Tracks>()
    private val _filteredTracks = mutableStateListOf<Tracks>()
    val filteredTracks: List<Tracks> get() = _filteredTracks


    init {
        fetchDatabaseData()
    }

    private fun fetchDatabaseData() {
        db.collection("tracks")
            .get()
            .addOnSuccessListener { result ->
                tracksData.clear()
                for (data in result.documents) {
                    val track = data.toObject(Tracks::class.java)
                    if (track != null) {
                        track.id = data.id
                        tracksData.add(track)
                    }
                }
                filterTracksByCategory("ALL")
            }
    }

    fun filterTracksByCategory(category: String) {
        _filteredTracks.clear()
        if (category == "ALL") {
            _filteredTracks.addAll(tracksData)
        } else {
            _filteredTracks.addAll(tracksData.filter { it.category == category })
        }
    }

    fun addTrack(track: Tracks, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        db.collection("tracks").add(track)
            .addOnSuccessListener {documentReference ->
                track.id = documentReference.id
                tracksData.add(track)
                filterTracksByCategory("ALL")
                onSuccess()
                fetchDatabaseData()
                onSuccess()
            }
            .addOnFailureListener { e ->
                onFailure(e)
            }
    }

    fun addTrackDay(trackId: String, newDay: TrackDay, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        db.collection("tracks")
            .document(trackId) // Firestore dokument ID (String)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    val track = document.toObject(Tracks::class.java)
                    val updatedDays = track?.trackDays?.toMutableList() ?: mutableListOf()

                    updatedDays.add(newDay)

                    db.collection("tracks").document(trackId)
                        .update("trackDays", updatedDays)
                        .addOnSuccessListener { onSuccess() }
                        .addOnFailureListener { e -> onFailure(e) }
                } else {
                    onFailure(Exception("Track with ID $trackId not found"))
                }
            }
            .addOnFailureListener { e -> onFailure(e) }
    }
}