package com.wy.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by wanyang on 2018/2/25.
 */

/**
 * 广播接收,需要继承BroadcaseReceiver,并且需要在main文件中注册,用receive
 * 有一些系统内置的广播,比如短信之类的
 */
public class ExBroadReceive extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, intent.getAction(), Toast.LENGTH_SHORT).show();
    }
}
