package com.wy.base;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
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
 * startservice调用启动的service会跟主activity一个线程,若需要在service进行耗时操作,最好都是用线程
 *
 * service的onstart已经废弃,需使用onStartCommand
 * 在其他activity中调用的时候需要新建一个Intent,setaction为这个service的标识符, 即注册中的name属性
 * 然后调用startService,传入这个Intent
 *
 *  service的几种状态
 *  start_sticky:粘性服务,当onStartCommand方法的返回值是start_sticky,若服务被异常杀掉,
 *  系统会尝试重新启动service,但在此期间没有任务启动命令传到service,则intent会null
 *  start_not_sticky:非粘性服务,当返回值是这个时,不重启服务
 *  start_redeliver_intent:粘性增强版,重启服务,重传intent
 *  start_sticky_compatibility:start_sticky的兼容版本
 */
@ContentView(R.layout.activity_ex_service)
public class ExService extends Service {

    // 通过信使来处理activity传过来的消息
    final Messenger messenger = new Messenger(new handlerMsg());

    // 回传消息给activity
    Messenger remessage;
    
    // 处理从activity传过来的消息
    class handlerMsg extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){
                //需要进行的操作
                Object obj = msg.obj;
                remessage = msg.replyTo;
                try {
                    remessage.send(msg);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 当服务被远程调用的时候,即被bindservice的时候,该方法返回值
     * 需要使用aidl,此处不讨论
     * @param intent
     * @return
     */
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

    /**
     * onStart已废弃,使用该方法
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 停止自身服务
        stopSelf();
//        return super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }
}