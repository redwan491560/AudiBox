package com.example.audibox.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.audibox.screens.DiscoverScreen
import com.example.audibox.screens.HomeScreen
import com.example.audibox.screens.LibraryScreen
import com.example.audibox.screens.ProfileScreen


fun NavGraphBuilder.bottomBarNavigation(navController: NavHostController) {

    composable<Routes.Home> { HomeScreen(navController) }
    composable<Routes.Discover> { DiscoverScreen(navController) }
    composable<Routes.Library> { LibraryScreen(navController) }
    composable<Routes.Profile> { ProfileScreen(navController) }


}
