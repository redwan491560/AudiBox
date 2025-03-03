package com.example.audibox.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.audibox.R
import com.example.audibox.navigation.Routes
import com.example.audibox.ui.theme.backGround
import com.example.audibox.util.BottomBar
import com.example.audibox.util.IconsClickable
import com.example.audibox.util.TextCustom


@Composable
fun ProfileScreen(navHostController: NavHostController) {


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
                    .padding(horizontal = 20.dp, vertical = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconsClickable(paint = R.drawable.arrow_back_ios_24px, 25) {
                    navHostController.popBackStack()
                }
                Image(imageVector = Icons.Outlined.Settings,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.White),
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                        }
                )
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
//                navHostController.navigate(Routes.Profile)
            }

        }) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backGround)
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(top = 40.dp))
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .clip(
                        RoundedCornerShape(100.dp)
                    )
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextCustom(text = "Redwan Hussain", fontSize = 25)
            Spacer(modifier = Modifier.height(5.dp))
            TextCustom(text = "@redwan60")

            Column(
                modifier = Modifier
                    .padding(top = 60.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                ProfileItemDesign(
                    img = R.drawable.baseline_person_24,
                    text = "Personal Information"
                ) {

                }
                ProfileItemDesign(img = R.drawable.settings_24px, text = "Setting") {

                }
                ProfileItemDesign(
                    img = R.drawable.baseline_notifications_24,
                    text = "Notifications"
                ) {

                }
                ProfileItemDesign(img = R.drawable.logout_24px, text = "Logout") {

                }
            }
        }
    }
}


@Composable
fun ProfileItemDesign(img: Int, text: String, onClick: () -> Unit) {


    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clickable { onClick() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Image(
                painter = painterResource(img), contentDescription = null,
                Modifier.size(28.dp), colorFilter = ColorFilter.tint(Color.Gray)
            )
            TextCustom(text = text, fontSize = 18)
        }

        Image(
            imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
            contentDescription = null,
            Modifier.size(30.dp),
            colorFilter = ColorFilter.tint(Color.White)
        )
    }

}