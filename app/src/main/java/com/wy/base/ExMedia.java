package com.wy.base;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PagerSnapHelper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wy.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;
import java.io.IOException;

import static android.R.attr.path;

/**
 * 媒体类
 * 要在资源文件中新建一个raw的文件,并且放入其中的媒体文件名不能有大写,只能都是小写
 * 媒体文件必须是没有损坏的,系统能识别的
 * FIXME
 */
@ContentView(R.layout.activity_media)
public class ExMedia extends AppCompatActivity {

    MediaPlayer mp = null;

    @ViewInject(R.id.playMedia)
    private Button playMedia;
    @ViewInject(R.id.playStop)
    private Button playStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        //获得对话的监听
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        // 监听电话的状态变化
        tm.listen(new PhoneCustomListener(), PhoneStateListener.LISTEN_CALL_STATE);
    }

    /**
     * 继承电话监听类,实现自己的方法
     */
    private class PhoneCustomListener extends PhoneStateListener{
        // 当电话的状态发生改变时,会调用该方法
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            switch (state){
                case TelephonyManager.CALL_STATE_RINGING://电话来了
                    if(mp.isPlaying()){
                        seek = mp.getCurrentPosition();//取得播放位置
                        mp.stop();
                    }
                    break;
                case TelephonyManager.CALL_STATE_IDLE://电话打完了
                    if(seek > 0 && audioPath != null){
                        play(seek);
                        mp.seekTo(seek);
                        seek=0;
                    }
                    break;
            }
        }
    }

    private int seek=0;

//    利用onPause和onResume方法会让播放器在只要不是最顶端应用的时候,都会被中断
//    需要只在有电话来电的时候中断,其他应用覆盖播放器的时候不中断
//    此时需要监听电话的状态来判断是否停止播放,而不是只要其他应用覆盖播放器就暂停
    /**
     * 当应用暂停或被其他应用覆盖的时候,必然调用onPause
     * 需要停止播放器,记住停止之前的位置,利用seekto
     */
    @Override
    public void onPause(){
        if(mp.isPlaying()){
            seek = mp.getCurrentPosition();//取得播放位置
            mp.stop();
        }
        super.onPause();
    }

    /**
     * 当应用再回复到前台最顶端时,必然会调用onResume方法,继续播放音乐
     */
    @Override
    public void onResume(){
        if(seek > 0 && audioPath != null){
            play(seek);
            seek=0;
        }
        super.onResume();
    }

    /**
     * 循环播放
     * @param view
     */
    @Event(R.id.playMedia)
    private void playMedia(View view){
        // 播放放在资源文件中的媒体文件
        mp = MediaPlayer.create(getApplicationContext(),R.raw.test);
        // 监听播放是否完成,进行循环播放
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
                mp.setLooping(true);
            }
        });
        // 播放sdk文件中的资源
//        try {
//            MediaPlayer mp1 = new MediaPlayer();
//            mp1.setDataSource("/sdcard/test.mp3");
//            mp1.prepare();
//            mp1.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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

    private String audioPath;
    /**
     * 另外一种开始播放
     * @param view
     */
    @Event(R.id.playMedia)
    private void beginPaly(View view){
        // 默认在sdk卡的根目录寻找文件
        File audio = new File(Environment.getExternalStorageDirectory(),"filename");
        if(audio.exists()){
            audioPath = audio.getAbsolutePath();
            play(0);
        }else{
            Toast.makeText(ExMedia.this,"文件没找到",Toast.LENGTH_SHORT).show();
        }
    }

    private void play(int seek) {
        try{
            mp.reset();//把各项参数恢复到初始状态,便于循环播放
            mp.setDataSource(audioPath);//设置播放资源
            mp.prepare();//进行缓冲
            mp.setOnPreparedListener(new PrepareListener(seek));//监听文件是否缓冲完成
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 需要一个实现了MediaPlayer.OnPreparedListener的类来对完成缓冲的文件进行处理
     */
    private class PrepareListener implements MediaPlayer.OnPreparedListener{
        private Integer seek;

        public PrepareListener(int seek) {
            this.seek = seek;
        }

        // 缓冲完毕之后调用该方法
        @Override
        public void onPrepared(MediaPlayer mp) {
            mp.start();//开始播放
            if(seek > 0 && audioPath != null) {
                mp.seekTo(seek);
            }
        }
    }

    private boolean isPause = false;//是否处于暂停状态,true是
    /**
     * 暂停,需要判断是否已经暂停,需要一个标志位,同时需要改变暂停按钮上的文字,此处不做处理
     */
    private void playPause(){
        if(mp.isPlaying()){//正在播放
            mp.pause();
            isPause=true;
        }else{
            if(isPause){
                mp.start();
            }
        }
    }

    /**
     * 重新开始播放
     */
    private void playAgain(){
        if(mp.isPlaying()){//正在播放
            mp.seekTo(0);//从开始位置播放音乐
    }else{
            if(audioPath != null){
                play(0);
            }
        }
    }

    /**
     * 停止播放
     */
    private void playStopIt(){
        if(mp.isPlaying()){//正在播放
            mp.stop();
        }
    }
}
