package com.example.audibox.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BookMarkAlert(
    onDismissRequest: () -> Unit,
    onView: () -> Unit,
    onRemoved: () -> Unit,
    onAdded: () -> Unit,
) {

    AlertDialog(
        containerColor = Color.Black,
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = { /*TODO*/ },
        title = {
            Card(
                modifier = Modifier
                    .background(Color.Black)
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
            ) {
                Column(
                    modifier = Modifier
                        .background(Color.Black)
                        .fillMaxWidth()
                        .padding(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    TextCustom(text = "Bookmark", fontSize = 18)
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color.LightGray)
                    )
                    ClickableTextCustom(text = "Save bookmark", fontSize = 18) {
                        onAdded()
                    }
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color.LightGray)
                    )

                    ClickableTextCustom(text = "Remove bookmarks", fontSize = 18) {
                        onRemoved()
                    }
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color.LightGray)
                    )

                    ClickableTextCustom(text = "View bookmarks", fontSize = 18) {
                        onView()
                    }
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color.LightGray)
                    )
                }
            }
        }
    )

}