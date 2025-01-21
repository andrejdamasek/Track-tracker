package com.example.tracktracker


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.firebase.firestore.FirebaseFirestore



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNewTrackDayScreen(navController: NavController, trackId: Int,viewModel: ViewModel) {
    var bestTime by remember { mutableStateOf("") }
    var lapsCompleted by remember { mutableStateOf("") }
    var topSpeed by remember { mutableStateOf("") }
    var trackTemp by remember { mutableStateOf("") }
    var day by remember { mutableStateOf("") }
    var month by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }
    val firestore = FirebaseFirestore.getInstance()


    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.carbonpozadina), // Zameni sa stvarnim imenom fajla
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Prilagođava sliku ekranu
        )
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,

            ) {
                // Back Button
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }

                // Centriran Naslov
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    // Naslov
                    Text("Adding new track day", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)
                }

                // Spacer koji balansira prostor (Desno)
                Spacer(modifier = Modifier.weight(0.1f))


            }


            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = bestTime,
                onValueChange = { bestTime = it },
                label = { Text("Best lap time") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.LightGray, // Svetlosiva pozadina
                    focusedBorderColor = Color.White, // Crna ivica kada je fokusirano
                    unfocusedBorderColor = Color.Gray // Siva ivica kada nije fokusirano

            ))

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = lapsCompleted,
                onValueChange = { lapsCompleted = it },
                label = { Text("Laps completed") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.LightGray, // Svetlosiva pozadina
                    focusedBorderColor = Color.Black, // Crna ivica kada je fokusirano
                    unfocusedBorderColor = Color.Gray // Siva ivica kada nije fokusirano

                )
            )

            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = topSpeed,
                onValueChange = { topSpeed = it },
                label = { Text("Top speed") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.LightGray, // Svetlosiva pozadina
                    focusedBorderColor = Color.Black, // Crna ivica kada je fokusirano
                    unfocusedBorderColor = Color.Gray // Siva ivica kada nije fokusirano

                )
            )

            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = trackTemp,
                onValueChange = { trackTemp = it },
                label = { Text("Track temp") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.LightGray, // Svetlosiva pozadina
                    focusedBorderColor = Color.Black, // Crna ivica kada je fokusirano
                    unfocusedBorderColor = Color.Gray // Siva ivica kada nije fokusirano

                )
            )

            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = day,
                onValueChange = { day = it },
                label = { Text("Day") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.LightGray, // Svetlosiva pozadina
                    focusedBorderColor = Color.Black, // Crna ivica kada je fokusirano
                    unfocusedBorderColor = Color.Gray // Siva ivica kada nije fokusirano

                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = month,
                onValueChange = { month = it },
                label = { Text("Month") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.LightGray, // Svetlosiva pozadina
                    focusedBorderColor = Color.Black, // Crna ivica kada je fokusirano
                    unfocusedBorderColor = Color.Gray // Siva ivica kada nije fokusirano

                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = year,
                onValueChange = { year = it },
                label = { Text("Year") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.LightGray, // Svetlosiva pozadina
                    focusedBorderColor = Color.Black, // Crna ivica kada je fokusirano
                    unfocusedBorderColor = Color.Gray // Siva ivica kada nije fokusirano

                )
            )

            Spacer(modifier = Modifier.height(20.dp))


            Button(onClick = {
                val newDay = TrackDay(
                    bestTime = bestTime,
                    day = day,
                    month = month,
                    year = year,
                    lapsCompleted = lapsCompleted.toLong(),
                    topSpeed = topSpeed.toLong(),
                    trackTemp = trackTemp.toLong()
                )
                firestore.collection("tracks")
                    .whereEqualTo("id", trackId) // Pronađi dokument gde je id == trackId
                    .get()
                    .addOnSuccessListener { documents ->
                        if (!documents.isEmpty) {
                            val document = documents.documents[0] // Prvi pronađeni dokument
                            val trackRef = firestore.collection("tracks").document(document.id) // Pravi Firestore ID

                            // Sada možeš ažurirati trackDays
                            val track = document.toObject(Tracks::class.java)
                            val updatedDays = track?.trackDays?.toMutableList() ?: mutableListOf()

                            updatedDays.add(newDay)

                            trackRef.update("trackDays", updatedDays)
                                .addOnSuccessListener {
                                    Log.d("FirestoreSuccess", "Track day added successfully")
                                    navController.popBackStack()
                                }
                                .addOnFailureListener { e -> Log.e("FirestoreError", "Error updating trackDays", e) }
                        } else {
                            Log.e("FirestoreError", "Track with ID $trackId not found")
                        }
                    }
                    .addOnFailureListener { e -> Log.e("FirestoreError", "Error fetching track", e) }

            })
             {
                Text("Add track day", fontSize = 18.sp, color = Color.Black)
            }


        }
    }
}


