package x.y.xynews.ui.compose.screen.account.star

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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import x.y.xynews.net.bean.NewsDetail

@Composable

fun StarScreen(navController: NavHostController) {

    val data = remember {
        mutableStateOf(
            listOf(
                NewsDetail(
                    "sports",
                    "<p class=\"art_p\">北京时间12月2日，2023-2024赛季中国女子排球超级联赛第一阶段小组赛第9轮争夺全面展开。在A组的3场较量中，李盈莹休战的天津渤海银行客场3-0轻取河南双汇，豪取9连胜领跑本组；郑益昕和庄宇珊领衔的福建安溪铁观音主场3-1力挫劲敌北京汽车，斩获赛季第3场胜利后即时排名升至小组第4；四川五粮春凭借接应缪伊雯和德国外援贾茨科的稳定发挥3-0送河北队8连败。</p>\n<p class=\"art_p\"><strong>2023-2024赛季中国女子排球超级联赛第一阶段小组赛第9轮A组完全赛果如下：</strong></p>\n<p class=\"art_p\">福建安溪铁观音3-1胜北京汽车（25-19、25-17、21-25、25-15）</p>\n<p class=\"art_p\">河南双汇0-3负天津渤海银行（20-25、13-25、16-25）</p>\n<p class=\"art_p\">河北0-3负四川五粮春（19-25、11-25、17-25）</p>\n<p class=\"art_p\"><strong>2023-2024赛季中国女子排球超级联赛第一阶段小组赛A组即时排名如下：</strong></p>\n<p class=\"art_p\">1。 天津渤海银行 9胜0负 27分</p>\n<div sax-type=\"proxy\" class=\"j_native_stu231202 box\" style=\"margin:20px 0\"></div><p class=\"art_p\">2。 北京汽车 5胜3负 15分</p>\n<p class=\"art_p\">3。 河南双汇 4胜4负 12分</p>\n<p class=\"art_p\">4。 福建安溪铁观音 3胜4负 10分</p>\n<p class=\"art_p\">5。 四川五粮春 3胜4负 9分</p>\n<p class=\"art_p\">6。 山东日照钢铁 3胜4负 8分</p>\n<p class=\"art_p\">7。 河北 0胜8负 0分</p>\n<p class=\"art_p\">（高加索）</p>",
                    "https://n.sinaimg.cn/sports/transform/258/w650h408/20231202/a933-e21c6c3d6a3983007e189eaa63f2259e.png",
                    "新浪体育讯",
                    "2023-12-02",
                    "排超-李盈莹休战天津女排9连胜 四川送河北8连败",
                    "https://sports.sina.cn/others/volleyball/2023-12-02/detail-imzwrqmq7510992.d.html?vt=4&pos=108",
                    "https://sports.sina.com.cn/others/volleyball/2023-12-02/doc-imzwrqmq7510992.shtml"
                ),
                NewsDetail(
                    "sports",
                    "<p class=\"art_p\">北京时间12月2日，2023-2024赛季中国女子排球超级联赛第一阶段小组赛第9轮争夺全面展开。在A组的3场较量中，李盈莹休战的天津渤海银行客场3-0轻取河南双汇，豪取9连胜领跑本组；郑益昕和庄宇珊领衔的福建安溪铁观音主场3-1力挫劲敌北京汽车，斩获赛季第3场胜利后即时排名升至小组第4；四川五粮春凭借接应缪伊雯和德国外援贾茨科的稳定发挥3-0送河北队8连败。</p>\n<p class=\"art_p\"><strong>2023-2024赛季中国女子排球超级联赛第一阶段小组赛第9轮A组完全赛果如下：</strong></p>\n<p class=\"art_p\">福建安溪铁观音3-1胜北京汽车（25-19、25-17、21-25、25-15）</p>\n<p class=\"art_p\">河南双汇0-3负天津渤海银行（20-25、13-25、16-25）</p>\n<p class=\"art_p\">河北0-3负四川五粮春（19-25、11-25、17-25）</p>\n<p class=\"art_p\"><strong>2023-2024赛季中国女子排球超级联赛第一阶段小组赛A组即时排名如下：</strong></p>\n<p class=\"art_p\">1。 天津渤海银行 9胜0负 27分</p>\n<div sax-type=\"proxy\" class=\"j_native_stu231202 box\" style=\"margin:20px 0\"></div><p class=\"art_p\">2。 北京汽车 5胜3负 15分</p>\n<p class=\"art_p\">3。 河南双汇 4胜4负 12分</p>\n<p class=\"art_p\">4。 福建安溪铁观音 3胜4负 10分</p>\n<p class=\"art_p\">5。 四川五粮春 3胜4负 9分</p>\n<p class=\"art_p\">6。 山东日照钢铁 3胜4负 8分</p>\n<p class=\"art_p\">7。 河北 0胜8负 0分</p>\n<p class=\"art_p\">（高加索）</p>",
                    "https://n.sinaimg.cn/sports/transform/258/w650h408/20231202/a933-e21c6c3d6a3983007e189eaa63f2259e.png",
                    "新浪体育讯",
                    "2023-12-02",
                    "排超-李盈莹休战天津女排9连胜 四川送河北8连败",
                    "https://sports.sina.cn/others/volleyball/2023-12-02/detail-imzwrqmq7510992.d.html?vt=4&pos=108",
                    "https://sports.sina.com.cn/others/volleyball/2023-12-02/doc-imzwrqmq7510992.shtml"
                ),
                NewsDetail(
                    "sports",
                    "<p class=\"art_p\">北京时间12月2日，2023-2024赛季中国女子排球超级联赛第一阶段小组赛第9轮争夺全面展开。在A组的3场较量中，李盈莹休战的天津渤海银行客场3-0轻取河南双汇，豪取9连胜领跑本组；郑益昕和庄宇珊领衔的福建安溪铁观音主场3-1力挫劲敌北京汽车，斩获赛季第3场胜利后即时排名升至小组第4；四川五粮春凭借接应缪伊雯和德国外援贾茨科的稳定发挥3-0送河北队8连败。</p>\n<p class=\"art_p\"><strong>2023-2024赛季中国女子排球超级联赛第一阶段小组赛第9轮A组完全赛果如下：</strong></p>\n<p class=\"art_p\">福建安溪铁观音3-1胜北京汽车（25-19、25-17、21-25、25-15）</p>\n<p class=\"art_p\">河南双汇0-3负天津渤海银行（20-25、13-25、16-25）</p>\n<p class=\"art_p\">河北0-3负四川五粮春（19-25、11-25、17-25）</p>\n<p class=\"art_p\"><strong>2023-2024赛季中国女子排球超级联赛第一阶段小组赛A组即时排名如下：</strong></p>\n<p class=\"art_p\">1。 天津渤海银行 9胜0负 27分</p>\n<div sax-type=\"proxy\" class=\"j_native_stu231202 box\" style=\"margin:20px 0\"></div><p class=\"art_p\">2。 北京汽车 5胜3负 15分</p>\n<p class=\"art_p\">3。 河南双汇 4胜4负 12分</p>\n<p class=\"art_p\">4。 福建安溪铁观音 3胜4负 10分</p>\n<p class=\"art_p\">5。 四川五粮春 3胜4负 9分</p>\n<p class=\"art_p\">6。 山东日照钢铁 3胜4负 8分</p>\n<p class=\"art_p\">7。 河北 0胜8负 0分</p>\n<p class=\"art_p\">（高加索）</p>",
                    "https://n.sinaimg.cn/sports/transform/258/w650h408/20231202/a933-e21c6c3d6a3983007e189eaa63f2259e.png",
                    "新浪体育讯",
                    "2023-12-02",
                    "排超-李盈莹休战天津女排9连胜 四川送河北8连败",
                    "https://sports.sina.cn/others/volleyball/2023-12-02/detail-imzwrqmq7510992.d.html?vt=4&pos=108",
                    "https://sports.sina.com.cn/others/volleyball/2023-12-02/doc-imzwrqmq7510992.shtml"
                ),
                NewsDetail(
                    "sports",
                    "<p class=\"art_p\">北京时间12月2日，2023-2024赛季中国女子排球超级联赛第一阶段小组赛第9轮争夺全面展开。在A组的3场较量中，李盈莹休战的天津渤海银行客场3-0轻取河南双汇，豪取9连胜领跑本组；郑益昕和庄宇珊领衔的福建安溪铁观音主场3-1力挫劲敌北京汽车，斩获赛季第3场胜利后即时排名升至小组第4；四川五粮春凭借接应缪伊雯和德国外援贾茨科的稳定发挥3-0送河北队8连败。</p>\n<p class=\"art_p\"><strong>2023-2024赛季中国女子排球超级联赛第一阶段小组赛第9轮A组完全赛果如下：</strong></p>\n<p class=\"art_p\">福建安溪铁观音3-1胜北京汽车（25-19、25-17、21-25、25-15）</p>\n<p class=\"art_p\">河南双汇0-3负天津渤海银行（20-25、13-25、16-25）</p>\n<p class=\"art_p\">河北0-3负四川五粮春（19-25、11-25、17-25）</p>\n<p class=\"art_p\"><strong>2023-2024赛季中国女子排球超级联赛第一阶段小组赛A组即时排名如下：</strong></p>\n<p class=\"art_p\">1。 天津渤海银行 9胜0负 27分</p>\n<div sax-type=\"proxy\" class=\"j_native_stu231202 box\" style=\"margin:20px 0\"></div><p class=\"art_p\">2。 北京汽车 5胜3负 15分</p>\n<p class=\"art_p\">3。 河南双汇 4胜4负 12分</p>\n<p class=\"art_p\">4。 福建安溪铁观音 3胜4负 10分</p>\n<p class=\"art_p\">5。 四川五粮春 3胜4负 9分</p>\n<p class=\"art_p\">6。 山东日照钢铁 3胜4负 8分</p>\n<p class=\"art_p\">7。 河北 0胜8负 0分</p>\n<p class=\"art_p\">（高加索）</p>",
                    "https://n.sinaimg.cn/sports/transform/258/w650h408/20231202/a933-e21c6c3d6a3983007e189eaa63f2259e.png",
                    "新浪体育讯",
                    "2023-12-02",
                    "排超-李盈莹休战天津女排9连胜 四川送河北8连败",
                    "https://sports.sina.cn/others/volleyball/2023-12-02/detail-imzwrqmq7510992.d.html?vt=4&pos=108",
                    "https://sports.sina.com.cn/others/volleyball/2023-12-02/doc-imzwrqmq7510992.shtml"
                ),
                NewsDetail(
                    "sports",
                    "<p class=\"art_p\">北京时间12月2日，2023-2024赛季中国女子排球超级联赛第一阶段小组赛第9轮争夺全面展开。在A组的3场较量中，李盈莹休战的天津渤海银行客场3-0轻取河南双汇，豪取9连胜领跑本组；郑益昕和庄宇珊领衔的福建安溪铁观音主场3-1力挫劲敌北京汽车，斩获赛季第3场胜利后即时排名升至小组第4；四川五粮春凭借接应缪伊雯和德国外援贾茨科的稳定发挥3-0送河北队8连败。</p>\n<p class=\"art_p\"><strong>2023-2024赛季中国女子排球超级联赛第一阶段小组赛第9轮A组完全赛果如下：</strong></p>\n<p class=\"art_p\">福建安溪铁观音3-1胜北京汽车（25-19、25-17、21-25、25-15）</p>\n<p class=\"art_p\">河南双汇0-3负天津渤海银行（20-25、13-25、16-25）</p>\n<p class=\"art_p\">河北0-3负四川五粮春（19-25、11-25、17-25）</p>\n<p class=\"art_p\"><strong>2023-2024赛季中国女子排球超级联赛第一阶段小组赛A组即时排名如下：</strong></p>\n<p class=\"art_p\">1。 天津渤海银行 9胜0负 27分</p>\n<div sax-type=\"proxy\" class=\"j_native_stu231202 box\" style=\"margin:20px 0\"></div><p class=\"art_p\">2。 北京汽车 5胜3负 15分</p>\n<p class=\"art_p\">3。 河南双汇 4胜4负 12分</p>\n<p class=\"art_p\">4。 福建安溪铁观音 3胜4负 10分</p>\n<p class=\"art_p\">5。 四川五粮春 3胜4负 9分</p>\n<p class=\"art_p\">6。 山东日照钢铁 3胜4负 8分</p>\n<p class=\"art_p\">7。 河北 0胜8负 0分</p>\n<p class=\"art_p\">（高加索）</p>",
                    "https://n.sinaimg.cn/sports/transform/258/w650h408/20231202/a933-e21c6c3d6a3983007e189eaa63f2259e.png",
                    "新浪体育讯",
                    "2023-12-02",
                    "排超-李盈莹休战天津女排9连胜 四川送河北8连败",
                    "https://sports.sina.cn/others/volleyball/2023-12-02/detail-imzwrqmq7510992.d.html?vt=4&pos=108",
                    "https://sports.sina.com.cn/others/volleyball/2023-12-02/doc-imzwrqmq7510992.shtml"
                ),
                NewsDetail(
                    "sports",
                    "<p class=\"art_p\">北京时间12月2日，2023-2024赛季中国女子排球超级联赛第一阶段小组赛第9轮争夺全面展开。在A组的3场较量中，李盈莹休战的天津渤海银行客场3-0轻取河南双汇，豪取9连胜领跑本组；郑益昕和庄宇珊领衔的福建安溪铁观音主场3-1力挫劲敌北京汽车，斩获赛季第3场胜利后即时排名升至小组第4；四川五粮春凭借接应缪伊雯和德国外援贾茨科的稳定发挥3-0送河北队8连败。</p>\n<p class=\"art_p\"><strong>2023-2024赛季中国女子排球超级联赛第一阶段小组赛第9轮A组完全赛果如下：</strong></p>\n<p class=\"art_p\">福建安溪铁观音3-1胜北京汽车（25-19、25-17、21-25、25-15）</p>\n<p class=\"art_p\">河南双汇0-3负天津渤海银行（20-25、13-25、16-25）</p>\n<p class=\"art_p\">河北0-3负四川五粮春（19-25、11-25、17-25）</p>\n<p class=\"art_p\"><strong>2023-2024赛季中国女子排球超级联赛第一阶段小组赛A组即时排名如下：</strong></p>\n<p class=\"art_p\">1。 天津渤海银行 9胜0负 27分</p>\n<div sax-type=\"proxy\" class=\"j_native_stu231202 box\" style=\"margin:20px 0\"></div><p class=\"art_p\">2。 北京汽车 5胜3负 15分</p>\n<p class=\"art_p\">3。 河南双汇 4胜4负 12分</p>\n<p class=\"art_p\">4。 福建安溪铁观音 3胜4负 10分</p>\n<p class=\"art_p\">5。 四川五粮春 3胜4负 9分</p>\n<p class=\"art_p\">6。 山东日照钢铁 3胜4负 8分</p>\n<p class=\"art_p\">7。 河北 0胜8负 0分</p>\n<p class=\"art_p\">（高加索）</p>",
                    "https://n.sinaimg.cn/sports/transform/258/w650h408/20231202/a933-e21c6c3d6a3983007e189eaa63f2259e.png",
                    "新浪体育讯",
                    "2023-12-02",
                    "排超-李盈莹休战天津女排9连胜 四川送河北8连败",
                    "https://sports.sina.cn/others/volleyball/2023-12-02/detail-imzwrqmq7510992.d.html?vt=4&pos=108",
                    "https://sports.sina.com.cn/others/volleyball/2023-12-02/doc-imzwrqmq7510992.shtml"
                ),
                NewsDetail(
                    "sports",
                    "<p class=\"art_p\">北京时间12月2日，2023-2024赛季中国女子排球超级联赛第一阶段小组赛第9轮争夺全面展开。在A组的3场较量中，李盈莹休战的天津渤海银行客场3-0轻取河南双汇，豪取9连胜领跑本组；郑益昕和庄宇珊领衔的福建安溪铁观音主场3-1力挫劲敌北京汽车，斩获赛季第3场胜利后即时排名升至小组第4；四川五粮春凭借接应缪伊雯和德国外援贾茨科的稳定发挥3-0送河北队8连败。</p>\n<p class=\"art_p\"><strong>2023-2024赛季中国女子排球超级联赛第一阶段小组赛第9轮A组完全赛果如下：</strong></p>\n<p class=\"art_p\">福建安溪铁观音3-1胜北京汽车（25-19、25-17、21-25、25-15）</p>\n<p class=\"art_p\">河南双汇0-3负天津渤海银行（20-25、13-25、16-25）</p>\n<p class=\"art_p\">河北0-3负四川五粮春（19-25、11-25、17-25）</p>\n<p class=\"art_p\"><strong>2023-2024赛季中国女子排球超级联赛第一阶段小组赛A组即时排名如下：</strong></p>\n<p class=\"art_p\">1。 天津渤海银行 9胜0负 27分</p>\n<div sax-type=\"proxy\" class=\"j_native_stu231202 box\" style=\"margin:20px 0\"></div><p class=\"art_p\">2。 北京汽车 5胜3负 15分</p>\n<p class=\"art_p\">3。 河南双汇 4胜4负 12分</p>\n<p class=\"art_p\">4。 福建安溪铁观音 3胜4负 10分</p>\n<p class=\"art_p\">5。 四川五粮春 3胜4负 9分</p>\n<p class=\"art_p\">6。 山东日照钢铁 3胜4负 8分</p>\n<p class=\"art_p\">7。 河北 0胜8负 0分</p>\n<p class=\"art_p\">（高加索）</p>",
                    "https://n.sinaimg.cn/sports/transform/258/w650h408/20231202/a933-e21c6c3d6a3983007e189eaa63f2259e.png",
                    "新浪体育讯",
                    "2023-12-02",
                    "排超-李盈莹休战天津女排9连胜 四川送河北8连败",
                    "https://sports.sina.cn/others/volleyball/2023-12-02/detail-imzwrqmq7510992.d.html?vt=4&pos=108",
                    "https://sports.sina.com.cn/others/volleyball/2023-12-02/doc-imzwrqmq7510992.shtml"
                ),
                NewsDetail(
                    "sports",
                    "<p class=\"art_p\">北京时间12月2日，2023-2024赛季中国女子排球超级联赛第一阶段小组赛第9轮争夺全面展开。在A组的3场较量中，李盈莹休战的天津渤海银行客场3-0轻取河南双汇，豪取9连胜领跑本组；郑益昕和庄宇珊领衔的福建安溪铁观音主场3-1力挫劲敌北京汽车，斩获赛季第3场胜利后即时排名升至小组第4；四川五粮春凭借接应缪伊雯和德国外援贾茨科的稳定发挥3-0送河北队8连败。</p>\n<p class=\"art_p\"><strong>2023-2024赛季中国女子排球超级联赛第一阶段小组赛第9轮A组完全赛果如下：</strong></p>\n<p class=\"art_p\">福建安溪铁观音3-1胜北京汽车（25-19、25-17、21-25、25-15）</p>\n<p class=\"art_p\">河南双汇0-3负天津渤海银行（20-25、13-25、16-25）</p>\n<p class=\"art_p\">河北0-3负四川五粮春（19-25、11-25、17-25）</p>\n<p class=\"art_p\"><strong>2023-2024赛季中国女子排球超级联赛第一阶段小组赛A组即时排名如下：</strong></p>\n<p class=\"art_p\">1。 天津渤海银行 9胜0负 27分</p>\n<div sax-type=\"proxy\" class=\"j_native_stu231202 box\" style=\"margin:20px 0\"></div><p class=\"art_p\">2。 北京汽车 5胜3负 15分</p>\n<p class=\"art_p\">3。 河南双汇 4胜4负 12分</p>\n<p class=\"art_p\">4。 福建安溪铁观音 3胜4负 10分</p>\n<p class=\"art_p\">5。 四川五粮春 3胜4负 9分</p>\n<p class=\"art_p\">6。 山东日照钢铁 3胜4负 8分</p>\n<p class=\"art_p\">7。 河北 0胜8负 0分</p>\n<p class=\"art_p\">（高加索）</p>",
                    "https://n.sinaimg.cn/sports/transform/258/w650h408/20231202/a933-e21c6c3d6a3983007e189eaa63f2259e.png",
                    "新浪体育讯",
                    "2023-12-02",
                    "排超-李盈莹休战天津女排9连胜 四川送河北8连败",
                    "https://sports.sina.cn/others/volleyball/2023-12-02/detail-imzwrqmq7510992.d.html?vt=4&pos=108",
                    "https://sports.sina.com.cn/others/volleyball/2023-12-02/doc-imzwrqmq7510992.shtml"
                ),
                NewsDetail(
                    "sports",
                    "<p class=\"art_p\">北京时间12月2日，2023-2024赛季中国女子排球超级联赛第一阶段小组赛第9轮争夺全面展开。在A组的3场较量中，李盈莹休战的天津渤海银行客场3-0轻取河南双汇，豪取9连胜领跑本组；郑益昕和庄宇珊领衔的福建安溪铁观音主场3-1力挫劲敌北京汽车，斩获赛季第3场胜利后即时排名升至小组第4；四川五粮春凭借接应缪伊雯和德国外援贾茨科的稳定发挥3-0送河北队8连败。</p>\n<p class=\"art_p\"><strong>2023-2024赛季中国女子排球超级联赛第一阶段小组赛第9轮A组完全赛果如下：</strong></p>\n<p class=\"art_p\">福建安溪铁观音3-1胜北京汽车（25-19、25-17、21-25、25-15）</p>\n<p class=\"art_p\">河南双汇0-3负天津渤海银行（20-25、13-25、16-25）</p>\n<p class=\"art_p\">河北0-3负四川五粮春（19-25、11-25、17-25）</p>\n<p class=\"art_p\"><strong>2023-2024赛季中国女子排球超级联赛第一阶段小组赛A组即时排名如下：</strong></p>\n<p class=\"art_p\">1。 天津渤海银行 9胜0负 27分</p>\n<div sax-type=\"proxy\" class=\"j_native_stu231202 box\" style=\"margin:20px 0\"></div><p class=\"art_p\">2。 北京汽车 5胜3负 15分</p>\n<p class=\"art_p\">3。 河南双汇 4胜4负 12分</p>\n<p class=\"art_p\">4。 福建安溪铁观音 3胜4负 10分</p>\n<p class=\"art_p\">5。 四川五粮春 3胜4负 9分</p>\n<p class=\"art_p\">6。 山东日照钢铁 3胜4负 8分</p>\n<p class=\"art_p\">7。 河北 0胜8负 0分</p>\n<p class=\"art_p\">（高加索）</p>",
                    "https://n.sinaimg.cn/sports/transform/258/w650h408/20231202/a933-e21c6c3d6a3983007e189eaa63f2259e.png",
                    "新浪体育讯",
                    "2023-12-02",
                    "排超-李盈莹休战天津女排9连胜 四川送河北8连败",
                    "https://sports.sina.cn/others/volleyball/2023-12-02/detail-imzwrqmq7510992.d.html?vt=4&pos=108",
                    "https://sports.sina.com.cn/others/volleyball/2023-12-02/doc-imzwrqmq7510992.shtml"
                ),
                NewsDetail(
                    "sports",
                    "<p class=\"art_p\">北京时间12月2日，2023-2024赛季中国女子排球超级联赛第一阶段小组赛第9轮争夺全面展开。在A组的3场较量中，李盈莹休战的天津渤海银行客场3-0轻取河南双汇，豪取9连胜领跑本组；郑益昕和庄宇珊领衔的福建安溪铁观音主场3-1力挫劲敌北京汽车，斩获赛季第3场胜利后即时排名升至小组第4；四川五粮春凭借接应缪伊雯和德国外援贾茨科的稳定发挥3-0送河北队8连败。</p>\n<p class=\"art_p\"><strong>2023-2024赛季中国女子排球超级联赛第一阶段小组赛第9轮A组完全赛果如下：</strong></p>\n<p class=\"art_p\">福建安溪铁观音3-1胜北京汽车（25-19、25-17、21-25、25-15）</p>\n<p class=\"art_p\">河南双汇0-3负天津渤海银行（20-25、13-25、16-25）</p>\n<p class=\"art_p\">河北0-3负四川五粮春（19-25、11-25、17-25）</p>\n<p class=\"art_p\"><strong>2023-2024赛季中国女子排球超级联赛第一阶段小组赛A组即时排名如下：</strong></p>\n<p class=\"art_p\">1。 天津渤海银行 9胜0负 27分</p>\n<div sax-type=\"proxy\" class=\"j_native_stu231202 box\" style=\"margin:20px 0\"></div><p class=\"art_p\">2。 北京汽车 5胜3负 15分</p>\n<p class=\"art_p\">3。 河南双汇 4胜4负 12分</p>\n<p class=\"art_p\">4。 福建安溪铁观音 3胜4负 10分</p>\n<p class=\"art_p\">5。 四川五粮春 3胜4负 9分</p>\n<p class=\"art_p\">6。 山东日照钢铁 3胜4负 8分</p>\n<p class=\"art_p\">7。 河北 0胜8负 0分</p>\n<p class=\"art_p\">（高加索）</p>",
                    "https://n.sinaimg.cn/sports/transform/258/w650h408/20231202/a933-e21c6c3d6a3983007e189eaa63f2259e.png",
                    "新浪体育讯",
                    "2023-12-02",
                    "排超-李盈莹休战天津女排9连胜 四川送河北8连败",
                    "https://sports.sina.cn/others/volleyball/2023-12-02/detail-imzwrqmq7510992.d.html?vt=4&pos=108",
                    "https://sports.sina.com.cn/others/volleyball/2023-12-02/doc-imzwrqmq7510992.shtml"
                ),
                NewsDetail(
                    "sports",
                    "<p class=\"art_p\">北京时间12月2日，2023-2024赛季中国女子排球超级联赛第一阶段小组赛第9轮争夺全面展开。在A组的3场较量中，李盈莹休战的天津渤海银行客场3-0轻取河南双汇，豪取9连胜领跑本组；郑益昕和庄宇珊领衔的福建安溪铁观音主场3-1力挫劲敌北京汽车，斩获赛季第3场胜利后即时排名升至小组第4；四川五粮春凭借接应缪伊雯和德国外援贾茨科的稳定发挥3-0送河北队8连败。</p>\n<p class=\"art_p\"><strong>2023-2024赛季中国女子排球超级联赛第一阶段小组赛第9轮A组完全赛果如下：</strong></p>\n<p class=\"art_p\">福建安溪铁观音3-1胜北京汽车（25-19、25-17、21-25、25-15）</p>\n<p class=\"art_p\">河南双汇0-3负天津渤海银行（20-25、13-25、16-25）</p>\n<p class=\"art_p\">河北0-3负四川五粮春（19-25、11-25、17-25）</p>\n<p class=\"art_p\"><strong>2023-2024赛季中国女子排球超级联赛第一阶段小组赛A组即时排名如下：</strong></p>\n<p class=\"art_p\">1。 天津渤海银行 9胜0负 27分</p>\n<div sax-type=\"proxy\" class=\"j_native_stu231202 box\" style=\"margin:20px 0\"></div><p class=\"art_p\">2。 北京汽车 5胜3负 15分</p>\n<p class=\"art_p\">3。 河南双汇 4胜4负 12分</p>\n<p class=\"art_p\">4。 福建安溪铁观音 3胜4负 10分</p>\n<p class=\"art_p\">5。 四川五粮春 3胜4负 9分</p>\n<p class=\"art_p\">6。 山东日照钢铁 3胜4负 8分</p>\n<p class=\"art_p\">7。 河北 0胜8负 0分</p>\n<p class=\"art_p\">（高加索）</p>",
                    "https://n.sinaimg.cn/sports/transform/258/w650h408/20231202/a933-e21c6c3d6a3983007e189eaa63f2259e.png",
                    "新浪体育讯",
                    "2023-12-02",
                    "排超-李盈莹休战天津女排9连胜 四川送河北8连败",
                    "https://sports.sina.cn/others/volleyball/2023-12-02/detail-imzwrqmq7510992.d.html?vt=4&pos=108",
                    "https://sports.sina.com.cn/others/volleyball/2023-12-02/doc-imzwrqmq7510992.shtml"
                )
            )
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(start = 20.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "收藏", fontSize = 20.sp)
    }

    Box(
        modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        LazyColumn(
            modifier = Modifier
                .background(color = Color.White)
        ) {
            items(items = data.value) {
                News(data = it)
            }
        }
    }
}

@Composable
fun News(data: NewsDetail?) {
    Card(
        modifier = Modifier
            .background(Color.White)
            .padding(10.dp)
            .fillMaxSize(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .clickable {
//                viewModel.newsDetail.value = data
//                navController.navigate(Destinations.NewsDetail.route) {
//                    restoreState = true
//                }
            }) {
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

}