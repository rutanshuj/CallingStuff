package com.example.admin.callingstuff;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;


public class MyService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }
    @Override
    public void onDestroy() {

        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_SHORT).show();

    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
