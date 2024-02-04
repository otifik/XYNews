package x.y.xynews.net.source

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import x.y.xynews.net.CATEGORY_BUSINESS
import x.y.xynews.net.PAGE_NUM
import x.y.xynews.net.PAGE_SIZE
import x.y.xynews.net.bean.Article
import x.y.xynews.net.network.repository.NewsApiOrgRepository
import x.y.xynews.net.network.repository.NewsDataRepository
import java.io.IOException


class NewsApiOrgDataSource(private val category: String = CATEGORY_BUSINESS) :
    PagingSource<Int, Article>() {

    val TAG = "NewsApiOrgDataSource"

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val currentPage = params.key ?: 0

            Log.d(TAG, "请求起始位置为${currentPage}")

//            val newsData = NewsDataRepository.getNews(channel = channel, start = currentStart)

            val newsApiOrgResponses =
                NewsApiOrgRepository.getTopHeadlines(category = category, page = currentPage)

//            delay(1000L)

            val totalPages = if (newsApiOrgResponses.totalResults % PAGE_SIZE == 0) {
                newsApiOrgResponses.totalResults / PAGE_SIZE
            }else {
                newsApiOrgResponses.totalResults / PAGE_SIZE + 1
            }

            val nextPage =
                if (currentPage < totalPages - 1 && currentPage >= 0) {
                    currentPage + 1
                } else {
                    null
                }

            LoadResult.Page(
                data = newsApiOrgResponses.articles,
                prevKey = null,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            if (e is IOException) {
                Log.d(TAG, "Network Error")
            }
            Log.d(TAG, "${e.message}")
            LoadResult.Error(throwable = e)
        }
    }
}