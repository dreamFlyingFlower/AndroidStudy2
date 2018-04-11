package com.wy.base;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.wy.R;

/**
 * Created by wanyang on 2018/4/8.
 * android的一些基本方法
 * 与之交互的是Exchange中的方法
 * FIXME
 */
public class ExBaseFuns extends AppCompatActivity {

    private ImageView iv;

    // 当切换到本activity时会首先调用onCreate方法
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // 创建实例
        super.onCreate(savedInstanceState);
        // 需要在setContentView之前调用才有效
        // 窗口无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 当前窗口全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // 显示activity
        setContentView(R.layout.activity_base);

        /**
         *  意图,activity之间的切换
         */
        Intent intent = new Intent(ExBaseFuns.this,ExChange.class);
        // 或者另外一种方式
        // Intente intent = new Intent();
        // intent.setClass(this,BaseActivity.class);
        // 当需要给下一个activity中传递参数时,可以使用intent.putExtra往其中插入数据
        intent.putExtra("test1","test1");
        // Bundle类似于Map,键值对,android可传bundle但不能传递map
        Bundle bundle = new Bundle();
        bundle.putString("map1","map1");
        intent.putExtra("bundle",bundle);
        // 或者直接将bundle数据添加到方法中
        intent.putExtras(bundle);
        // 跳到intent中指定的下一个activity
        startActivity(intent);

        /**
         * 跳到下一个activity,但是需要等待下一个activity做某些处理,再返回到本activity时
         * 不能使用startActivity,需要使用
         */
        // 跳到下一个activity处理,处理完之后返回携带的数据
        // 第二个参数是本activity的识别码,用于当下一个activity处理完数据之后找到本activity,可自定义
        startActivityForResult(intent,10000);

        // 拿到图片的字节数组之后显示到acitvity中,字节数组可以通过各种方式拿到
        // bitmap是位图,可以有多种方式显示图片
        byte[] bs = new byte[1024];
        Bitmap bitmap = BitmapFactory.decodeByteArray(bs,0,bs.length);
        iv.setImageBitmap(bitmap);

        // 销毁当前的activity
        finish();

        // 元素的visibility中的gone表示开始不可见
    }

    /**
     * 当需要在其他页面对数据进行处理,并且得到其他页面处理后的结果时,必须重写该方法
     * 需要结合startActivityForResult方法一起使用
     * @param requestCode 调用startActivityForResult方法中传递的code码,此处相当于10000
     * @param resultCode 其他activity处理完数据返回结果时的code码,此处为10001
     * @param data 其他activity处理完的数据
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
