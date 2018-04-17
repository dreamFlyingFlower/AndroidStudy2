package com.wy.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.wy.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * EventBus事件分发例子
 * 类似于监听器,当调用了EventBus之后,所有注册过的类都会收到参数对象改变的信息
 * 当收到改变信息后可对操作进行处理
 * 相当于每次对一个对象进行操作时,都会相同的操作
 * 步骤:先注册,注册只是告诉EventBus当调用了post方法来改变某些对象时,
 * 注册过的类可以收到这个信息,但是有什么操作需要重新写方法
 */
public class ExEventBusRegister extends AppCompatActivity {

    private static final String TAG = "ExEventBusRegister";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_event_bus_register);

        // 注册该类,订阅事件,当其他地方调用post方法,即发布订阅事件的时候
        // 可以根据post的参数的类型来找到指定的方法进行处理
        // register只是能收到通知,并不能处理发布的事件,处理发布事件需要另外的处理方法
        // ****最重要的是注册需要在发布之前调用,否则收不到发布者的信息
        EventBus.getDefault().register(this);

        // 解除事件订阅
        //        EventBus.getDefault().unregister(this);

        // 发布事件
        //        EventBus.getDefault().post("this is s test");
    }

    /**
     * 只有当该类注册之后才会调用handlerMsg方法,即调用了register方法
     * threadMode为线程运行方式,有4种::main:ui主线程;background:后台线程;posting:和发布者同一个线程;async:异步线程,默认是posting
     * priority优先级,数字越大,优先级越高,且具有传播属性.
     * 当有多个注册类都对目标类进行处理的时候,会根据优先级来判断处理的先后顺序
     * 优先级越高的先处理,而且优先级高的可以取消注册事件的传播
     * 即当本类处理完目标类的时候可以取消事件,优先级低的将收不到该事件
     *
     * @param e
     */
    @Subscribe(threadMode = ThreadMode.MAIN,priority = 100)
    public void handlerMsg(ExEventBus e) {
        // 终止事件的继续传播
        // EventBus.getDefault().cancelEventDelivery(msg);
        System.out.println("@@@@@@0");
        Log.i(TAG, "@@@@@@@@@@@0");
    }

    @Subscribe(threadMode = ThreadMode.MAIN, priority = 100)
    public void handlerMsg1(ExEventBus e) {
        // 终止事件的继续传播
        // EventBus.getDefault().cancelEventDelivery(msg);
        System.out.println("@@@@@@1");
        Log.i(TAG, "@@@@@@@@@1");
    }

    /**
     * 在布局文件中写的点击方法,必须和activity同名,且必须是public的,否则报错
     * @param view
     */
    public void back(View view){
        startActivity(new Intent(ExEventBusRegister.this,ExEventBusPost.class));
    }
}