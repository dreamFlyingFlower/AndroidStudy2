package com.wy.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wy.R;

/**
 * 手势识别
 * 需要先建立手势库,然后根据用户手势进行匹配
 * FIXME
 */
public class ExGestrue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_gestrue);
    }
}
