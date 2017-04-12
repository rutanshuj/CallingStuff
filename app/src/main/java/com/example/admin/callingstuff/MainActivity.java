package com.example.admin.callingstuff;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startService(View view){
        Intent i = new Intent(MainActivity.this, MyService.class);
        startService(i);
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        PhoneStateListener phoneStateListener = new PhoneStateListener(){
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                String number = incomingNumber;
                Log.d("gaandu", number);
                if(state == TelephonyManager.CALL_STATE_RINGING){
                    Toast.makeText(MainActivity.this, "incoming call from" + incomingNumber, Toast.LENGTH_SHORT).show();
//                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
//                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
                    Intent intent = new Intent(getApplicationContext(), Activity2.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
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
