package com.wy.base;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RemoteViews;

import com.wy.R;

import org.xutils.view.annotation.ContentView;

/**
 * 通知的使用
 */
@ContentView(R.layout.activity_ex_notification)
public class ExNotification extends AppCompatActivity {

    private Notification.Builder builder;

    private NotificationManager nm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 创建通知
        builder = new Notification.Builder(this);
        // 创建通知管理者
        nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        // 设置通知,至少要有一个小图标,一个标题,内容
        builder.setTicker("通知");
        builder.setContentText("这是内容");
        builder.setSmallIcon(R.drawable.test01);
        builder.setContentTitle("这是标题");
        // 设置默认的震动或铃声
        builder.setDefaults(Notification.DEFAULT_SOUND|Notification.DEFAULT_VIBRATE);
        // 启动一个通知,第一个参数是标识符,当有多个相同id,后面的会覆盖前面的通知
        nm.notify(1001,builder.build());
    }

    /**
     * 取消通知,cancel传通知的标识符
     */
    private void cancelNotifis() {
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.cancel(0);
    }

    /**
     * 当点击通知的时候触发事件
     */
    private void operate() {
        //从一个activity跳到另外一个activity
        Intent intent = new Intent(ExNotification.this, ExEvent.class);
        // 可以从多种组件启动,可以是service,activity等
        // 上下文,私有的标识符,当前意图,何时收到这个通知
        PendingIntent pendingIntent = PendingIntent.getActivity(
                ExNotification.this, 0, intent,
                PendingIntent.FLAG_CANCEL_CURRENT);
        RemoteViews contentViews = new RemoteViews(getPackageName(),
                R.layout.activity_ex_notification);
        // 创建一个通知,图标,短信息,标识符
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                ExNotification.this).setSmallIcon(R.drawable.test01)
                .setContentTitle("My notification")
                .setTicker("new message");
        mBuilder.setAutoCancel(true);
        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setContent(contentViews);
        mBuilder.setAutoCancel(true);
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.notify(10, mBuilder.build());
    }
}
