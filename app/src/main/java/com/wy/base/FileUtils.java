package com.wy.base;

import android.content.Context;

import org.xutils.common.util.FileUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;

/**
 * Created by wanyang on 2018/4/1.
 */

public class FileUtils {
    private Context context;

    public FileUtils(Context context){
        this.context = context;
    }

    public boolean save(String name,String content){
        try{
            // context的MODE_PRIVATE等模式,private是只能本app访问,并且同文件会覆盖写入
            // MODE_APPEND追加写入
            FileOutputStream fos = context.openFileOutput(name,Context.MODE_PRIVATE);
            // 写入数据
            fos.write(content.getBytes(Charset.forName("UTF8")));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
