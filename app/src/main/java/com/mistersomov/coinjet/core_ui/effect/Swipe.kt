package com.mistersomov.coinjet.core_ui.effect

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.mistersomov.coinjet.R
import com.mistersomov.coinjet.core_ui.CoinJetTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Swipe(
    modifier: Modifier = Modifier,
    scope: CoroutineScope = rememberCoroutineScope(),
    content: @Composable () -> Unit
) {
    val dismissState = rememberDismissState(confirmStateChange = { true })
    val maxOffset = 0.5f

    if (dismissState.offset.value >= maxOffset) {
        scope.launch {
            dismissState.reset()
        }
    }

    SwipeToDismiss(state = dismissState, background = {
        val direction = dismissState.dismissDirection ?: return@SwipeToDismiss

        val iconId: Int
        val alignment: Alignment
        val arrangement: Arrangement.Horizontal
        val tint: Color

        when (direction) {
            DismissDirection.StartToEnd -> {
                iconId = R.drawable.favorite
                alignment = Alignment.CenterStart
                arrangement = Arrangement.Start
                tint = CoinJetTheme.colors.yellow
            }
            DismissDirection.EndToStart -> {
                iconId = R.drawable.trash
                alignment = Alignment.CenterEnd
                arrangement = Arrangement.End
                tint = CoinJetTheme.colors.onSurfaceVariant
            }
        }

        Box(
            modifier = modifier
                .background(color = CoinJetTheme.colors.surface)
                .fillMaxSize()
                //.padding(start = (2 * padding.start).dp, end = (2 * padding.end).dp)
            ,
            contentAlignment = alignment
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 6.dp),
                horizontalArrangement = arrangement,
                verticalAlignment = Alignment.Cente