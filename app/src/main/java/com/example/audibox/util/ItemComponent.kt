package com.example.audibox.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.audibox.R
import com.example.audibox.navigation.Routes


@Composable
fun ItemComponent(item: Routes.Books, onItemClick: (Routes.Books) -> Unit) {

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .clickable { onItemClick(item) }
            .sizeIn(maxWidth = 160.dp, maxHeight = 140.dp)
    ) {
        Box {
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
                                Color(0x12F5DCDC),
                                Color(0xA6272222)
                            )
                        )
                    )
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 5.dp, top = 3.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.headphones_24px),
                    contentDescription = null, modifier = Modifier.size(15.dp)
                )
                Text(
                    text = item.views.toString(), color = Color.White,
                    fontSize = 12.sp,
                )
            }

            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 5.dp)
                    .align(Alignment.BottomStart),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.play_circle_24px),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                )
                Text(
                    text = item.title, color = Color.White,
                    fontSize = 14.sp, maxLines = 1, overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}


@Composable
fun ItemCard(item: Routes.Books, onItemClick: (Routes.Books) -> Unit) {

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .clickable { onItemClick(item) }
            .sizeIn(maxWidth = 160.dp, maxHeight = 180.dp)
    ) {
        Box {
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
                                Color(0x12F5DCDC),
                                Color(0xA6272222)
                            )
                        )
                    )
            )
            TextCustom(text = item.title, fontSize = 16,modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 5.dp))
        }

    }
}