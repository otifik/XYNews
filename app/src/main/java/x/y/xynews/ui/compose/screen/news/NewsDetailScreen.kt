package x.y.xynews.ui.compose.screen.news

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import x.y.xynews.extension.Html
import x.y.xynews.extension.WebViewPage
import x.y.xynews.net.bean.Article
import x.y.xynews.net.bean.NewsDetail
import x.y.xynews.net.bean.Source
import x.y.xynews.viewmodel.MainActivityViewModel

@Composable
fun NewsDetailScreen(navController: NavHostController, viewModel: MainActivityViewModel) {

    val article = viewModel.article.value ?: Article(
        "none",
        "none",
        "none",
        "none",
        Source("none", "none"),
        "none",
        "none",
        "none"
    )

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .wrapContentHeight()
//        ) {
////            Text(text = newsDetail.title, fontSize = 25.sp, fontWeight = FontWeight.Bold)
//            Spacer(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(10.dp)
//            )
//            Text(text = article.publishedAt, fontSize = 16.sp)
//            Text(text = article.url, fontSize = 16.sp)
//
//
//        }
//        Spacer(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(20.dp)
//        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
//            Html(text = newsDetail.content)
            WebViewPage(url = article.url)
        }

        Row(horizontalArrangement = Arrangement.SpaceAround) {
            Icon(Icons.Outlined.Favorite, "点赞", modifier = Modifier.clickable { })
            Icon(Icons.Outlined.StarOutline, "收藏", modifier = Modifier.clickable { })
            Icon(Icons.Outlined.Share, "分享", modifier = Modifier.clickable { })
        }
    }
}