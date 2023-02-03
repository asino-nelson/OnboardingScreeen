@file:OptIn(ExperimentalFoundationApi::class)
@file:Suppress("UNUSED_EXPRESSION")

package com.example.onboardingmaterial3.onboardingScreen



import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.onboardingmaterial3.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPagerIndicator


@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun OnboardingUi(
    onGettingStartedClick:()-> Unit,
    onSkipClicked:()-> Unit
){

    val pagerState = com.google.accompanist.pager.rememberPagerState(pageCount = 3)

    Column {

        Text(
            text = "Skip",
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .clickable { onSkipClicked })

        HorizontalPager(
            pageCount = 3,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            state = pagerState
        ) {page ->
            PageUI(page = onboardingScreens[page])
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            activeColor = colorResource(id = R.color.purple_500)
        )

        AnimatedVisibility(visible = pagerState.currentPage == 2) {
            OutlinedButton(
                onClick = onGettingStartedClick ,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Get Started")
            }
        }
    }
}
