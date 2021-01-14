package com.mistersomov.coinjet.core_ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun MainTheme(
    isDarkTheme: Boolean = false, content: @Composable () -> Unit
) {
    val colors = when (isDarkTheme) {
        true -> baseDarkPalette
        else -> baseLightPalette
    }
    val typography = CoinJetTypography(
        labelLarge = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.sp,
            lineHeight = 20.sp,
            fontSize = 14.sp
        ),
        labelMedium = TextStyle(
            fontFamily =