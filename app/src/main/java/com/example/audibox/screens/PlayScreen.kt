package com.example.audibox.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.audibox.R
import com.example.audibox.navigation.Routes
import com.example.audibox.ui.theme.backGround
import com.example.audibox.util.BookMarkAlert
import com.example.audibox.util.BottomBar
import com.example.audibox.util.IconsClickable
import com.example.audibox.util.PlayItemNavigation
import com.example.audibox.util.TextCustom

@Composable
fun PlayScreen(item: Routes.Play, navHostController: NavHostController) {
    var sliderValue by remember { mutableFloatStateOf(0f) }

    val state = rememberLazyListState()

    val chapters = listOf(
        Chapter(chapter = "Chapter 1", title = "Vengeance", duration = "12.26"),
        Chapter(chapter = "Chapter 1", title = "Vengeance", duration = "12.26"),
        Chapter(chapter = "Chapter 1", title = "Vengeance", duration = "12.26"),
        Chapter(chapter = "Chapter 1", title = "Vengeance", duration = "12.26"),
        Chapter(chapter = "Chapter 1", title = "Vengeance", duration = "12.26"),
    )
    var isBookMarked by remember { mutableStateOf(false) }
    var speedAlert by remember { mutableStateOf(false) }
    var chaptersState by remember { mutableStateOf(false) }
    var bookMarkedAlert by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier
            .background(backGround)
            .systemBarsPadding()
            .fillMaxSize(),
        topBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(backGround)
                    .padding(horizontal = 20.dp, vertical = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconsClickable(paint = R.drawable.arrow_back_ios_24px, 25) {
                    navHostController.popBackStack()
                }
                Text(text = "Now playing", fontSize = 20.sp, color = Color.White)
                IconsClickable(paint = R.drawable.lists_24px, 25) {
                    chaptersState = !chaptersState
                }

            }
        },
        bottomBar = {
            BottomBar(
                onHomeClick = {
                    navHostController.navigate(Routes.Home)
                },
                onLibraryClick = {
                    navHostController.navigate(Routes.Library)
                },
                onDiscoverClick = {
                    navHostController.navigate(Routes.Discover)
                }) {
                navHostController.navigate(Routes.Profile)
            }

        }) { padding ->
        Column(
            modifier = Modifier
                .background(backGround)
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {

            if (chaptersState) {
                AlertDialog(
                    modifier = Modifier.heightIn(max = 500.dp),
                    containerColor = Color.Black,
                    onDismissRequest = { chaptersState = false },
                    confirmButton = { /*TODO*/ },
                    title = {
                        LazyColumn(
                            state = state,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Black),
                        ) {
                            items(chapters) {
                                ChaptersComposable(chapter = it)
                            }
                        }

                    }
                )
            }


            if (bookMarkedAlert) {
                BookMarkAlert(
                    onDismissRequest = {
                        bookMarkedAlert = false
                    },
                    onView = { /*TODO*/ },
                    onRemoved = {
                        isBookMarked = false
                        bookMarkedAlert = false
                    }
                ) {
                    isBookMarked = true
                    bookMarkedAlert = false
                }
            }
            Column(
                modifier = Modifier
                    .padding(vertical = 70.dp, horizontal = 30.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xEE4A4A68))
            ) {
                Image(
                    painter = painterResource(id = item.backGround),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(15.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .weight(5f),
                    contentDescription = null
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(4f)
                        .padding(vertical = 15.dp, horizontal = 15.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextCustom(text = item.title, fontSize = 22)
                    TextCustom(text = item.title)

                    Slider(
                        value = sliderValue,
                        onValueChange = { newValue ->
                            sliderValue = newValue
                        },
                        onValueChangeFinished = {
                            // perform what happens when a song finishes
                        },
                        valueRange = 0f..100f,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "12.26", color = Color.White, fontSize = 12.sp)
                        Text(text = "86.26", color = Color.White, fontSize = 12.sp)
                    }
                    Spacer(modifier = Modifier.height(15.dp))

                    PlayItemNavigation(
                        isBookMarked = isBookMarked,
                        onDownload = { /*TODO*/ },
                        onPrevious = { /*TODO*/ },
                        onPlay = { /*TODO*/ },
                        onNext = { /*TODO*/ },
                        onBookmark = {
                            bookMarkedAlert = true
                            isBookMarked = true
                        },
                        onForward = { /*TODO*/ }) {

                    }
                }
            }
        }
    }
}

@Composable
fun ChaptersComposable(chapter: Chapter) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "${chapter.chapter}: ${chapter.title}", fontSize = 18.sp, color = Color.White)
        Text(text = chapter.duration, fontSize = 18.sp, color = Color.White)

    }
}

data class Chapter(
    val chapter: String,
    val title: String,
    val duration: String
)