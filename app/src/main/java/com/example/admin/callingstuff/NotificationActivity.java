package com.example.admin.callingstuff;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {

    private NotificationCompat.Builder builder;
    private NotificationManager notificationManager;
    private int anInt;
    private RemoteViews remoteViews;
    private Context context;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        context = this;
        button = (Button) findViewById(R.id.show_notiff);

        anInt = (int) System.currentTimeMillis();
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        remoteViews = new RemoteViews(getPackageName(), R.layout.custom_notification);
        remoteViews.setTextViewText(R.id.notif_text, "Someone is breaching your account");

        Intent intent = new Intent("button_clicked");
        intent.putExtra("id", anInt);

        PendingIntent p_button_intent = PendingIntent.getBroadcast(context, 123, intent, 0);
        remoteViews.setOnClickPendingIntent(R.id.nb, p_button_intent);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(context, MainActivity.class);

                PendingIntent pendingIntent = PendingIntent.
                        getActivity(context, 0, intent1, 0);
                builder = new NotificationCompat.Builder(context);
                builder.setSmallIcon(R.mipmap.ic_launcher)
                        .setAutoCancel(true)
                        .setCustomContentView(remoteViews)
                        .setContentIntent(pendingIntent);

                notificationManager.notify(anInt,builder.build());
            }
        });
    }
}
