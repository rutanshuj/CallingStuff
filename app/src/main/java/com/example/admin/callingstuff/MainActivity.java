package com.example.admin.callingstuff;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    private NotificationCompat.Builder builder;
    private NotificationManager notificationManager;
    private int anInt;
    private RemoteViews remoteViews;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startService(View view){
        Intent i = new Intent(MainActivity.this, Service.class);
        startService(i);
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        PhoneStateListener phoneStateListener = new PhoneStateListener(){
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                String number = incomingNumber;
                Log.d("gaandu", number);
                if(state == TelephonyManager.CALL_STATE_RINGING){
                    Toast.makeText(MainActivity.this, "incoming call from" + incomingNumber, Toast.LENGTH_SHORT).show();
                    context = getApplicationContext();

                    anInt = (int) System.currentTimeMillis();
                    notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    remoteViews = new RemoteViews(getPackageName(), R.layout.custom_notification);
                    remoteViews.setTextViewText(R.id.notif_text, "Someone is breaching your account");

                    Intent intent = new Intent("button_clicked");
                    intent.putExtra("id", anInt);

                    PendingIntent p_button_intent = PendingIntent.getBroadcast(context, 123, intent, 0);
                    remoteViews.setOnClickPendingIntent(R.id.nb, p_button_intent);
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
                if(state == TelephonyManager.CALL_STATE_OFFHOOK){
                    Toast.makeText(MainActivity.this, "Phone is currently in a call", Toast.LENGTH_SHORT).show();
                }
                if(state == TelephonyManager.CALL_STATE_IDLE){
                    Toast.makeText(MainActivity.this, "Phone is neither Ringing nor in a Call", Toast.LENGTH_SHORT).show();
                }
            }
        };
        telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
    }
    public void stopService(View view){
        Intent i = new Intent(MainActivity.this, MyService.class);
        stopService(i);
    }
}
