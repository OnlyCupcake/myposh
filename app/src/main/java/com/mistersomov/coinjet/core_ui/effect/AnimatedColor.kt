package com.mistersomov.coinjet.core_ui.effect

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.mistersomov.coinjet.core_ui.CoinJetTheme

@Composable
fun animateDigitColor(digit: Double, initialColor: Color): Color {
    val previousDigit by remember { mutableStateOf(digit) }
    val targetColor = if (digit == previousDigit) {
        initialColor
    } else if (digit > previousDigit) {
        CoinJetTheme.colors.onGreen
    } else {
        CoinJetTheme.colors.error
    }
    val priceColor = remember { Animatable(initialColor) }
    val duration = 2000

    LaunchedEffect(key1 = digit, block = {
        priceColor.animateTo(targetColor, tween(durationMillis = duration))
        priceColor.animateTo(initialColor, tween(durationMillis = duration))
    })

    ret