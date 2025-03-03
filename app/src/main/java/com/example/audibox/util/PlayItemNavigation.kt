package com.example.audibox.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.audibox.R

@Composable
fun PlayItemNavigation(
    isBookMarked: Boolean = false,
    onDownload: () -> Unit,
    onPrevious: () -> Unit,
    onPlay: () -> Unit,
    onNext: () -> Unit,
    onBookmark: () -> Unit,
    onForward: () -> Unit,
    onBackward: () -> Unit,
) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconsClickable(paint = R.drawable.download_24px, size = 20) {
            onDownload()
        }
        IconsClickable(paint = R.drawable.skip_previous_24px, size = 20) {
            onPrevious()
        }

        Text(
            text = "-15s",
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.clickable {
                onBackward()
            }
        )



        IconsClickable(
            paint = R.drawable.play, size = 50,
            tint = null
        ) {
            onPlay()
        }

        IconsClickable(paint = R.drawable.skip_next_24px, size = 20) {
            onDownload()
        }

        Text(
            text = "+15s",
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.clickable {
                onForward()
            }
        )

        IconsClickable(
            paint = if (isBookMarked) R.drawable.baseline_bookmark_24 else R.drawable.bookmark_24px,
            size = 20
        ) {
            onBookmark()
        }


    }
}