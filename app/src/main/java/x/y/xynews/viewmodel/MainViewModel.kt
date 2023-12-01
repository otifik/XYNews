package x.y.xynews.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import x.y.xynews.net.bean.NewsDetail
import x.y.xynews.net.source.ADataSource
import x.y.xynews.net.source.NewsDataSource
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor() : ViewModel() {

//    /**
//     * 获取数据
//     */
//    fun getData() = Pager(PagingConfig(pageSize = 8)) {
//        ADataSource()
//    }.flow.cachedIn(viewModelScope)

    var newsDetail: MutableState<NewsDetail?> = mutableStateOf(NewsDetail("none","none","none","none","none","none","none","none"))

    fun getNewsData(channel: String) = Pager(PagingConfig(pageSize = 5)) {
        NewsDataSource(channel)
    }.flow.cachedIn(viewModelScope)
}