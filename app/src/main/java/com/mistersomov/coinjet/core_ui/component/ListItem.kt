
package com.mistersomov.coinjet.core_ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mistersomov.coinjet.R
import com.mistersomov.coinjet.core_ui.CoinJetTheme
import com.mistersomov.coinjet.core_ui.MainTheme
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ListItem(
    modifier: Modifier = Modifier,
    isFavorite: MutableState<Boolean> = remember { mutableStateOf(false) },
    isLoading: Boolean = false,
    content: @Composable () -> Unit,
    action: () -> Unit
) {
    val scope = rememberCoroutineScope()

    Surface(
        modifier = modifier
            .clickable(interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = {
                    if (!isLoading) {
                        scope.launch { action.invoke() }
                    }
                }
            ),
        color = CoinJetTheme.colors.surface,
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (isFavorite.value) {
                Icon(
                    modifier = Modifier.size(18.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.favorite),
                    contentDescription = null,
                    tint = CoinJetTheme.colors.yellow
                )
            }
            content.invoke()
        }
    }