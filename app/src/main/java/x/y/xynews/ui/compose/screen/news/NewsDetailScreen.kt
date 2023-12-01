package x.y.xynews.ui.compose.screen.news

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import x.y.xynews.extension.Html
import x.y.xynews.net.bean.NewsDetail
import x.y.xynews.viewmodel.MainActivityViewModel

@Composable
fun NewsDetailScreen(navController: NavHostController, viewModel: MainActivityViewModel) {

    val newsDetail = viewModel.newsDetail.value ?: NewsDetail(
        "none",
        "none",
        "none",
        "none",
        "none",
        "none",
        "none",
        "none"
    )

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(text = newsDetail.title, fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
            )
            Text(text = newsDetail.time, fontSize = 16.sp)
            Text(text = newsDetail.src, fontSize = 16.sp)
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Html(text = newsDetail.content)
        }
    }
}