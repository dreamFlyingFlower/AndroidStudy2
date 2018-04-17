package com.wy.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wy.R;

/**
 * 发送一个广播
 */
public class ExBroadSend extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_broad_send);

        Intent i = new Intent();
        i.putExtra("test","111");
        // 需要注册,在配置文件中注册的广播接收器的action
        i.setAction("com.wy.base.ExBroadReceiver");
        sendBroadcast(i);

        // 默认广播,异步执行,所有应用都可以收到,无法终止
        // context.sendBroadcast(intent);
        // 有序广播,从优先级高的开始发送,优先级高的可以取消接收并发送
        // context.sendOrderedBroadcast(intent,"34343");
        // 粘性广播,即广播发送完了之后注册接收者也可以接收,需要使用权限
        // context.sendStickyBroadcast(intent);

        // 移除粘性广播
        removeStickyBroadcast(i);
    }
}
