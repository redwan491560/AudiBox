package com.example.audibox.util

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IconsClickable_title(
    paint: Int,
    title: String,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center, modifier = Modifier.clickable {
            onClick()
        }
    ) {
        Image(
            painter = painterResource(id = paint),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color.White),
            modifier = Modifier
                .size(35.dp)

        )
        Text(text = title, fontSize = 12.sp, color = Color.White)
    }
}

@Composable
fun IconsClickable(
    paint: Int,
    size: Int = 30,
    tint: ColorFilter? = ColorFilter.tint(Color.White),
    onClick: () -> Unit,

    ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = paint),
            contentDescription = null,
            colorFilter = tint,
            modifier = Modifier
                .size(size.dp)
                .clickable {
                    onClick()
                }
        )
    }
}


@Composable
fun TextFieldAudiBox(
    value: String,
    modifier: Modifier = Modifier,
    onDone: () -> Unit,
    onValueChange: (String) -> Unit
) {

    Box(
        modifier = Modifier
            .height(40.dp)
            .border(
                border = BorderStroke(1.dp, Color.LightGray),
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        if (value.isEmpty()) {
            Text(
                text = "Search...",
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)
            )
        }
        BasicTextField(
            value = value, onValueChange = {
                onValueChange(it)
            }, textStyle = TextStyle(
                fontSize = 16.sp,
                color = Color.White
            ), maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ), keyboardActions = KeyboardActions(onDone = {
                onDone()
            }), cursorBrush = SolidColor(Color.White)
        )
    }


}