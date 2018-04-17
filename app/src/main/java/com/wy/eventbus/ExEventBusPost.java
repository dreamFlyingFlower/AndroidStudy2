package com.wy.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.wy.R;

import org.greenrobot.eventbus.EventBus;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * EventBus事件的发布者
 */
@ContentView(R.layout.activity_ex_event_bus_post)
public class ExEventBusPost extends AppCompatActivity {

    @ViewInject(R.id.publisher1)
    private Button publisher1;
    @ViewInject(R.id.jump)
    private Button jump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        // 在本类中对ExEventBusRegister进行注册,可保证本类发布的小心ExEventBusRegister必然可收到
        EventBus.getDefault().register(new ExEventBusRegister());
    }

    @Event(value=R.id.jump)
    private void jump(View view){
        Intent i = new Intent(ExEventBusPost.this,ExEventBusRegister.class);
        startActivity(i);
    }

    @Event(value=R.id.publisher1)
    private void onClick(View view){
        System.out.println("11111111");
        // 发布事件,只有注册过的类会收到信息,根据post的参数类型来接收,传字符串无效,收不到
        EventBus.getDefault().post("来把,小子,改变吧");
        // 难道只能传对象,不能传字符串?
        EventBus.getDefault().post(new ExEventBus());
    }
}
