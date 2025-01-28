package com.example.tracktracker

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
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
fun TrackScreen(navController: NavController,viewModel: TrackViewModel) {

    val categories = remember { mutableStateListOf("ALL", "Carting", "Formula", "Rally", "Other") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.pozadina),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
                        tint = Color.Black
                    )
                }

                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "TRACKS",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.weight(0.2f))
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Categories",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(horizontal = 25.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                items(categories) { category ->
                    Button(
                        onClick = { viewModel.setSelectedCategory(category) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = when (category) {
                                "ALL" -> Color(0x804DC6B1)
                                "Carting" -> Color(0xB30C8EC6)
                                "Formula" -> Color(0xB3236AD4)
                                "Rally" -> Color(0xB3099DDE)
                                "Other" -> Color(0xB3194993)
                                else -> Color.Gray
                            }
                        )
                    ) {
                        Text(text = category, color = Color.Black)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(viewModel.filteredTracks) { track ->
                    Button(
                        onClick = { navController.navigate(Routes.getTrackPath(track.id))},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = when (track.category) {
                                "Carting" -> Color(0xB30C8EC6)
                                "Formula" -> Color(0xB3236AD4)
                                "Rally" -> Color(0xB3099DDE)
                                "Other" -> Color(0xB3194993)
                                else -> Color.Gray
                            }
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                            .height(80.dp)
                    ) {
                        Text(text = track.name, fontSize = 24.sp, color = Color.Black)
                    }
                }

                item {
                    Button(
                        onClick = { navController.navigate(Routes.SCREEN_ADD_NEW_TRACK) },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            containerColor = Color(0x804DC6B1)
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .height(80.dp)
                    ) {
                        Text(text = "New track", fontSize = 24.sp, color = Color.Black)
                    }
                }
            }
        }
    }
}