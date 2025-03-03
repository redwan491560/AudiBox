package com.example.audibox.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.audibox.R
import com.example.audibox.navigation.Routes
import com.example.audibox.ui.theme.backGround
import com.example.audibox.util.BottomBar
import com.example.audibox.util.IconsClickable
import com.example.audibox.util.ItemCard
import com.example.audibox.util.TextCustom
import com.example.audibox.util.TextFieldAudiBox


@Composable
fun AboutScreen(item: Routes.Books, navHostController: NavHostController) {

    var search by remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier
            .background(backGround)
            .systemBarsPadding(),
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
                    IconsClickable(paint = R.drawable.baseline_notifications_24, 25) {

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
                    navHostController.navigate(Routes.Library)
                },
                onDiscoverClick = {
                    navHostController.navigate(Routes.Discover)
                }) {
                navHostController.navigate(Routes.Profile)
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .background(backGround)
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Bottom
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .padding(top = 30.dp)
                    .weight(4f),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ItemCard(
                    item = item
                ) {

                }

            }
            Column(
                modifier = Modifier
                    .padding(bottom = 40.dp)
                    .background(Color.Black)
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 10.dp)
                    .weight(6f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                TextCustom(text = "About", fontSize = 20)
                TextCustom(
                    maxLine = 10,
                    text = "About time it it oAbout time it it only wrigAbout time it it only wrigAbout time it About time it it only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrigit only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrigAbout time it it only wrignly wright",
                    fontSize = 14
                )
                Spacer(modifier = Modifier.height(20.dp))

                PurchaseButton(value = "50") {
                    navHostController.navigate(
                        Routes.Play(
                            title = item.title,
                            backGround = item.backGround
                        )
                    )
                }
            }

        }

    }

}

@Composable
fun PurchaseButton(value: String, onClick: () -> Unit) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .clip(RoundedCornerShape(40.dp))
                .background(Color(0xFF7E5BF0))
                .height(60.dp)
                .padding(horizontal = 20.dp)

        ) {
            Column {
                TextCustom(text = "Start reading")
                TextCustom(text = "৳ $value")
            }
            Spacer(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.Black)
                    .width(2.dp)
            )
            Image(
                imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .clickable { onClick() },
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
    }

}