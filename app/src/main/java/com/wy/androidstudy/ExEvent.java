package com.wy.androidstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 事件重写
 * 当需要键盘的事件的时候,需要重写onKeyDown方法
 * 当需要触摸屏事件的时候,需要重写onTouchEvent方法
 * 当需要滚动球事件的时候,需要重写onTrackballEvent
 */
public class ExEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_event);
    }
}
