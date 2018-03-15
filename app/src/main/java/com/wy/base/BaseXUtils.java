package com.wy.base;

import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wy.R;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.x;

import java.io.File;


/**
 * xutils3学习类,https://github.com/wyouflf/xUtils3
 * xutils3最低兼容android4.0(api 14),主要分四个重要的模块：ViewUtils，HttpUtils，BitmapUtils，DbUtils
 * 更多使用参见:http://blog.csdn.net/tyk9999tyk/article/details/53306035
 */
@ContentView(R.layout.activity_base_xutils)
public class BaseXUtils extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在继承了AppCompatActivity的activity中使用xutils3必须先执行以下语句,在fragment中的使用参见basefragment
        x.view().inject(this);
    }

    //xutils3中断网络请求的方法
    public void cancelRequest(){
        //中断网络请求的方法
        // FIXME: 2018-3-15 不知道这个是什么用法,系统推荐使用,原字符串是/sdcard/download/icon.png
        String path= Environment.getExternalStorageDirectory().getPath();
        RequestParams params = new RequestParams("");
        params.setMultipart(true);
        params.addBodyParameter("file",new File(path));
        Callback.Cancelable post = x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
        //取消请求
        post.cancel();

    }

//    方法必须私有限定,
//    方法参数形式必须和type对应的Listener接口一致.
//    注解参数value支持数组: value={id1, id2, id3}
    //type默认是View.OnClickListener.class事件,所以可以不写
    @Event(type = View.OnClickListener.class,value= R.id.longTest)
    private void login(View view){
        Snackbar.make(view,"OnClickListener",Snackbar.LENGTH_SHORT).show();
    }
}
