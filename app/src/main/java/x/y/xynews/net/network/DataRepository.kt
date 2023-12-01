package x.y.xynews.net.network

import x.y.xynews.net.api.DataApi
import x.y.xynews.net.bean.DemoReqData

class DataRepository {

    private var netWork = RetrofitService.createService(
        DataApi::class.java
    )

    /**
     * 查询数据
     */
    suspend fun loadData(
        pageId: Int
    ): DemoReqData {
        return netWork.getData(pageId)
    }
}