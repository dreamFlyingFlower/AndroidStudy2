package com.wy.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.wy.R;

/**
 * 专门用于和其他主要例子类型进行交互的例子
 */
public class ExChange extends AppCompatActivity {
    private static final String TAG = "exchange";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_change);

        /**
         * 获得intent中的数据,需要在onCreate方法中调用获得Intent的方法
         */
        Intent intent1 = getIntent();
        String test1 = intent1.getStringExtra("test1");
        // 两种获得bundle的方法,对应两种设置bundle的方法
        Bundle bundle1 = intent1.getBundleExtra("bundle");
        Bundle bundle2 = intent1.getExtras();
        Log.i(TAG,test1+bundle1+bundle2);

        /**
         * 给上一个activity中的startActivityForResult方法传回需要的数据
         */
        Intent intent = new Intent();
        intent.putExtra("back","success");
        // 此方法第一个参数是让系统知道这个请求是谁发的,第二个参数若无数据传递可不写
        // 在调用startActivityForResult方法的activity中必须重写方法才能
        setResult(10001,intent);
        // 回传数据的时候必须关闭当前的activity
        finish();
    }
}
