package x.y.xynews

import android.app.Application
import com.umeng.commonsdk.UMConfigure
import dagger.hilt.android.HiltAndroidApp
import x.y.xynews.helper.PushHelper

@HiltAndroidApp
class XYNewsApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initUmengSDK()
    }

    private fun initUmengSDK() {
        UMConfigure.setLogEnabled(true)
        PushHelper.preInit(this)
        Thread { PushHelper.init(applicationContext) }.start()
    }
}