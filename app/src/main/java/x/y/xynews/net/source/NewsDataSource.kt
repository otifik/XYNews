package x.y.xynews.net.source

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import x.y.xynews.net.CHANNEL_TOUTIAO
import x.y.xynews.net.PAGE_NUM
import x.y.xynews.net.bean.NewsDetail
import x.y.xynews.net.network.repository.NewsDataRepository
import java.io.IOException

class NewsDataSource(private val channel: String = CHANNEL_TOUTIAO) : PagingSource<Int, NewsDetail>() {

    val TAG = "NewsDataSource"

    override fun getRefreshKey(state: PagingState<Int, NewsDetail>): Int? {
//        return state.anchorPosition?.let { anchorPosition ->
//            val anchorPage = state.closestPageToPosition(anchorPosition)
//            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
//        }
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsDetail> {
        return try {
            val currentStart = params.key ?: 0

            Log.d(TAG,"请求起始位置为${currentStart}")

            val newsData = NewsDataRepository.getNews(channel = channel, start = currentStart)

//            delay(1000L)

            val nextStart = if ((currentStart / 5) < (PAGE_NUM - 1)) {
                currentStart + 5
            } else {
                null
            }

            LoadResult.Page(
                data = newsData.result.result.list,
                prevKey = null,
                nextKey = nextStart
            )
        } catch (e: Exception) {
            if (e is IOException) {
                Log.d(TAG,"Network Error")
            }
            Log.d(TAG,"${e.message}")
            LoadResult.Error(throwable = e)
        }
    }
}