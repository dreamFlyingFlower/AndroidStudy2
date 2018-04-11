package com.wy.base;

import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.wy.R;

import java.io.File;
import java.io.IOException;

/**
 * surfaceView是用来画图的控件,可以用来显示视频
 * 但是播放视频的主要方法废弃了,需要网上重新需找
 * FIXME
 */
public class ExSurface extends AppCompatActivity {

    SurfaceView sv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_surface);
        /**
         * 视频的播放和音频的播放差不多,但是有些不同的设置,此处只写视频的一些配置和surfaceView
         * 若是需要对视频的播放进行控制,参考ExMedia类
         * 这里写一个视频录制的功能
         */
        sv = (SurfaceView) findViewById(R.id.surfaceView);
        // 已经废弃的老方法,那么只能在网上找新的视频播放方法了
        // 把输送给sc的视频画面直接显示到屏幕上,不要维持它自身的缓冲区
        sv.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        // 设置分辨率
        sv.getHolder().setFixedSize(176,144);
        // 保持屏幕常亮
        sv.getHolder().setKeepScreenOn(true);
        //
    }

    /**
     * 重写触摸屏幕的方法
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 当触摸屏幕的时候是按下
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            // do something(); 
        }
        return super.onTouchEvent(event);
    }

    // 视频录制的类
    private MediaRecorder mr = new MediaRecorder();

    /**
     * 录制视频
     * @param v
     */
    public void record(View v) throws IOException {
        // 采集声音,来自于麦克风
        mr.setAudioSource(MediaRecorder.AudioSource.MIC);
        //指定制品的采集来源,来源于摄像头
        mr.setAudioSource(MediaRecorder.VideoSource.CAMERA);
        //设置视频的输出格式
        mr.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        //设置视频的大小
        mr.setVideoSize(320,240);
        // 设置捕捉视频的帧数,帧数越大越清晰
        mr.setVideoFrameRate(5);
        // 设置声音的编码
        mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        // 设置视频的编码
        mr.setVideoEncoder(MediaRecorder.VideoEncoder.H264);
        // 设置文件输出的位置
        mr.setOutputFile(new File(Environment.getExternalStorageDirectory(),"filename").getAbsolutePath());
        // 设置预览显示,将视频显示到surfaceV上
        mr.setPreviewDisplay(sv.getHolder().getSurface());
        //进行缓冲
        mr.prepare();
        // 开始刻录
        mr.start();
    }
}
