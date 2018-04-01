package com.wy.sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by wanyang on 2018/4/1.
 */

/**
 * 直接操作数据库,不需要继承ContentProvider
 * 此种操作数据不能共享,即其他应用中无法直接调用数据库
 */
public class DBService {

    private DBUtils dbUtils;

    public DBService(Context context){
        this.dbUtils = new DBUtils(context,"test,db",null,1);
    }

    public void add(){
        SQLiteDatabase writableDatabase = dbUtils.getWritableDatabase();
    }
}
