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