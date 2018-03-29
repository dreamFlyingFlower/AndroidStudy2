package com.wy.sqllite;

/**
 * Created by wanyang on 2018/2/26.
 */

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

/**
 * content uri资源定位符
 * 固定格式content://com.wy.sqllite.provider/user/12
 * content://固定格式,后面接唯一标识,user代表数据库,12代表数据中的id
 * user可以没有,则访问所有数据库,12没有则访问user中所有数据
 * 在manif文件中需要注册,注册的name就是继承了contentprovider的路劲
 * content://media/internal/images 这个uri可以返回设备上存储的所有图片
 * content://contacts/people 返回设备上所有的联系人
 * content://contancs/people/45 返回设备上id为45的联系人
 */
public class Sqllite extends ContentProvider {
    private static final String TAG="sqllite";
    SQLiteOpenHelper dbHelper = null;
    //    初始化
    @Override
    public boolean onCreate() {
        dbHelper = new DBUtils(getContext(),"test.db,",null,1);
        return true;
    }

    /**
     * 查询
     * @param uri 标识符
     * @param projection 需要拿到的字段名
     * @param selection where条件,可带?,也可写死
     * @param selectionArgs 对应where条件里的?
     * @param sortOrder 排序语句,如name desc
     */
    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection,
                        @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        // 获得uri后面的参数列表,从第一个斜杠后面的参数开始,若有表明,则第一个位置是表明,第二个位置是id
        List<String> segments = uri.getPathSegments();
        if (segments.size() > 1){
            for(String param : segments){
                Log.i(TAG,param);
            }
        }
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query("test", projection, selection, selectionArgs, null, null, sortOrder);
        cursor.moveToNext();
        StringBuffer sb = new StringBuffer();
        while(!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            cursor.moveToNext();
            sb.append(id);
            sb.append(name);
            Log.i(TAG,sb.toString());
        }
        cursor.close();
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {

        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        // 获得数据库访问
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        // 忘数据库中插入数据,返回插入后生成的id
        long rowid = database.insert("user", null, values);
        if(rowid > 0){
            // 将原始uri和生成的id拼接后返回
            Uri uri1 = ContentUris.withAppendedId(uri, rowid);
            // 通知其他应用数据改变
            getContext().getContentResolver().notifyChange(uri1,null);
            return uri1;
        }else{
            throw  new SQLException("数据插入失败");
        }
    }

    /**
     * 删除数据
     * @param uri 标识符,可从中拿到表名
     * @param selection where里面的条件,不带where,可带?,也可直接写死
     * @param selectionArgs ?对应的值,只能是字符串
     */
    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // 当?是字符串时可用占位符,若是为数字,则直接写死,参数传null
        int row = db.delete(selection, "name=?", selectionArgs);
        if(row > 0){
            Uri res = ContentUris.withAppendedId(uri,row);
            getContext().getContentResolver().notifyChange(res,null);
            return row;
        }
        return 0;
    }

    /**
     * 更新数据库
     * @param uri 标识符,可从中拿到表名
     * @param values 需要更新的内容
     * @param selection where里面的条件,不带where,可带?,也可直接写死
     * @param selectionArgs 对应问号的值,只能是字符串
     */
    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection,
                      @Nullable String[] selectionArgs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int update = db.update("test", values, selection, selectionArgs);
        if (update > 0){
            Uri res = ContentUris.withAppendedId(uri,update);
            getContext().getContentResolver().notifyChange(res,null);
            return update;
        }
        return 0;
    }
}