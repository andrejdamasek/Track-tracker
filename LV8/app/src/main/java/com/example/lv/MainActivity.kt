package com.example.lv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.activity.viewModels
import com.example.lv.ui.RecipeViewModel
import com.example.lv.ui.theme.LVTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel by viewModels<RecipeViewModel>()
        setContent {
            LVTheme {
                NavigationController(viewModel)
            }
        }
    }
}





