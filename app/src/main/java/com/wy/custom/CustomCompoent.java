package com.wy.custom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by wanyang on 2018/5/6.
 * 手写一个组件,软编码实现,不使用布局文件
 */

public class CustomCompoent extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //创建一个线性的父组件布局
        LinearLayout ll = new LinearLayout(this);
        // 设置他的方向
        ll.setOrientation(LinearLayout.VERTICAL);

        TextView tv = new TextView(this);
        // 创建一个tv所需要的宽高布局变量
        ViewGroup.LayoutParams tvP = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        // 将textview添加到线性布局中
        ll.addView(tv,tvP);
        // 将线性布局初始化
        setContentView(ll,tvP);
    }
}
