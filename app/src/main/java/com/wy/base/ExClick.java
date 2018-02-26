package com.wy.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wy.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * 点击的多种实现形式
 * 1.当本类直接实现View的onclicklistener方法时,当布局文件中发生点击事件时直接就会调用重写的onClick方法
 * 当布局文件中可出现多个点击事件时,可通过组件的id进行区别
 * 2.不实现View.OnClickListener,直接写一个匿名内部内
 * 3.申明一个由实现了clicklistener方法的变量,传入到点击方法内
 */
@ContentView(R.layout.activity_ex_click)
public class ExClick extends AppCompatActivity implements View.OnClickListener {

    @ViewInject(R.id.textView1)
    private TextView textView1;
    @ViewInject(R.id.textView2)
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //当调用点击方法时,不用重写onclicklistener方法
        // 直接将本上下文传入即可,在onClick方法中判断是那一个组件点击
        textView1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textView1:
                textView1.setText("zheshi text1");
                break;
            case R.id.textView2:
                textView2.setText("这是text2");
                break;
            default:
                return;
        }
    }
}
