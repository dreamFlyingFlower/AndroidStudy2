package com.wy.sqllite;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by wanyang on 2018/3/31.
 */

/**
 * SharedPreferences类是用来存贮数据的,存在一个xml文件中,该文件会放在data/data的该项目中
 *
 */
public class SharedPrefence extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 往文件中写入值,第二个参数是写入的模式,MODE_PRIVATE指定私有用户id,MODE_WORLD_READABLE,所有应用可读
        // MODE_WORLD_WRITEABLE所有人可写
        SharedPreferences sp = this.getSharedPreferences("文件名",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("test","test");
        editor.commit();
        // 获得该文件中的值,若没有则给默认值
        sp.getString("test","rrrrr");
    }
}
