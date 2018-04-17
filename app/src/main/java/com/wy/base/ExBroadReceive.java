package com.wy.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by wanyang on 2018/2/25.
 */

/**
 * 广播接收,需要继承BroadcaseReceiver,并且需要在main文件中注册,用receive,是系统内部调用
 * 有一些系统内置的广播,比如短信之类的
 */
public class ExBroadReceive extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, intent.getAction(), Toast.LENGTH_SHORT).show();
        if(intent.getAction().equals("com.wy.base.ExBroadReceiver")){
            System.out.println(intent.getStringExtra("test"));

            // 在接收有序广播的时候,优先级高的接受者可以对结果进行处理,加入其他的参数什么的
            Bundle b =new Bundle();
            b.putString("test11","54dfsfds");
            setResultExtras(b);

            // 下一个接收者拿到广播里的额外数据
            // 若是没有额外数据,是否新建一个Bundle
            Bundle extras = getResultExtras(false);
            // 终止广播
            abortBroadcast();
        }
    }
}
