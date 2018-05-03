package com.wy.sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tinkpad X220 on 2018/3/29.
 * LoadManager的使用,异步加载数据
 */

public class DBUtils extends SQLiteOpenHelper {

    /**
     * 继承基础数据库类
     * @param name 数据库名,如test.db
     * @param factory 游标工厂,可传null
     * @param version 版本
     */
    public DBUtils(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * 当创建dbutils实例时,会调用方法创建表,但只会调用一次
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE test(account VARCHAR(20),password VARCHAR(20))";
        db.execSQL(sql);
    }

    /**
     * 数据库版本文件发生变化的时候调用
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}