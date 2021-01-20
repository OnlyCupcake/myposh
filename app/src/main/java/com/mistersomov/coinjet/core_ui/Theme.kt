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
            fontFamily = Inter,
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.10000000149011612.sp,
            lineHeight = 16.sp,
            fontSize = 12.sp
        ),
        labelSmall = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.10000000149011612.sp,
            lineHeight = 16.sp,
            fontSize = 11.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.sp,
            lineHeight = 24.sp,
            fontSize = 16.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.sp,
            lineHeight = 20.sp,
            fontSize = 14.sp
        ),
        bodySmall = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.10000000149011612.sp,
            lineHeight = 16.sp,
            fontSize = 12.sp
        ),
        headlineLarge = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.sp,
            lineHeight = 40.sp,
            fontSize = 32.sp
        ),
        headlineMedium = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.sp,
            lineHeight = 36.sp,
            fontSize = 28.sp
        ),
        headlineSmall = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.sp,
            lineHeight = 32.sp,
            fontSize = 24.sp
        ),
        displayLarge = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.sp,
            lineHeight = 64.sp,
            fontSize = 57.sp
        ),
        displayMedium = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.sp,
            lineHeight = 52.sp,
            fontSize = 45.sp
        ),
        displaySmall = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.sp,
            lineHeight = 44.sp,
            fontSize = 36.sp
        ),
        titleLarge = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.sp,
            lineHeight = 28.sp,
            fontSize = 22.sp
        ),
        titleMedium = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.SemiBold,
          