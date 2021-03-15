package com.mistersomov.coinjet.core_ui.effect

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.mistersomov.coinjet.core_ui.CoinJetTheme

@Composable
fun animateDigitColor(digit: Double, initialColor: Color): Color {
    val prev