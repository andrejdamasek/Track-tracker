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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.navigation.NavController


@Composable
fun AddNewTrackDayScreen(navController: NavController, trackId: String,viewModel: TrackViewModel) {
    var bestTime by remember { mutableStateOf("") }
    var lapsCompleted by remember { mutableStateOf("") }
    var topSpeed by remember { mutableStateOf("") }
    var trackTemp by remember { mutableStateOf("") }
    var day by remember { mutableStateOf("") }
    var month by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.carbonpozadina),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
            )
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }

                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Adding new track day", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)
                }

                Spacer(modifier = Modifier.weight(0.1f)) //radi centriranja naslova tj. pomicanje naslova malo lijevo
            }

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = bestTime,
                onValueChange = { bestTime = it },
                label = { Text("Best lap time") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.LightGray,
                    unfocusedContainerColor = Color.LightGray,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.Black

                ))

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = lapsCompleted,
                onValueChange = { lapsCompleted = it },
                label = { Text("Laps completed") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.LightGray,
                    unfocusedContainerColor = Color.LightGray,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.Black

                )
            )

            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = topSpeed,
                onValueChange = { topSpeed = it },
                label = { Text("Top speed") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.LightGray,
                    unfocusedContainerColor = Color.LightGray,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.Black
                )
            )

            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = trackTemp,
                onValueChange = { trackTemp = it },
                label = { Text("Track temp") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.LightGray,
                    unfocusedContainerColor = Color.LightGray,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.Black
                )
            )

            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = day,
                onValueChange = { day = it },
                label = { Text("Day") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.LightGray,
                    unfocusedContainerColor = Color.LightGray,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.Black
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = month,
                onValueChange = { month = it },
                label = { Text("Month") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.LightGray,
                    unfocusedContainerColor = Color.LightGray,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.Black
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = year,
                onValueChange = { year = it },
                label = { Text("Year") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.LightGray,
                    unfocusedContainerColor = Color.LightGray,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.Black
                )
            )

            Spacer(modifier = Modifier.height(250.dp))

            Button(onClick = {
                val newDay = TrackDay(
                    bestTime = bestTime,
                    day = day,
                    month = month,
                    year = year,
                    lapsCompleted = lapsCompleted.toLongOrNull() ?: 0L,
                    topSpeed = topSpeed.toLongOrNull() ?: 0L,
                    trackTemp = trackTemp.toLongOrNull() ?: 0L
                )

                viewModel.addTrackDay(
                    trackId,
                    newDay,
                    onSuccess = { navController.popBackStack() },
                    onFailure = { e -> Log.e("FirestoreError", "Error adding track day", e) }
                )
            },
              modifier = Modifier.fillMaxWidth()
                .height(60.dp),
              shape = RoundedCornerShape(12.dp),
              colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
            ){
                Text("Add track day", fontSize = 18.sp, color = Color.Black)
            }
        }
    }
}