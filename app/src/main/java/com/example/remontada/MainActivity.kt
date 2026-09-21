package com.example.remontada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.Modifier
import com.example.remontada.presentation.RemontadaApp
import com.example.remontada.presentation.RemontadaViewModel
import com.example.remontada.ui.theme.DarkForestGreen // Ensure this matches your Color.kt import

class MainActivity : ComponentActivity() {
    private val viewModel: RemontadaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This tells Android to let us draw behind the system bars so we can color them
        enableEdgeToEdge()

        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(DarkForestGreen) // Colors the status/nav bar backgrounds
                    .systemBarsPadding() // Pushes the actual app content into the safe zone
            ) {
                RemontadaApp(viewModel = viewModel)
            }
        }
    }
}