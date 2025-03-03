package com.example.audibox.navigation

import kotlinx.serialization.Serializable

@Serializable
class Routes {
    @Serializable
    object Home

    @Serializable
    object Profile

    @Serializable
    object Discover

    @Serializable
    object Library

    @Serializable
    data class Play(
        val title: String = "",
        val backGround: Int = 0,
    )

    @Serializable
    data class Books(
        val title: String = "",
        val backGround: Int = 0,
        val description: String = "",
        val price: Int = 0,
        val views: Int = 0
    )
}


data class Books(
    val title: String = "",
    val backGround: Int = 0,
    val description: String = "",
    val price: Int = 0
)

data class Item(
    val title: String,
    val views: Int,
    val backGround: Int
)