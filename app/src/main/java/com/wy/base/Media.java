package com.wy.base;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.wy.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.IOException;

/**
 * 媒体类
 * 要在资源文件中新建一个raw的文件,并且放入其中的媒体文件名不能有大写,只能都是小写
 * 媒体文件必须是没有损坏的,系统能识别的
 */
@ContentView(R.layout.activity_media)
public class Media extends AppCompatActivity {

    MediaPlayer mp = null;

    @ViewInject(R.id.playMedia)
    private Button playMedia;
    @ViewInject(R.id.playStop)
    private Button playStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    @Event(R.id.playMedia)
    private void playMedia(View view){
        // 播放放在资源文件中的媒体文件
        mp = MediaPlayer.create(getApplicationContext(),R.raw.test);
        // 播放sdk文件中的资源
        try {
            MediaPlayer mp1 = new MediaPlayer();
            mp1.setDataSource("/sdcard/test.mp3");
            mp1.prepare();
            mp1.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(mp.isPlaying()) {
            mp.stop();
        }
        mp.start();
    }

    @Event(R.id.playStop)
    private void playStop(View view){
        if (mp != null){
            mp.stop();
        }
    }
}
