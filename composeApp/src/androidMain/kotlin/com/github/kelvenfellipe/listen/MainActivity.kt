package com.github.kelvenfellipe.listen

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.animation.doOnEnd
import listen.components.Music.SongDisplay
import listen.components.Music.songs

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        splashScreen.setOnExitAnimationListener { splashScreenView ->
            // Create your custom animation.
            val fadeOut = ObjectAnimator.ofFloat(
                splashScreenView,
                View.ALPHA,
                1f,
                0f
            )
            fadeOut.interpolator = AccelerateInterpolator()
            fadeOut.duration = 500L // You can tweak the duration

            // Remove the splash screen view after animation ends
            fadeOut.doOnEnd { splashScreenView.remove() }

            // Start the animation
            fadeOut.start()
        }
        setContent {
            AppAndroidPreview()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .statusBarsPadding()
            .padding(8.dp)
    ) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(songs) { song -> SongDisplay(song) }
        }
    }
}