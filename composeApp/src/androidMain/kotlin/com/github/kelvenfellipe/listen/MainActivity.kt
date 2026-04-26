package com.github.kelvenfellipe.listen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import listen.components.Screens.MainScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
//        splashScreen.setOnExitAnimationListener { splashScreenView ->
//            // Create your custom animation.
//            val fadeOut = ObjectAnimator.ofFloat(
//                splashScreenView,
//                View.ALPHA,
//                1f,
//                0f
//            )
//            fadeOut.interpolator = AccelerateInterpolator()
//            fadeOut.duration = 500L // You can tweak the duration
//
//            // Remove the splash screen view after animation ends
//            fadeOut.doOnEnd { splashScreenView.remove() }
//
//            // Start the animation
//            fadeOut.start()
//        }
        enableEdgeToEdge()

        setContent {
            AppAndroidPreview()
        }

    }

}

@Composable
fun AppAndroidPreview() {

    MainScreen()
    MusicPlayer()
}