package com.example.tracktracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.tracktracker.Routes.NavigationController
import com.example.tracktracker.ui.theme.TrackTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel by viewModels<TrackViewModel>()

        setContent {
            TrackTrackerTheme {
                NavigationController(viewModel)
            }
        }
    }
}


