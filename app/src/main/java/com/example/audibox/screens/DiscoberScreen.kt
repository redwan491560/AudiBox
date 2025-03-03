package com.example.audibox.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.audibox.R
import com.example.audibox.navigation.Routes
import com.example.audibox.ui.theme.backGround
import com.example.audibox.util.BottomBar
import com.example.audibox.util.IconsClickable
import com.example.audibox.util.TextCustom
import com.example.audibox.util.TextFieldAudiBox

@Composable
fun DiscoverScreen(navHostController: NavHostController) {
    var search by remember { mutableStateOf("") }

    var selectedCategory by remember {
        mutableIntStateOf(0)
    }
    val categories = listOf(
        "Popular",
        "New release",
        "Podcasts",
        "Originals",
        "Popular",
        "New release",
        "Podcasts",
        "Originals",
        "Popular",
        "New release",
        "Podcasts",
        "Originals"
    )
    val browseItems = listOf(
        Routes.Books(
            title = "Book of the war",
            backGround = R.drawable.img,
            description = "Book of the warBook of the warBook of the warBook of the war",
            price = 25
        ),
        Routes.Books(
            title = "Book of the war",
            backGround = R.drawable.img,
            description = "Book of the warBook of the warBook of the warBook of the war",
            price = 25
        ),
    )

    Scaffold(

        topBar = {
            Column(
                modifier = Modifier
                    .background(backGround)
                    .systemBarsPadding()

                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp, vertical = 10.dp)
                ) {
                    TextCustom(text = "AudiBox", fontSize = 24)
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        IconsClickable(paint = R.drawable.baseline_notifications_24, 25) {

                        }
                        IconsClickable(paint = R.drawable.baseline_view_sidebar_24, 25) {

                        }
                    }
                }
                TextFieldAudiBox(
                    modifier = Modifier.padding(horizontal = 10.dp), onDone = {

                    }, value = search
                ) {
                    search = it
                }
            }
        }, bottomBar = {
            BottomBar(
                onHomeClick = {
                    navHostController.navigate(Routes.Home)
                },
                onLibraryClick = {
                    navHostController.navigate(Routes.Library)
                },
                onDiscoverClick = {
//                    navHostController.navigate(Routes.Discover)
                }) {
                navHostController.navigate(Routes.Profile)
            }
        }) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .background(backGround)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 15.dp)
            ) {
                TextCustom(text = "Discover something new", fontSize = 18)

                LazyVerticalGrid(
                    modifier = Modifier.padding(top = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    columns = GridCells.Fixed(3)
                ) {
                    items(categories.size) { ind ->
                        DiscoverGridItems(
                            text = categories[ind],
                            isSelected = (selectedCategory == ind)
                        ) {
                            selectedCategory = ind
                        }
                    }

                }
            }

            Column(
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 15.dp)
            ) {
                TextCustom(text = "Browse", fontSize = 18)

                LazyVerticalGrid(
                    modifier = Modifier.padding(top = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    columns = GridCells.Fixed(3)
                ) {
                    items(browseItems) {
                        BrowseGridItem(item = it) {

                        }
                    }
                }
            }
        }
    }
}


@Composable
fun DiscoverGridItems(text: String, isSelected: Boolean = false, onClick: () -> Unit) {
    OutlinedButton(
        colors = if (!isSelected) ButtonDefaults.buttonColors(Color.Transparent)
        else ButtonDefaults.buttonColors(Color.Blue),
        onClick = { onClick() }) {
        Column(
            modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = text, maxLines = 1, color = Color.White, overflow = TextOverflow.Ellipsis)

        }
    }
}

@Composable
fun BrowseGridItem(item: Routes.Books, onClick: () -> Unit) {

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .sizeIn(maxHeight = 60.dp), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(item.backGround),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0x9A161313),
                            Color(0x9A161313)
                        )
                    )
                )
        )
        Text(
            text = item.title, color = Color.White,
            fontSize = 16.sp, maxLines = 1
        )
    }
}