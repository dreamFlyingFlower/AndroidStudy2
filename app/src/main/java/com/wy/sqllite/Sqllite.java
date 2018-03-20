package com.wy.sqllite;

/**
 * Created by wanyang on 2018/2/26.
 */

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * content uri资源定位符
 * 固定格式content://com.wy.sqllite/user/12  content://固定格式,后面接唯一标识,user代表数据库,12代表数据中的id
 * user可以没有,则访问所有数据库,12没有则访问user中所有数据
 * 在manif文件中需要注册,注册的name就是继承了contentprovider的路劲
 * content://media/internal/images 这个uri可以返回设备上存储的所有图片
 * content://contacts/people 返回设备上所有的联系人
 * content://contancs/people/45 返回设备上id为45的联系人
 */
public class Sqllite extends ContentProvider {
    //    初始化
    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
