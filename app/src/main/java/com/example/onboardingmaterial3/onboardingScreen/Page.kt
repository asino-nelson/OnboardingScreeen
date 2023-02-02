package com.example.onboardingmaterial3.onboardingScreen

import androidx.annotation.DrawableRes

data class Page(
    val title:String,
    val description:String,
    @DrawableRes val image:Int
)
