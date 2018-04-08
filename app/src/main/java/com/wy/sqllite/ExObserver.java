package com.wy.sqllite;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wy.R;

/**
 * 当sqlite数据库中有值发生变化时,会通知其他应用值改变了,当值改变时需要进行处理
 */
public class ExObserver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_observer);
        // 注册的服务类的name
        Uri uri = Uri.parse("content://com.xxxx/test");
        // 创建一个继承ContentObserver的监听类来处理数据通知
        this.getContentResolver().registerContentObserver(uri,true, new Observer(new Handler()));
    }

    private class Observer extends ContentObserver {

        public Observer(Handler handler) {
            super(handler);
        }

        // 数据改变时会调用监听的onChange方法.且收到通知的时候也不知道是那种改变,需要自己判断查找
        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
        }

    }
}
