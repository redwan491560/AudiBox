package com.example.audibox.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.audibox.R

@Composable
fun BottomBar(
    selected: Int = 0,
    onHomeClick: () -> Unit,
    onLibraryClick: () -> Unit,
    onDiscoverClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 8.dp)
        ) {
            IconsClickable_title(paint = R.drawable.home_app_logo_24px, title = "Home") {
                onHomeClick()
            }
            IconsClickable_title(
                paint = R.drawable.baseline_queue_music_24,
                title = "Library"
            ) {
                onLibraryClick()
            }
            IconsClickable_title(
                paint = R.drawable.outline_smart_display_24,
                title = "Discover"
            ) {
                onDiscoverClick()
            }

            IconsClickable_title(paint = R.drawable.baseline_person_24, title = "Profile") {
                onProfileClick()
            }

        }

    }
}