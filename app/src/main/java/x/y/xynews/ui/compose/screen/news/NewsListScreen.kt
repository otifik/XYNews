package x.y.xynews.ui.compose.screen.news

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.AsyncImage
import x.y.xynews.net.CATEGORY
import x.y.xynews.net.bean.NewsDetail
import x.y.xynews.ui.compose.navigation.Destinations
import x.y.xynews.viewmodel.MainActivityViewModel
import java.io.IOException

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsListScreen(navController: NavHostController) {

    val mainViewModel: MainActivityViewModel = viewModel()
//    val data = mainViewModel.getData().collectAsLazyPagingItems()

    var channel by remember {
        mutableStateOf(CATEGORY[0])
    }

    val data = mainViewModel.getNewsData(channel).collectAsLazyPagingItems()

    val refreshState = rememberPullToRefreshState()

    if (refreshState.isRefreshing) {
        data.refresh()
    }

    var selectedTabIndexState by remember {
        mutableIntStateOf(0)
    }

    ScrollableTabRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        selectedTabIndex = selectedTabIndexState
    ) {
        CATEGORY.forEachIndexed { index, title ->
            Tab(
                selected = selectedTabIndexState == index,
                onClick = {
                    selectedTabIndexState = index
                    channel = CATEGORY[index]
                },
                text = {
                    Text(
                        text = title
                    )
                }
            )
        }
    }

    Box(
        modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxSize()
            .background(color = Color.White)
            .nestedScroll(refreshState.nestedScrollConnection)
            .clipToBounds()
    ) {
        LazyColumn(
            modifier = Modifier
                .background(color = Color.White)
        ) {
            items(items = data) { item ->
                Message(navController = navController, data = item, viewModel = mainViewModel)
            }

            val TAG = "加载状态"

            /**
             * 处理刷新
             */
            when (data.loadState.refresh) {
                is LoadState.Loading -> {
                    // 处理刷新加载中的状态
                    Log.d(TAG, "正在加载")
                    item {
                        Column(
                            modifier = Modifier
                                .fillParentMaxSize()
                                .align(Alignment.Center),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "正在加载中...", textAlign = TextAlign.Center)
                            CircularProgressIndicator(modifier = Modifier.width(20.dp))
                        }
                    }
                }

                is LoadState.Error -> {
                    // 处理刷新加载失败的状态
                    refreshState.endRefresh()
                    when ((data.loadState.refresh as LoadState.Error).error) {
                        is IOException -> {
                            item {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(50.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Button(
                                        modifier = Modifier.align(Alignment.Center),
                                        onClick = { data.retry() }
                                    ) {
                                        Text(text = "网络未连接，点击重试")
                                    }
                                }
                            }

                        }

                        else -> {
                            item {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(50.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(text = "出错咯", textAlign = TextAlign.Center)
                                }
                            }
                        }
                    }
                }

                is LoadState.NotLoading -> {
                    // 刷新完成，可以根据需要执行一些操作
                    refreshState.endRefresh()
                }
            }

            /**
             * 处理加载更多
             */
            when (data.loadState.append) {
                is LoadState.Loading -> {
                    // 处理加载更多加载中的状态
                    Log.d(TAG, "正在加载")
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "正在获得更多新闻...", textAlign = TextAlign.Center)
                            CircularProgressIndicator(modifier = Modifier.width(20.dp))
                        }
                    }
                }

                is LoadState.Error -> {
                    // 处理加载更多加载失败的状态
                    when ((data.loadState.append as LoadState.Error).error) {
                        is IOException -> {
                            item {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(50.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Button(
                                        modifier = Modifier.align(Alignment.Center),
                                        onClick = { data.retry() }
                                    ) {
                                        Text(text = "网络未连接，点击重试")
                                    }
                                }
                            }

                        }

                        else -> {
                            item {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(50.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(text = "出错咯", textAlign = TextAlign.Center)
                                }
                            }
                        }
                    }
                }

                is LoadState.NotLoading -> {
                    // 加载更多完成，可以根据需要执行一些操作
                    // 添加判断，当itemCount大于0的时候才能显示到底啦提示
                    if (data.itemCount > 0) {
                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "到底啦", textAlign = TextAlign.Center)
                            }
                        }
                    }
                }
            }
        }

        PullToRefreshContainer(
            modifier = Modifier.align(Alignment.TopCenter),
            state = refreshState,
        )
    }
}

//@Composable
//fun Message(data: DemoReqData.DataBean.DatasBean?) {
//    Card(
//        modifier = Modifier
//            .background(Color.White)
//            .padding(10.dp)
//            .fillMaxSize(),
//        elevation = CardDefaults.cardElevation(
//            defaultElevation = 5.dp
//        )
//    ) {
//        Column(modifier = Modifier.padding(10.dp)) {
//            Text(
//                text = "作者：${data?.author}"
//            )
//            Text(text = "${data?.title}")
//        }
//    }
//
//}

@Composable
fun Message(navController: NavHostController, data: NewsDetail?, viewModel: MainActivityViewModel) {
    Card(
        modifier = Modifier
            .background(Color.White)
            .padding(10.dp)
            .fillMaxSize()
            .clickable {
                viewModel.newsDetail.value = data
                navController.navigate(Destinations.NewsDetail.route) {
                    restoreState = true
                }
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    modifier = Modifier
                        .width(100.dp)
                        .height(80.dp)
                        .padding(end = 10.dp),
                    model = data?.pic,
                    contentDescription = "新闻图片",
                    alignment = Alignment.Center
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "作者：${data?.src}"
                )
                Text(text = "${data?.title}")
            }
        }
    }

}