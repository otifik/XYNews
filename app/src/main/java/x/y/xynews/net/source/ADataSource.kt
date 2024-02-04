package x.y.xynews.net.source

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import x.y.xynews.net.bean.DemoReqData
import x.y.xynews.net.network.repository.DataRepository
import java.io.IOException

class ADataSource : PagingSource<Int, DemoReqData.DataBean.DatasBean>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DemoReqData.DataBean.DatasBean> {

        return try {

            //页码未定义置为1
            val currentPage = params.key ?: 1
            //仓库层请求数据
            Log.d("请求页码标记", "请求第${currentPage}页")
            val demoReqData = DataRepository().loadData(currentPage)
            //当前页码 小于 总页码 页面加1
            val nextPage = if (currentPage < (demoReqData.data?.pageCount ?: 0)) {
                currentPage + 1
            } else {
                //没有更多数据
                null
            }

            LoadResult.Page(
                data = demoReqData.data!!.datas!!,
                prevKey = null,
                nextKey = nextPage
            )

        } catch (e: Exception) {
            if (e is IOException) {
                Log.d("测试错误数据", "-------连接失败")
            }
            Log.d("测试错误数据", "-------${e.message}")
            LoadResult.Error(throwable = e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, DemoReqData.DataBean.DatasBean>): Int? {
        return null
    }

}