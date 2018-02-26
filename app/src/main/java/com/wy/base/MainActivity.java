package com.wy.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 快捷键
 * ctrl+alt+L:代码格式化
 * alt+enter:手动导包
 * alt+insert:重写各种方法,实现发现
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
