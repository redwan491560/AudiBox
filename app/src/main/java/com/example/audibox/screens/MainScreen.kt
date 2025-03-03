package com.example.audibox.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.audibox.R
import com.example.audibox.navigation.Routes
import com.example.audibox.ui.theme.backGround
import com.example.audibox.util.BottomBar
import com.example.audibox.util.IconsClickable
import com.example.audibox.util.ItemComponent
import com.example.audibox.util.TextCustom
import com.example.audibox.util.TextFieldAudiBox

@Composable
fun HomeScreen(navHostController: NavHostController) {

    var search by remember { mutableStateOf("") }
    val featured = listOf(
        Routes.Books(
            title = "Book of the war",
            backGround = R.drawable.img,
            description = "Book of the warBook of the warBook of the warBook of the war",
            price = 25,
            views = 1223
        ),
        Routes.Books(
            title = "Book of the war",
            backGround = R.drawable.img,
            description = "Book of the warBook of the warBook of the warBook of the war",
            price = 25, views = 1223

        ),

        Routes.Books(
            title = "Book of the war",
            backGround = R.drawable.img,
            description = "Book of the warBook of the warBook of the warBook of the war",
            price = 25, views = 1223

        ),
        Routes.Books(
            title = "Book of the war",
            backGround = R.drawable.img,
            description = "Book of the warBook of the warBook of the warBook of the war",
            price = 25, views = 1223
        )
    )

    Scaffold(modifier = Modifier
        .background(backGround)
        .systemBarsPadding()
        .fillMaxSize(),
        topBar = {
            Column(
                modifier = Modifier
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
                    modifier = Modifier.padding(horizontal = 10.dp),
                    onDone = {

                    },
                    value = search
                ) {
                    search = it
                }
            }
        },
        bottomBar = {
            BottomBar(
                onHomeClick = {
//                    navHostController.navigate(Routes.Home)
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
                .fillMaxSize()
                .background(backGround)
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Column(
                Modifier
                    .padding(start = 10.dp, top = 20.dp, bottom = 10.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(25.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    TextCustom(text = "Top listens", fontSize = 18)
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        items(featured) { item ->
                            ItemComponent(item) {
                                navHostController.navigate(
                                    Routes.Books(
                                        title = item.title,
                                        description = item.description,
                                        price = item.price,
                                        backGround = item.backGround
                                    )
                                )
                            }
                        }
                    }
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    TextCustom(text = "New release", fontSize = 18)
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        items(featured) { item ->
                            ItemComponent(item) {

                            }
                        }
                    }
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    TextCustom(text = "You may also like", fontSize = 18)
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        items(featured) { item ->
                            ItemComponent(item) {

                            }
                        }
                    }

                }
            }

        }

    }


}
