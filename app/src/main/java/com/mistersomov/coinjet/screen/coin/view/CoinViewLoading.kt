package com.mistersomov.coinjet.screen.coin.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.mistersomov.coinjet.core_ui.component.ListItem
import com.mistersomov.coinjet.core_ui.effect.Shimmer

@Composable
fun CoinViewLoading() {
    LazyColumn(contentPadding = PaddingValues(horizontal = 6.dp)) {
        items(10) {
            ListItem(
                isLoading = true,
                content = {
                    LoadingFields()
                }) { }
        }
    }
}

@Composable
fun LoadingFields() {
    Box(
        modifier = Modifier
            .size(32.dp)
            .clip(CircleShape)
    ) {
        Shimmer(containerHeight = 32.dp)
    }
    Row(
        modifier = Modifier
            .padding(start = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.padding(top = 14.dp, bottom = 6.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Box(
                modifier = Modifier
                    .width(70.dp)
                    .height(24.dp)
                    .clip(RoundedCornerShape(24.dp))
            ) {
                Shimmer(containerHeight = 32.dp)
            }
            Box(
                modifier = Modifier
                    .padding(top = 2.dp)
                    .width(70.dp)
                    .height(16.dp)
                    .clip(RoundedCornerShape(24.dp))
            ) {
                Shimmer(containerHeight = 32.dp)
            }
        }
        Column(
            modifier = Modifier.padding(top = 14.dp, bottom = 6.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center,
        ) {
            Box(
                modifier = Modifier
                    .width(134.dp)
                    .height(24.dp)
                    .clip(