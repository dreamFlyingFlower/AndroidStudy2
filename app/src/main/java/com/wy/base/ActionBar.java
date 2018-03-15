package com.wy.base;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.wy.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * actionBar学习类
 */
@ContentView(R.layout.activity_action_bar)
public class ActionBar extends AppCompatActivity {

    @ViewInject(R.id.toolbar)
    private Toolbar toolbar;
    @ViewInject(R.id.fab)
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if(getActionBar() != null){
//     目前的的软件默认会带一个actionbar，就是程序启动后上方的一个类型Windows程序标题栏的东西;
//     当使用AppCompatActivity或其他support包中的基类时,需要使用getSupportActionBar()方法
            getActionBar().hide();
        }else{
//        当使用AppCompatActivity或其他support包中的基类时使用,相当于getActionBar()
            getSupportActionBar().hide();
        }
//        决定左上角的图标是否可以点击。没有向左的小图标。 true 图标可以点击  false 不可以点击
        getSupportActionBar().setHomeButtonEnabled(true);
//        给左上角图标的左边加上一个返回的图标 。对应ActionBar.DISPLAY_HOME_AS_UP
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//          使左上角图标是否显示，如果设成false，则没有程序图标，仅仅就个标题，否则，显示应用程序图标，对应id为Android.R.id.home，对应ActionBar.DISPLAY_SHOW_HOME
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        // 使自定义的普通View能在title栏显示，即actionBar.setCustomView能起作用，对应ActionBar.DISPLAY_SHOW_CUSTOM
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        //对应ActionBar.DISPLAY_SHOW_TITLE。
        getSupportActionBar().setDisplayShowTitleEnabled(true);
// 其中setHomeButtonEnabled和setDisplayShowHomeEnabled共同起作用，
// 如果setHomeButtonEnabled设成false，即使setDisplayShowHomeEnabled设成true，图标也不能点击
    }
}
