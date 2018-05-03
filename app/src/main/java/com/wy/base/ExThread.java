package com.wy.base;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wy.R;

/**
 * 多线程,在android中,只能有一个主线程,就是当前的activity线程,若是启动了一个子线程,而且子线程对主线程进行了更改
 * 则子线程必须通知主线程做了更改
 * android的线程池是Async,网上查找资料吧
 */
public class ExThread extends AppCompatActivity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_thread);

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case 0:
                        System.out.println("子线程对主线程所需要做的操作");
                        break;
                    default:break;
                }
                super.handleMessage(msg);
            }
        };

        Thread son = new Thread(){
            @Override
            public void run(){
                System.out.println("子线程");
                Message msg = new Message();
                msg.obj="this is a test";
                msg.what = 1;
                ExThread.this.handler.sendMessage(msg);
            }
        };
        son.start();
    }
}
