package com.example.audibox.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
fun LibraryScreen(navHostController: NavHostController) {

    var search by remember { mutableStateOf("") }

    val featured = listOf(
        Routes.Books(
            title = "Book of the war",
            backGround = R.drawable.img,
            description = "Book of the warBook of the warBook of the warBook of the war",
            price = 25
        ),Routes.Books(
            title = "Book of the war",
            backGround = R.drawable.img,
            description = "Book of the warBook of the warBook of the warBook of the war",
            price = 25
        ),
    )
    val reading = listOf(
        Routes.Books(
            title = "Book of the war",
            backGround = R.drawable.img,
            description = "Book of the warBook of the warBook of the warBook of the war",
            price = 25
        ),Routes.Books(
            title = "Book of the war",
            backGround = R.drawable.img,
            description = "Book of the warBook of the warBook of the warBook of the war",
            price = 25
        ),
    )
    val archive = listOf(
        Routes.Books(
            title = "Book of the war",
            backGround = R.drawable.img,
            description = "Book of the warBook of the warBook of the warBook of the war",
            price = 25
        ),Routes.Books(
            title = "Book of the war",
            backGround = R.drawable.img,
            description = "Book of the warBook of the warBook of the warBook of the war",
            price = 25
        ),
    )

    val chips = listOf("Current items", "Reading lists", "Archives")
    var chipState by remember {
        mutableIntStateOf(0)
    }

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
                    navHostController.navigate(Routes.Home)
                },
                onLibraryClick = {
//                    navHostController.navigate(Routes.Library)
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
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {

            Row(
                modifier = Modifier
                    .padding(top = 15.dp, start = 10.dp)
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()), // Enable scrolling
                horizontalArrangement = Arrangement.spacedBy(15.dp) // Space between chips
            ) {
                chips.forEachIndexed { ind, str ->
                    ChipsDesign(
                        text = str,
                        state = (chipState == ind),
                        onClick = { chipState = ind }
                    )
                }
            }

            when (chipState) {
                0 -> {
                    LazyRow(
                        modifier = Modifier.padding(start = 15.dp),
                        horizontalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        items(featured) {
                            LibraryComponent(item = it) {

                            }
                        }
                    }
                }

                1 -> {
                    LazyRow(
                        modifier = Modifier.padding(start = 15.dp),
                        horizontalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        items(reading) {
                            LibraryComponent(item = it) {

                            }
                        }
                    }
                }

                2 -> {
                    LazyRow(
                        modifier = Modifier.padding(start = 15.dp),
                        horizontalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        items(archive) {
                            LibraryComponent(item = it) {

                            }
                        }
                    }
                }
            }


        }
    }
}


@Composable
fun LibraryComponent(item: Routes.Books, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.widthIn(max = 150.dp)
    ) {
        Image(
            painter = painterResource(id = item.backGround),
            contentDescription = null,
            modifier = Modifier
                .sizeIn(maxWidth = 150.dp)
                .padding(bottom = 5.dp)
                .clip(RoundedCornerShape(6.dp))
                .clickable { onClick() }
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 3.dp, bottom = 10.dp)
                .background(Color.LightGray)
                .height(2.dp)
        )
        Text(
            text = item.title,
            maxLines = 1,
            color = Color.White,
            fontWeight = FontWeight.ExtraBold,
            overflow = TextOverflow.Ellipsis
        )
    }

}


@Composable
fun ChipsDesign(text: String, state: Boolean, onClick: () -> Unit) {

    Column(
        modifier = Modifier
            .clickable { onClick() }
            .padding(vertical = 3.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicText(
            text = text,
            color = { Color.White },
            style = TextStyle(fontSize = 16.sp),
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .drawBehind {
                    if (state) {
                        drawLine(
                            color = Color.White,
                            strokeWidth = 5f,
                            start = Offset(0f, size.height),
                            end = Offset(size.width, size.height)
                        )
                    }
                }
        )
    }
}

