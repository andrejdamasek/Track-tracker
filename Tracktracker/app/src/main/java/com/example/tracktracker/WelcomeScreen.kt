package com.example.tracktracker

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.padding
import androidx.navigation.NavController

@Composable
fun WelcomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(206,175,160)), // Boja pozadine prema slici
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

       // Naslov
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Welcome racer!",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier.clickable { /* Ako želiš dodati akciju */ }
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Opis
        Text(
            text = "Are you ready to set fast laps?",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            color = Color.Red
        )

        Spacer(modifier = Modifier.height(10.dp))
        Box()
        {
            Image(
                painter = painterResource(id = R.drawable.staza),
                contentDescription = "Track Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()

            )
            Button(
                onClick = {navController.navigate(Routes.SCREEN_TRACK) },
                colors = ButtonDefaults.buttonColors(contentColor = Color.White, containerColor = Color.Red),
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(700.dp)
                    .padding(top = 620.dp)
                    .align(Alignment.TopCenter),

                shape = RoundedCornerShape(40.dp)
            ) {
                Text(text = "START", fontSize = 40.sp, color = Color.White)
            }


        }

    }
}
