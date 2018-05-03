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
        // 从activity传值到fragment
        f01.setArguments(new Bundle());
        // 添加fragment到activity中有多种方法,可网上查找
        // 添加一个碎片到某个容器中
        ft.add(R.id.frags, f01);
        // 提交之后才能真正添加到容器中
        ft.commit();

        // 回退栈,当有多个fragment的时候,当回退的时候需要进行回退栈的处理,否则不会达到预期的效果
        // 当从一个fragmeng跳到另外一个fragment的时候,用replace方法
        // 需要进行替代的父容器,需要显示的fragment,唯一标识符
        ft.replace(R.id.frags,f01,"fragment01");
        // 添加到activity管理的回退栈中
        ft.addToBackStack("fragment01");
        ft.commit();

    }
}
