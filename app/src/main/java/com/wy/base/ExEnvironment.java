package com.wy.base;

import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wy.R;

import java.io.File;

/**
 * 系统自带的环境类Environment,可用来查找SD卡等
 */
public class ExEnvironment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_environment);

        // 判断SD卡是否挂载在手机上的状态,
        String state = Environment.getExternalStorageState();
        // 如果挂载了sd卡并且可读写,具体查看android的文档
        if(Environment.MEDIA_MOUNTED.equals(state)){
            // 获得sd卡的根目录
            File file = Environment.getExternalStorageDirectory();
            // 利用流对文件进行读写
        }
    }
}
