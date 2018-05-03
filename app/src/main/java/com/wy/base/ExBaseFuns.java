package com.wy.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
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
 * 自定义适配器,继承BasicAdapter,网上查找
 * 使用progressDialog,进度条,网上查找
 * ViewFlipper的使用,activity之间的切换
 * ImageSwitcher和TextSwitcher,图片,文本之间的切换,如幻灯片
 * ExpandableList:listview的扩展组件,2级分组,如qq分组
 * GridView组件,和table一样,通常用来显示图片
 * ListView自定义方式,自定义apapter数据源
 * listView优化:使用ConvertView,使用ViewHolder来提高组件在容器中查找的效率
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
         *  意图,activity之间的切换,启动一个activity有4种模式
         *  Intent的组成部分:component组件,目的组件;action动作,用来表现意图的行动;
         *  category类别,用来表现动作的类别;data数据;type数据类型,对data返利的描写;extras扩展信息;
         *  flags标志位,期望这个意图的运行方式
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

        // 相当于打开一个网页,结合type使用(type就是contenttype的mime类型)也可打开其他类型的文件
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.parse("http://www.baidu.com");
        intent.setData(uri);
        startActivity(intent);

        // 拿到图片的字节数组之后显示到acitvity中,字节数组可以通过各种方式拿到
        // bitmap是位图,可以有多种方式显示图片
        byte[] bs = new byte[1024];
        Bitmap bitmap = BitmapFactory.decodeByteArray(bs,0,bs.length);
        iv.setImageBitmap(bitmap);

        // 销毁当前的activity
        finish();

        // 元素的visibility中的gone表示开始不可见

        // 启动一个service
        Intent service = new Intent(this,ExService.class);
        startService(service);

        //通过bindservice启动一个service,服务链接对象,是回调函数,绑定服务的标记
        bindService(service, new ServiceConnection() {
            /**
             * 绑定成功服务的回调方法
             * @param name
             * @param service
             */
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {

            }

            /**
             * 断开链接或服务异常的时候调用方法,解除绑定的时候不会调用
             * @param name
             */
            @Override
            public void onServiceDisconnected(ComponentName name) {

         }
        }, Context.BIND_AUTO_CREATE);

        /**
         * 解除绑定
         */
        unbindService(new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        });
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

    /**
     * 一个activity的生命周期
     * onCreate:当activity被创建时调用,相当于初始化,之后必然会调用onStart
     * onStart:当activity可看见时被调用,之后会调用onResume或onStop
     * onRestart:当activity重新可见的时候被调用,之后一定会调用onStart
     * onResume:被onStart调用,此时acticity可见,之后可调用onPause
     * onPause:activity被放到后台进程中,当内存不足时可能会被kill,之后会调用onStop或onResume
     * onStop:activity完全不可见调用,当内存不足时可能会被kill
     * onDestory:销毁时调用,被系统kill
     */
}
