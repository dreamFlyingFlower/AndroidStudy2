package com.wy.custom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

import com.wy.R;

/**
 * 自定义标签,TagHost
 * TagHost为根标签,其中包括TagWidget,主要是放标签名字和图片,标签的id必须是R.id.tabs
 * 主要的部分必须用Fragment来布局,id也必须和系统规定的应用R.id.tabContent
 */
public class CusTagHost extends AppCompatActivity {

    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus_tag_host);

        tabHost = (TabHost)findViewById(R.id.tabHost);
        // 需要找到tabwidget和fragment控件,可从源码中看出
        tabHost.setup();
        // 新建标签页,参数用来指定标签的唯一标识,和布局中的可以不同
        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec("tabpage1");
        // 设置标签页的图片和文字,图片需要通过加载资源文件来获得,直接使用getDrawable需要最低sdk21
        tabSpec1.setIndicator("第一个页面", getResources().getDrawable(R.drawable.test01));
        // 自定义标签页的样式
        // tabSpec1.setIndicator(new View());
        // 指定标签对应的fragment的id
        tabSpec1.setContent(R.id.tabpage1);
        // 添加标签页对象
        tabHost.addTab(tabSpec1);

        // 添加第2个标签页
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("tabpage1");
        tabSpec2.setIndicator("第一个页面", getResources().getDrawable(R.drawable.test01));
        tabSpec2.setContent(R.id.tabpage2);
        tabHost.addTab(tabSpec2);

        // 添加第3个标签页
        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("tabpage1");
        tabSpec3.setIndicator("第一个页面", getResources().getDrawable(R.drawable.test01));
        tabSpec3.setContent(R.id.tabpage3);
        tabHost.addTab(tabSpec3);

        // 设置显示为那一个标签页,此处的位置是标签页放置的顺序,从0开始,和标签页的id无关
        tabHost.setCurrentTab(0);
    }
}
