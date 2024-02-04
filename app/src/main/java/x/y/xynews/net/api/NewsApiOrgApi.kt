package x.y.xynews.net.api

import retrofit2.http.GET
import retrofit2.http.Query
import x.y.xynews.net.bean.NewsApiOrgResponse

interface NewsApiOrgApi {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("apiKey") apiKey: String,
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int,
    ): NewsApiOrgResponse
}