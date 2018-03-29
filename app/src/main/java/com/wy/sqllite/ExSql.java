package com.wy.sqllite;

import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wy.R;

public class ExSql extends AppCompatActivity {
    private static final String DB_TEST = "content://com.wy.sqllite.provider/test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_sql);
    }

    private void add(){
        // 在普通activity中调用基础的Sqllite类,直接利用getContentResolver()方法
        Uri uri = Uri.parse(DB_TEST);
        // 插入到数据库的参数
        ContentValues cv = new ContentValues();
        cv.put("name","3ewrew");
        // 插入数据库
        getContentResolver().insert(uri,cv);
    }
}