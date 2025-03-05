package com.example.audibox.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.audibox.R
import com.example.audibox.ui.theme.backGround
import com.example.audibox.util.ClickableTextCustom
import com.example.audibox.util.CustomPasswordTextField
import com.example.audibox.util.CustomTextField
import com.example.audibox.util.TextCustom

@Composable
fun SignupScreen(
    onCreateAccountClick: () -> Unit, onSignInClick: () -> Unit
) {

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var visibility by remember { mutableStateOf(false) }
    var password by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .systemBarsPadding()
            .fillMaxSize()
            .background(backGround),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo2),
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 10.dp)
                .size(50.dp)
        )
        TextCustom(text = "AudiBox", fontSize = 18)
        Spacer(modifier = Modifier.height(40.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            shape = RoundedCornerShape(10.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp, horizontal = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextCustom(text = "Get started", fontSize = 20, color = Color.Black)
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.padding(top = 15.dp)
                ) {
                    TextCustom(text = "Already have an account?", color = Color.Black)
                    ClickableTextCustom(text = "Sign in", color = Color.Blue) {
                        onSignInClick()
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))
                CustomTextField(value = username,
                    title = "Username",
                    leading = Icons.Outlined.Person,
                    onValueChange = {
                        username = it
                    }) {

                }
                Spacer(modifier = Modifier.height(20.dp))
                CustomTextField(value = email,
                    title = "Email",
                    leading = Icons.Outlined.Email,
                    onValueChange = {
                        email = it
                    }) {

                }
                Spacer(modifier = Modifier.height(20.dp))

                CustomPasswordTextField(visibility = visibility,
                    value = password,
                    title = "Password",
                    leading = Icons.Outlined.Lock,
                    onValueChange = {
                        password = it
                    },
                    onTrailingClick = {
                        visibility = !visibility
                    }) {

                }

                Spacer(modifier = Modifier.height(20.dp))
                TextCustom(
                    text = "By creating an account, you agree to the AudiBox’s",
                    color = Color.Black
                )
                ClickableTextCustom(text = "terms and conditions", color = Color.Blue) {}

                Spacer(modifier = Modifier.height(40.dp))
                Button(
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF2CB77C)),
                    onClick = {
                        onCreateAccountClick()
                    }) {
                    TextCustom(text = "Create account", modifier = Modifier.padding(horizontal = 15.dp))
                }

            }
        }
    }
}
