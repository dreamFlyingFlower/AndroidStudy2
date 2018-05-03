package com.wy.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.wy.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Fragment的使用,通常称碎片,是一个activity中的多个组成部分
 * 1.加载fragment,第一种是直接将fragment直接拖到activity布局中
 */
@ContentView(R.layout.activity_ex_main_fragment)
public class ExMainFragment extends AppCompatActivity {
    // 碎片加载管理器
    private FragmentManager fm;
    // 碎片布局事务管理器
    private FragmentTransaction ft;

    @ViewInject(R.id.frags)
    private LinearLayout frags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm = getFragmentManager();
        ft = fm.beginTransaction();
        Fragment01 f01 = new Fragment01();
        // 添加一个碎片到某个容器中
        ft.add(R.id.frags, f01);
        // 提交之后才能真正添加到容器中
        ft.commit();

    }
}
