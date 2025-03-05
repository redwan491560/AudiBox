package com.example.audibox.util

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp


@Composable
fun TextCustom(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign =TextAlign.Start,
    color: Color = Color.White,
    fontSize: Int = 14,
    maxLine: Int = 1
) {
    Text(
        text = text,
        textAlign = textAlign,
        maxLines = maxLine,
        modifier = modifier,
        fontSize = fontSize.sp,
        color = color
    )
}

@Composable
fun ClickableTextCustom(
    text: String,
    fontSize: Int = 14,
    color: Color = Color.White,
    onCLick: () -> Unit
) {
    Text(
        text = text,
        fontSize = fontSize.sp,
        color = color,
        textDecoration = TextDecoration.Underline,
        modifier = Modifier.clickable { onCLick() })
}