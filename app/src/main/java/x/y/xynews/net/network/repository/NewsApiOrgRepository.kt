package x.y.xynews.net.network.repository

import x.y.xynews.net.APIKEY
import x.y.xynews.net.APPKEY
import x.y.xynews.net.CATEGORY_BUSINESS
import x.y.xynews.net.CHANNEL_TOUTIAO
import x.y.xynews.net.COUNTRY
import x.y.xynews.net.NUM
import x.y.xynews.net.PAGE_SIZE
import x.y.xynews.net.api.NewsApiOrgApi
import x.y.xynews.net.api.NewsDataApi
import x.y.xynews.net.network.NewsApiOrgRetrofit
import x.y.xynews.net.network.NewsRetrofit

object NewsApiOrgRepository {

    private var newsApiOrgApi = NewsApiOrgRetrofit.createService(NewsApiOrgApi::class.java)

    suspend fun getTopHeadlines(
        apiKey: String = APIKEY,
        country: String = COUNTRY,
        category: String = CATEGORY_BUSINESS,
        pageSize: Int = PAGE_SIZE,
        page: Int
    ) = newsApiOrgApi.getTopHeadlines(apiKey, country, category, pageSize, page)
}