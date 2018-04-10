package com.wy.base;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.wy.R;

/**
 * Created by wanyang on 2018/4/8.
 * FIXME
 */

public class ExBaseFuns extends AppCompatActivity {

    private ImageView iv;

    // 当切换到本activity时会首先调用onCreate方法
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // 创建实例
        super.onCreate(savedInstanceState);
        // 显示activity
        setContentView(R.layout.activity_base);

        // 意图,activity之间的切换
        Intent intent = new Intent(ExBaseFuns.this,BaseActivity.class);
        // 当需要给下一个activity中传递参数时,可以使用intent.putExtra往其中插入数据
        intent.putExtra("test1","test1");
        // Bundle类似于Map,键值对,android可传bundle但不能传递map
        Bundle bundle = new Bundle();
        bundle.putString("map1","map1");
        intent.putExtra("bundle",bundle);
        // 获得intent中的数据
        String test1 = intent.getStringExtra("test1");
        Bundle bundle1 = intent.getBundleExtra("bundle");

        // 拿到图片的字节数组之后显示到acitvity中,字节数组可以通过各种方式拿到
        // bitmap是位图,可以有多种方式显示图片
        byte[] bs = new byte[1024];
        Bitmap bitmap = BitmapFactory.decodeByteArray(bs,0,bs.length);
        iv.setImageBitmap(bitmap);
    }
}
