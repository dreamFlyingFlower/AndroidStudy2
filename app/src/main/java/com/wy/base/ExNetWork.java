package com.wy.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 监听系统的网络变化,需要权限
 */
public class ExNetWork extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // 判断是否是网络改变的通知
        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            // 拿到系统的网络管理链接对象,这是系统服务,不受程序控制
            ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo ni = cm.getActiveNetworkInfo();
            if(ni != null || ni.isAvailable()){
                System.out.println(ni.getTypeName());
            }
        }
    }
}