package com.wy.base;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wy.R;

/**
 * 包信息管理类
 */
public class ExPackage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_package);

        // 获得所有的包信息
        PackageManager pm = getPackageManager();
        try {
            // 从所有信息中获得当前包的信息,通过activity
            PackageInfo pi = pm.getPackageInfo(getPackageName(),PackageManager.GET_ACTIVITIES);
            // 获得版本号,其他方法等
            int versionCode = pi.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
