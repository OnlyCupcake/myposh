package com.mistersomov.coinjet.core_ui.effect

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import com.mistersomov.coinjet.core_ui.CoinJetTheme

@Composable
fun Shimmer(
    containerHeight: Dp,
) {

    BoxWithConstraints {
        val widthWithPx = with(LocalDensity.current) { maxWidth.toPx() }
        val heightWithPx = with(LocalDensity.current) { containerHeight.toPx() }

        val gradientWidth: Float = 0.2f * heightWithPx

        val infiniteTransition = rememberInfiniteTransition()
        val xShimmer by infiniteTransition.animateFloat(
            initialValue = 0f - gradientWidth,
            targetValue = widthWithPx + gradientWidth,
            animationSpec = infiniteRepeatable(
                tween(durationMillis = 2000, delayMillis = 500, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            )
        )
        val yShimmer by infiniteTransition.animateFloat(
            initialValue = 0f - gradientWidth,
            targetValue = heightWithPx + gradientWidth,
            animationSpec = infiniteRepeatable(
                tween(durationMillis = 2000, delayMillis = 500, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            )
        )
        val colorList: List<Color> = with(CoinJetTheme.colors) {
            listOf(surfaceVariant, surface, surfaceVariant)
        }

        val brush = Brush.linearGradient(
            colors = colorList,
            start = Offset(x = xShimmer, y = yShimmer),
            end = Offset(
                x = xShimmer + gradientWidth,
                y = yShimmer + gradientWidth
            )
        )

        Surface {
            Spacer(
                modifier = Modifier
                    .requiredWidth(width = maxWidth)
                    .req