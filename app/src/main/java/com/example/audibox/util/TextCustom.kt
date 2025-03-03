package com.example.audibox.util

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


@Composable
fun TextCustom(text: String, modifier: Modifier = Modifier, fontSize: Int = 14, maxLine: Int = 1) {
    Text(
        text = text,
        maxLines = maxLine,
        modifier = modifier,
        fontSize = fontSize.sp,
        color = Color.White
    )
}

@Composable
fun ClickableTextCustom(text: String, fontSize: Int = 14, onCLick: () -> Unit) {
    Text(
        text = text,
        fontSize = fontSize.sp,
        color = Color.White,
        modifier = Modifier.clickable { onCLick() })
}