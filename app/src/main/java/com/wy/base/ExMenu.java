package com.wy.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.wy.R;

/**
 * 3种菜单:options菜单,手机上的菜单键点击出现的菜单,context menu上下文菜单,pop弹出菜单
 * 一个菜单类,需要现在资源文件中新建一个menu文件夹,在文件中新建一个menu resourcexml文件
 * 根元素是menu,子元素是item或group
 *
 * 1.需要重写onCreateOptionsMenu方法,这个方法只会调用一次,这种方法弹出的菜单是在屏幕下方
 * 2.活动的菜单,在原来的基础上需要调用registerForContextMenu方法,并在里面
 * 3.弹出菜单,单击某个按钮或某个组件的时候弹出菜单,网上查找
 * 4.menu的showasaction属性需要注意
 */
public class ExMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_menu);
        // 创建一个数据显示列表
        ListView listView = (ListView)findViewById(R.id.listView);
        // 在组件中加入数据
        listView.setAdapter(null);
        // 创建上下文菜单
        registerForContextMenu(listView);
    }

    /**
     * 上下文菜单,这种菜单只有在长按上下文的数据时才会出现
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuinfo) {
        //填充选项菜单,读取xml文件
        getMenuInflater().inflate(R.menu.test,menu);
        super.onCreateContextMenu(menu,v,menuinfo);
    }

    /**
     * 上下文菜单选中事件
     * @param item
     * @return
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.test01:
                Toast.makeText(this,"test01",Toast.LENGTH_SHORT);
                break;
            case R.id.test02 :
                Toast.makeText(this,"test02",Toast.LENGTH_SHORT);
                break;
            case R.id.test03 :
                Toast.makeText(this,"test03",Toast.LENGTH_SHORT);
                break;
            case R.id.test04 :
                Toast.makeText(this,"test04",Toast.LENGTH_SHORT);
                break;
            case R.id.test05 :
                Toast.makeText(this,"test05",Toast.LENGTH_SHORT);
                break;
            default:break;

        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 加载options菜单选项
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //填充选项菜单,读取xml文件
        getMenuInflater().inflate(R.menu.test,menu);
        // 动态添加菜单项
        // 组别编号,菜单项编号,排序,标题
//        menu.add(1,1,100,"项目1");
//        menu.add(1,2,200,"项目2");
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 固定菜单,选中某个菜单的时候需要做的操作
     * 当选中某个options菜单的时候需要做的操作
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.test01:
                Toast.makeText(this,"test01",Toast.LENGTH_SHORT);
                break;
            case R.id.test02 :
                Toast.makeText(this,"test02",Toast.LENGTH_SHORT);
                break;
            case R.id.test03 :
                Toast.makeText(this,"test03",Toast.LENGTH_SHORT);
                break;
            case R.id.test04 :
                Toast.makeText(this,"test04",Toast.LENGTH_SHORT);
                break;
            case R.id.test05 :
                Toast.makeText(this,"test05",Toast.LENGTH_SHORT);
                break;
            default:break;

        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 弹出菜单
     * @param view
     */
    public void popMenu(View view){
        PopupMenu popupMenu = new PopupMenu(this,view);
        MenuInflater menuInflater = popupMenu.getMenuInflater();
        menuInflater.inflate(R.menu.test,popupMenu.getMenu());
        popupMenu.show();
    }
}
