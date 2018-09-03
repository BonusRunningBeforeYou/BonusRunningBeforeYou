package com.example.janhon.bonusrunningbeforeyou.Running;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;
import com.example.janhon.bonusrunningbeforeyou.R;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.Locale;

import io.fabric.sdk.android.Fabric;

// CP102 陳建宏
public class RunningDataActivity extends FragmentActivity {
    Long mRecordTime ;
    private OdometerService odometer; //用它來代表OdometerService.
    private boolean bound = false; //用它來儲存activity是否綁定服務.
    Handler handler = new Handler();
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            double distance = 0.0;
            if (bound && odometer != null) {
                distance = odometer.getDistance();
            }
            String distanceStr = String.format(Locale.getDefault(), "%1$,.2f KM", distance);
            TextView distanceView = findViewById(R.id.kiloMeter);
            distanceView.setText(distanceStr);
            handler.postDelayed(this, 1000);
        }
    };

    public void enableDebugMode() {
        // [START crash_enable_debug_mode]
        final Fabric fabric = new Fabric.Builder(this)
                .kits(new Crashlytics())
                .debuggable(true)  // Enables Crashlytics debugger
                .build();
        Fabric.with(fabric);
        // [END crash_enable_debug_mode]
    }

    public void enableAtRuntime() {
        // [START crash_enable_at_runtime]
        Fabric.with(this, new Crashlytics());
        // [END crash_enable_at_runtime]
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder binder) {
            OdometerService.OdometerBinder odometerBinder = (OdometerService.OdometerBinder) binder;
            odometer = odometerBinder.getOdometer(); //在連結服務時取得OdometerService的參考.
            bound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            bound = false;
        }

        @Override
        public void onBindingDied(ComponentName componentName) {

        }


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running_data);
        Chronometer text_timer = findViewById(R.id.text_timer);
        text_timer.setBase(SystemClock.elapsedRealtime());
        text_timer.start();
        enableDebugMode();
        enableAtRuntime();
        //Crashlytics.log(Log.DEBUG, "tag", "message"); //回傳當機時再啟用即可.
        Button button = findViewById(R.id.btPause);
        Button button1 =  findViewById(R.id.btPlay);
        button1.setVisibility(button1.GONE);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onPauseClick(v);
            }
        });

        displayDistance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, OdometerService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE); //在activity啟動時綁定服務.

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (bound) {
            unbindService(connection); //在activity停止時解除服務綁定.
            bound = false;
        }

    }

    public void onPauseClick(View view) {
        Chronometer text_timer = findViewById(R.id.text_timer);
        text_timer.stop();
        mRecordTime = SystemClock.elapsedRealtime(); //停止時間

        handler.removeCallbacks(runnable); //停止計算里程

        Button button = findViewById(R.id.btPause);  //將暫停鈕移除
        button.setVisibility(View.GONE);
        Button button1 = findViewById(R.id.btPlay);  //將繼續鈕置入
        button1.setVisibility(View.VISIBLE);

        StopRunningFragment stopRunningFragment = new StopRunningFragment();
        stopRunningFragment.show(getSupportFragmentManager(), "missiles");


    }

    public void onPlayClick(View view) {
        Chronometer text_timer = findViewById(R.id.text_timer);
        if (mRecordTime != 0) {
            text_timer.setBase(text_timer.getBase() + (SystemClock.elapsedRealtime() - mRecordTime));
        } else {
            text_timer.setBase(SystemClock.elapsedRealtime());
        }
        text_timer.start();
        Button button1 = findViewById(R.id.btPlay);
        button1.setVisibility(View.GONE);
        Button button =  findViewById(R.id.btPause);
        button.setVisibility(View.VISIBLE);

        handler.post(runnable);  //繼續計算里程

    }

    private void displayDistance() {

        handler.post(runnable);  //計算里程
    }

}
