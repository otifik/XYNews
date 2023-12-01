package x.y.xynews.net.api

import retrofit2.http.GET
import retrofit2.http.Path
import x.y.xynews.net.bean.DemoReqData

interface DataApi {

    /**
     * 获取数据
     */
    @GET("wenda/list/{pageId}/json")
    suspend fun getData(@Path("pageId") pageId:Int): DemoReqData
}