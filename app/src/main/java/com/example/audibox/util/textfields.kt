package com.example.audibox.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.audibox.R

@Composable
fun CustomTextField(
    value: String,
    title: String,
    leading: ImageVector,
    onValueChange: (String) -> Unit,
    onDone: () -> Unit
) {
    Box(
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 25.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                imageVector = leading, contentDescription = null, Modifier.size(20.dp)
            )

        }

        BasicTextField(
            value = value,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onDone = {
                onDone()
            }),
            onValueChange = { onValueChange(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 60.dp, top = 10.dp, bottom = 10.dp),
            singleLine = true,
            textStyle = TextStyle(color = Color.Black) // Ensure text is visible
        )

        if (value.isEmpty()) {
            TextCustom(
                text = title,
                color = Color.Gray,
                modifier = Modifier.padding(start = 60.dp) // Adjust position to avoid overlapping
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = 20.dp)
                .height(2.dp)
                .background(Color.Gray)
        )
    }
}

@Composable
fun CustomPasswordTextField(
    visibility: Boolean,
    value: String,
    title: String,
    leading: ImageVector,
    onTrailingClick: () -> Unit = {},
    onValueChange: (String) -> Unit,
    onDone: () -> Unit
) {


    Box(
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 25.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                imageVector = leading, contentDescription = null, Modifier.size(20.dp)
            )
            Image(
                painter = painterResource(
                    id = if (visibility) R.drawable.baseline_visibility_off_24
                    else R.drawable.baseline_visibility_24
                ),
                contentDescription = null,
                Modifier
                    .size(20.dp)
                    .clickable { onTrailingClick() }
            )
        }

        BasicTextField(
            visualTransformation = if (visibility) VisualTransformation.None
            else PasswordVisualTransformation(),
            value = value,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { onDone() }),
            onValueChange = { onValueChange(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 60.dp, top = 10.dp, bottom = 10.dp),
            singleLine = true,
            textStyle = TextStyle(color = Color.Black)
        )

        if (value.isEmpty()) {
            TextCustom(
                text = title,
                color = Color.Gray,
                modifier = Modifier.padding(start = 60.dp)
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(horizontal = 20.dp)
                .height(2.dp)
                .background(Color.Gray)
        )
    }
}

