package x.y.xynews.net.api

import retrofit2.http.GET
import retrofit2.http.Query
import x.y.xynews.net.bean.NewsData

interface NewsDataApi {
    @GET("jisuapi/get")
    suspend fun getNews(
        @Query("appkey") appKey: String,
        @Query("channel") channel: String,
        @Query("num") num: Int,
        @Query("start") start: Int
    ): NewsData
}