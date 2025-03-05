package com.example.audibox.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.audibox.screens.AboutScreen
import com.example.audibox.screens.DiscoverScreen
import com.example.audibox.screens.HomeScreen
import com.example.audibox.screens.LibraryScreen
import com.example.audibox.screens.PlayScreen
import com.example.audibox.screens.ProfileScreen
import com.example.audibox.screens.SignInScreen
import com.example.audibox.screens.SignupScreen
import com.example.audibox.screens.SplashScreen
import com.example.audibox.screens.VerificationScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.SignIn) {

        composable<Routes.Verification> {
            VerificationScreen(
                onSignUpClick = { navController.navigate(Routes.SignUp) },
                onVerifyCLick = { // logic to verify user
                    navController.navigate(Routes.Home)
                }) {
                // logic to resend code to user
            }
        }

        composable<Routes.Splash> { SplashScreen() }
        composable<Routes.SignUp> {

            SignupScreen(
                onCreateAccountClick = {
                    navController.navigate(Routes.Verification)
                }, onSignInClick = {
                    navController.navigate(Routes.SignIn)
                }
            )
        }

        composable<Routes.SignIn> {

            SignInScreen(
                onSignUpClick = {
                    navController.navigate(Routes.SignUp)
                }, onSignInClick = {
                    navController.navigate(Routes.SignIn)
                }
            )
        }

        composable<Routes.Home> { HomeScreen(navController) }
        composable<Routes.Discover> { DiscoverScreen(navController) }
        composable<Routes.Library> { LibraryScreen(navController) }
        composable<Routes.Profile> { ProfileScreen(navController) }

        composable<Routes.Books> {
            val args = it.toRoute<Routes.Books>()
            AboutScreen(item = args, navController)
        }
        composable<Routes.Play> {
            val args = it.toRoute<Routes.Play>()
            PlayScreen(args, navController)
        }
    }
}
