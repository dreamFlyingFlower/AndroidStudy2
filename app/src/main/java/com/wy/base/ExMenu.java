package com.wy.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.wy.R;

/**
 * 3种菜单:options菜单,手机上的菜单键点击出现的菜单,context menu上下文菜单,pop弹出菜单
 * 一个菜单类,需要现在资源文件中新建一个menu文件夹,在文件中新建一个menu resourcexml文件
 * 根元素是menu,子元素是item或group
 *
 * 需要重写onCreateOptionsMenu方法,这个方法只会调用一次
 */
public class ExMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_menu);

        // 注册上下文菜单,需要绑定在一个view上
        registerForContextMenu(null);
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
     * 上下文菜单,创建上下文菜单
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.test,menu);
    }

    /**
     * 上下文菜单项目响应事件
     * @param item
     * @return
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
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
