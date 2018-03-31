package com.wy.base;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import com.wy.R;

import org.xutils.view.annotation.ContentView;

/**
 * Service服务,当该服务不需要与用户进行交互,而只需要在后台进行,又不能被关掉时使用
 * Service需要进行注册,service有context.startService和context.bindService,bindService是被其他应用所调用
 * 同一个service只要启动一次,即使再调用startService的onStart方法来调用,也不会再次调用,也不会刷新
 * bindService会得到一个service的永久链接,这个方法会在该service服务没有启动的条件下创建服务,onCreate方法
 * 但是不会运行onStart方法,此时bindService会得到service返回的一个IBinder对象,可以允许客户端回调服务.
 * 只要建立连接,服务会一直运行
 *
 * service的onstart已经废弃,需要重新上网找资料
 * 在其他activity中调用的时候需要新建一个Intent,setaction为这个service的标识符, 即注册中的name属性
 * 然后调用startService,传入这个Intent
 */
@ContentView(R.layout.activity_ex_service)
public class ExService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onStart(Intent intent,int startId){
        super.onStart(intent, startId);
    }
}