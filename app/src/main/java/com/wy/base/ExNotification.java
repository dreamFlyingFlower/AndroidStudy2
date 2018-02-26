package com.wy.base;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RemoteViews;

import com.wy.R;

import org.xutils.view.annotation.ContentView;

@ContentView(R.layout.activity_ex_notification)
public class ExNotification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
