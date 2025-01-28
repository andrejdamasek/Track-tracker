package com.example.tracktracker


import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow


class TrackViewModel: ViewModel() {
    private val db = Firebase.firestore
    val tracksData = mutableStateListOf<Tracks>()
    val filteredTracks = mutableStateListOf<Tracks>()
    var selectedCategory = mutableStateOf("ALL")
    var track = MutableStateFlow<Tracks?>(null)

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
           applyFilter()
           }
    }

    fun setSelectedCategory(category: String) {
        selectedCategory.value = category
        applyFilter()
    }

    private fun applyFilter() {
        filteredTracks.clear()
        if (selectedCategory.value == "ALL") {
            filteredTracks.addAll(tracksData)
        } else {
            filteredTracks.addAll(tracksData.filter { it.category == selectedCategory.value })
        }
    }

    fun addTrack(track: Tracks, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        db.collection("tracks").add(track)
            .addOnSuccessListener {documentReference ->
                track.id = documentReference.id
                tracksData.add(track)
                applyFilter()
                onSuccess()
                fetchDatabaseData()
            }
            .addOnFailureListener { e ->
                onFailure(e)
            }
    }

    fun addTrackDay(trackId: String, newDay: TrackDay, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        db.collection("tracks")
            .document(trackId)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    var track = document.toObject(Tracks::class.java)
                    val updatedDays = track?.trackDays?.toMutableList() ?: mutableListOf()

                    updatedDays.add(newDay)

                    db.collection("tracks").document(trackId)
                        .update("trackDays", updatedDays)
                        .addOnSuccessListener {
                            track = track?.copy(trackDays = updatedDays)
                            track?.let {
                                this.track.value = it // 🚀 Ažuriramo MutableStateFlow odmah!
                            }
                            onSuccess()
                        }
                        .addOnFailureListener { e -> onFailure(e) }
                } else {
                    onFailure(Exception("Track with ID $trackId not found"))
                }
            }
            .addOnFailureListener { e -> onFailure(e) }
    }

    fun loadTrack(trackId: String) {
        db.collection("tracks").document(trackId)
            .addSnapshotListener { document, error ->
                if (error != null) {
                    Log.e("Firestore", "Listen failed.", error)
                    return@addSnapshotListener
                }
                if (document != null && document.exists()) {
                    track.value = document.toObject(Tracks::class.java)
                }
            }
    }
}