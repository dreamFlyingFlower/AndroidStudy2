package com.wy.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wy.R;

/**
 * Created by wanyang on 2018/4/8.
 */

public class ExBaseFuns extends AppCompatActivity {
    // 当切换到本activity时会首先调用onCreate方法
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // 创建实例
        super.onCreate(savedInstanceState);
        // 显示activity
        setContentView(R.layout.activity_base);

        // 意图,activity之间的切换
        Intent intent = new Intent(ExBaseFuns.this,BaseActivity.class);
    }
}
