package x.y.xynews.net.network

import x.y.xynews.net.APPKEY
import x.y.xynews.net.CHANNEL_TOUTIAO
import x.y.xynews.net.NUM
import x.y.xynews.net.api.NewsDataApi

object NewsDataRepository {

    private var newsDataApi = NewsRetrofit.createService(NewsDataApi::class.java)

    suspend fun getNews(
        appKey: String = APPKEY,
        channel: String = CHANNEL_TOUTIAO,
        num: Int = NUM,
        start: Int = 0
    ) = newsDataApi.getNews(appKey, channel, num, start)
}