package com.example.planazum.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun ShadowBox(
    color: Color,
    shadowColor: Color,
    modifier: Modifier = Modifier,
    offset: Dp = 6.dp,
    shape: Shape = RoundedCornerShape(0.dp),
    content: @Composable () -> Unit
) {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .offset(x = -offset, y = offset)
                .background(shadowColor, shape)
        )
        Box(modifier = Modifier.background(color, shape)) {
            content()
        }
    }
}