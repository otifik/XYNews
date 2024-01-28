package x.y.xynews.ui.compose.screen.account.aboutus

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import x.y.xynews.R

@Composable
fun AboutUsScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Card {
            var expended by remember {
                mutableStateOf(false)
            }

            Column(
                modifier = Modifier
                    .background(Color.White)
                    .clickable { expended = !expended },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painterResource(id = R.drawable.icon), "icon")
                AnimatedVisibility(visible = expended, Modifier.background(Color.White)) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "XYNews by XY", fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)
                        Text(text = "Version 1.0", fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)
                    }
                }
            }
        }
    }
}