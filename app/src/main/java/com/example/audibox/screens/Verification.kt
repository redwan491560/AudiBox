package com.example.audibox.screens

import android.content.Intent
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
import androidx.compose.material.icons.filled.CheckCircle
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.audibox.R
import com.example.audibox.ui.theme.backGround
import com.example.audibox.util.ClickableTextCustom
import com.example.audibox.util.CustomTextField
import com.example.audibox.util.TextCustom


@Composable
fun VerificationScreen(
    onSignUpClick: () -> Unit,
    onVerifyCLick: () -> Unit,
    onResendClick: () -> Unit
) {

    var code by remember { mutableStateOf("") }
    val context= LocalContext.current


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
                    .padding(vertical = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextCustom(text = "Verification", fontSize = 20, color = Color.Black)
                Spacer(modifier = Modifier.height(15.dp))

                Column(
                    Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextCustom(
                        textAlign = TextAlign.Center,
                        text = "To verify your account enter a 6 digit code sent to your email",
                        color = Color.Black
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        ClickableTextCustom(
                            text = "shanto@gmail.com",
                            fontSize = 16,
                            color = Color.Gray
                        ) {
                            val intent = Intent(Intent.ACTION_MAIN)
                            intent.addCategory(Intent.CATEGORY_APP_EMAIL)
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) // Optional: Opens in a new task
                            context.startActivity(intent)
                        }
                        ClickableTextCustom(
                            text = "Sign up",
                            fontSize = 14,
                            color = Color.Blue
                        ) {
                            onSignUpClick()
                        }
                    }

                }


                Spacer(modifier = Modifier.height(40.dp))
                CustomTextField(value = code,
                    title = "One time password",
                    leading = Icons.Filled.CheckCircle,
                    onValueChange = {
                        code = it
                    }) {

                }


                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF2CB77C)),
                    onClick = {
                        onVerifyCLick()
                    }) {
                    TextCustom(
                        text = "Verify",
                        modifier = Modifier.padding(horizontal = 15.dp)
                    )
                }



                Spacer(modifier = Modifier.height(10.dp))
                TextCustom(
                    text = "By creating an account, you agree to the AudiBox’s",
                    color = Color.Black
                )
                ClickableTextCustom(text = "terms and conditions", color = Color.Blue) {}

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    border = BorderStroke(1.dp, Color.Gray),
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    onClick = {
                        onResendClick()
                    }) {
                    TextCustom(text = "Resend code", color = Color.Black)
                }

            }
        }
    }
}
