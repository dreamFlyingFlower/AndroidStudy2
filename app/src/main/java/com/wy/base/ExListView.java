package com.wy.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wy.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * listview的使用,有2种,第一种是直接继承ApCompatActivity
 * 第二种是继承ListActivity,不需要布局文件,在加载数据源的时候可以使用系统的布局文件,也可以自定义
 */
@ContentView(R.layout.activity_ex_list_view)
public class ExListView extends AppCompatActivity
        implements AdapterView.OnItemClickListener,AbsListView.OnScrollListener{

    @ViewInject(R.id.listView)
    private ListView listView;

    // 数据源
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        // 注册监听事件
        listView.setOnItemClickListener(this);
        // 设置数据源适配器
        // layout可以用simple_list_item_1,也可以单选,多选
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,
                getResources().getStringArray(R.array.autocompletetext));
        // 设置单选或多选模式
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

        // 注册滚动监听事件
        listView.setOnScrollListener(this);

        // 通知适配器更新数据列表,之后会调用OnScrollListener里的方法
        adapter.notifyDataSetChanged();
    }

    /**
     * 列表单击事件
     * @param parent listview
     * @param view 当前点击的项
     * @param position 位置
     * @param id 编号
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


    /**
     * 监听滚动状态发生变化时的方法
     * @param view
     * @param scrollState 3种状态
     */
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if(scrollState == SCROLL_STATE_FLING){
            //手已经离开屏幕,但是还在滑动
        }
        if(scrollState == SCROLL_STATE_IDLE){
            // 停止状态
        }
        if(scrollState == SCROLL_STATE_TOUCH_SCROLL){
            // 正在滑动
        }
    }

    /**
     * 监听滚定的时候发生变化的方法
     * @param view
     * @param firstVisibleItem 第一个可见的item
     * @param visibleItemCount 可见的item的总数
     * @param totalItemCount 所有的item总数
     */
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
