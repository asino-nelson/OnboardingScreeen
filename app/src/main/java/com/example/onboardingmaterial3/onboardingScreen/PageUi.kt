package com.example.onboardingmaterial3.onboardingScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onboardingmaterial3.Greeting
import com.example.onboardingmaterial3.R
import com.example.onboardingmaterial3.ui.theme.OnboardingMaterial3Theme

@Composable
fun PageUI(
    page: Page
){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(200.dp))
        Image(painter = painterResource(id = page.image ), contentDescription = null )
        Spacer(modifier = Modifier.height(200.dp))
        Text(text = page.title)
        Spacer(modifier = Modifier.height(100.dp))
        Text(text = page.description)
    }
}

@Preview(showBackground = true)
@Composable
fun PageUiPreview() {
    OnboardingMaterial3Theme {
        PageUI(page = Page(
            title = "Page 1",
            description = "This is the description of page 1 of the onboarding screen",
            image = R.drawable.fastfood
        ) )
    }
}