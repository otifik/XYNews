package x.y.xynews.net.bean

data class NewsData(
    val charge: Boolean,
    val code: String,
    val msg: String,
    val requestId: String,
    val result: Result
)

data class Result(
    val msg: String,
    val result: ResultData,
    val status: Int
)

data class ResultData(
    val channel: String,
    val list: List<NewsDetail>,
    val num: Int
)

data class NewsDetail(
    val category: String,
    val content: String,
    val pic: String,
    val src: String,
    val time: String,
    val title: String,
    val url: String,
    val weburl: String
)