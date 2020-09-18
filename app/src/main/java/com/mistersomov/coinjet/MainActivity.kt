package com.mistersomov.coinjet

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.mistersomov.coinjet.core_ui.CoinJetTheme
import com.mistersomov.coinjet.core_ui.MainTheme
import com.mistersomov.coinjet.screen.coin.CoinScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme {
                SetOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                SetSystemUiController()
                val navController = rememberNavController()

                CoinScreen(navController = navController)
            }
        }
    }
}

@Composable
fun SetSystemUiController() {
    val systemUiController = rememberSystemUiController()
    val statusBarColor = CoinJetTheme.colors.primary
    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor
        )
    }
}

@Composable
fun SetOrientation(orientation: Int) {
    val context = LocalContext.current
    DisposableEffect(Unit) {
        val activity = cont