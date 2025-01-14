package com.example.lv.ui.theme

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.lv.ui.Recipe
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class RecipeViewModel: ViewModel() {
    private val db = Firebase.firestore
    val recipesData = mutableStateListOf<Recipe>()
    init {
        fetchDatabaseData()
    }
    private fun fetchDatabaseData() {
        db.collection("recipes")
            .get()
            .addOnSuccessListener { result ->
                for (data in result.documents) {
                    val recipe = data.toObject(Recipe::class.java)
                    if (recipe != null) {
                        recipe.id = data.id
                        recipesData.add(recipe)
                    }
                }
            }
    }
}