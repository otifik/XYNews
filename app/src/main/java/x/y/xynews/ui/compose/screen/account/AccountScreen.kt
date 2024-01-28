package x.y.xynews.ui.compose.screen.account

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import x.y.xynews.XYNewsApplication
import x.y.xynews.ui.compose.navigation.Destinations

@Composable
fun AccountScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "个人中心",
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 10.dp, top = 20.dp),
            fontWeight = FontWeight.Bold
        )
        Card(
            modifier = Modifier
                .background(Color.White)
                .padding(10.dp)
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Row(modifier = Modifier
                .fillMaxSize()
                .clickable { }) {
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .clip(RoundedCornerShape(50))
                            .background(Color.Black)
                            .fillMaxSize()
                    ) {

                    }
                }
            }
        }

        Card(
            modifier = Modifier
                .background(Color.White)
                .padding(10.dp)
                .fillMaxWidth()
                .height(80.dp)
        ) {
            Row(Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .clickable {
                            navController.navigate(Destinations.History.route)
                        },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(imageVector = Icons.Outlined.History, contentDescription = "浏览历史")
                    Text(text = "浏览历史", fontSize = 15.sp)
                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .clickable {
                            navController.navigate(Destinations.Star.route)
                        },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(imageVector = Icons.Outlined.StarOutline, contentDescription = "收藏")
                    Text(text = "收藏", fontSize = 15.sp)
                }
            }

        }

        Card(
            modifier = Modifier
                .background(Color.White)
                .padding(10.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clickable { },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "个人信息修改",
                    modifier = Modifier.padding(start = 10.dp),
                    fontSize = 15.sp
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                    contentDescription = "个人信息修改",
                    modifier = Modifier.padding(end = 10.dp)
                )
            }
        }

        Card(
            modifier = Modifier
                .background(Color.White)
                .padding(10.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clickable { },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "修改密码",
                    modifier = Modifier.padding(start = 10.dp),
                    fontSize = 15.sp
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                    contentDescription = "修改密码",
                    modifier = Modifier.padding(end = 10.dp)
                )
            }
        }

        val notificationIsCheck = remember {
            mutableStateOf(true)
        }

        val scheduledIsCheck = remember {
            mutableStateOf(true)
        }

        val hotIsChecked = remember {
            mutableStateOf(true)
        }

        Card(
            modifier = Modifier
                .background(Color.White)
                .padding(10.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clickable { },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "通知开关",
                    modifier = Modifier.padding(start = 10.dp),
                    fontSize = 15.sp
                )
                Switch(checked = notificationIsCheck.value, onCheckedChange = {
                    notificationIsCheck.value = it
                }, modifier = Modifier.padding(end = 10.dp))
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clickable { },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "- 定时推送",
                    modifier = Modifier.padding(start = 10.dp),
                    fontSize = 15.sp
                )
                Switch(checked = scheduledIsCheck.value, onCheckedChange = {
                    scheduledIsCheck.value = it
                }, modifier = Modifier.padding(end = 10.dp))
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clickable { },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "- 热点推送",
                    modifier = Modifier.padding(start = 10.dp),
                    fontSize = 15.sp
                )
                Switch(checked = hotIsChecked.value, onCheckedChange = {
                    hotIsChecked.value = it
                }, modifier = Modifier.padding(end = 10.dp))
            }
        }

        Card(
            modifier = Modifier
                .background(Color.White)
                .padding(10.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clickable {
                        navController.navigate(Destinations.Policy.route)
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "用户协议&隐私政策",
                    modifier = Modifier.padding(start = 10.dp),
                    fontSize = 15.sp
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                    contentDescription = "用户协议&隐私政策",
                    modifier = Modifier.padding(end = 10.dp)
                )
            }
        }

        Card(
            modifier = Modifier
                .background(Color.White)
                .padding(10.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clickable {
                        navController.navigate(Destinations.AboutUs.route)
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "关于我们",
                    modifier = Modifier.padding(start = 10.dp),
                    fontSize = 15.sp
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                    contentDescription = "关于我们",
                    modifier = Modifier.padding(end = 10.dp)
                )
            }
        }
    }
}