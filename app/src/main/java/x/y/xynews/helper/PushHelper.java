package x.y.xynews.helper;

import android.app.Notification;
import android.content.Context;
import android.util.Log;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.api.UPushRegisterCallback;
import com.umeng.message.api.UPushThirdTokenCallback;
import com.umeng.message.entity.UMessage;


/**
 * PushSDK集成帮助类
 */
public class PushHelper {

    public static final String TAG = "PushHelper";

    /**
     * 预初始化
     */
    public static void preInit(Context context) {
        UMConfigure.preInit(context, PushConstants.APP_KEY, PushConstants.CHANNEL);
    }

    /**
     * 初始化
     */
    public static void init(final Context context) {
        // 基础组件包提供的初始化函数，应用配置信息：http://message.umeng.com/list/apps
        // 参数一：上下文context；
        // 参数二：应用申请的Appkey；
        // 参数三：发布渠道名称；
        // 参数四：设备类型，UMConfigure.DEVICE_TYPE_PHONE：手机；UMConfigure.DEVICE_TYPE_BOX：盒子；默认为手机
        // 参数五：Push推送业务的secret，填写Umeng Message Secret对应信息
        UMConfigure.init(
                context,
                PushConstants.APP_KEY,
                PushConstants.CHANNEL,
                UMConfigure.DEVICE_TYPE_PHONE,
                PushConstants.MESSAGE_SECRET
        );

        //获取推送实例
        PushAgent api = PushAgent.getInstance(context);

        //修改为您app/src/main/AndroidManifest.xml中package值
        api.setResourcePackageName("x.y.xynews");

        //设置推送
        pushSetting(context);

        //设置厂商Token回调
        api.setThirdTokenCallback(new UPushThirdTokenCallback() {
            @Override
            public void onToken(String type, String token) {
                Log.i(TAG, "push type:" + type + " token:" + token);
            }
        });

        //注册推送
        api.register(new UPushRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //deviceToken是推送消息的唯一标识
                Log.i(TAG, "deviceToken: " + deviceToken);
//                //获取deviceToken可通过接口：
//                PushAgent.getInstance(context).getRegistrationId();
//                //设置别名：推送时可使用别名推送
//                String alias = "123456";
//                String type = "uid";
//                PushAgent.getInstance(context).setAlias(alias, type, new UPushAliasCallback() {
//                    @Override
//                    public void onMessage(boolean success, String message) {
//                        Log.i(TAG, "setAlias " + success + " msg:" + message);
//                    }
//                });
            }

            @Override
            public void onFailure(String errCode, String errDesc) {
                Log.e(TAG, "register failed! " + "code:" + errCode + ",desc:" + errDesc);
            }
        });

    }

    /**
     * 推送设置
     */
    private static void pushSetting(Context context) {
        PushAgent api = PushAgent.getInstance(context);

        //设置通知栏显示通知的最大个数（0～10），0：不限制个数
        api.setDisplayNotificationNumber(0);

        //推送消息处理
        UmengMessageHandler msgHandler = new UmengMessageHandler() {
            //处理通知栏消息
            @Override
            public void dealWithNotificationMessage(Context context, UMessage msg) {
                super.dealWithNotificationMessage(context, msg);
                Log.i(TAG, "notification receiver:\n" + msg.getRaw().toString());
            }

            //自定义通知样式，此方法可以修改通知样式等
            @Override
            public Notification getNotification(Context context, UMessage msg) {
                return super.getNotification(context, msg);
            }

            //处理透传消息
            @Override
            public void dealWithCustomMessage(Context context, UMessage msg) {
                super.dealWithCustomMessage(context, msg);
                Log.i(TAG, "custom receiver:\n" + msg.getRaw().toString());
            }
        };
        api.setMessageHandler(msgHandler);

        //推送消息点击处理
        UmengNotificationClickHandler notificationClickHandler = new UmengNotificationClickHandler() {
            @Override
            public void openActivity(Context context, UMessage msg) {
                super.openActivity(context, msg);
                Log.i(TAG, "click open activity:\n" + msg.getRaw().toString());
            }

            @Override
            public void launchApp(Context context, UMessage msg) {
                super.launchApp(context, msg);
                Log.i(TAG, "click launch app:\n" + msg.getRaw().toString());
            }

            @Override
            public void openUrl(Context context, UMessage msg) {
                super.openUrl(context, msg);
                Log.i(TAG, "click open deeplink:\n" + msg.getRaw().toString());
            }

            @Override
            public void dismissNotification(Context context, UMessage msg) {
                super.dismissNotification(context, msg);
                Log.i(TAG, "dismissNotification:\n" + msg.getRaw().toString());
            }
        };
        api.setNotificationClickHandler(notificationClickHandler);

        //通过Service自定义接收并处理消息
//        api.setPushIntentServiceClass(MyCustomMessageService.class);

    }

}
