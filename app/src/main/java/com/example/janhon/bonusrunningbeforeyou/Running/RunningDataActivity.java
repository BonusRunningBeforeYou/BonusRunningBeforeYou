package com.example.janhon.bonusrunningbeforeyou.Running;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
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
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import com.example.janhon.bonusrunningbeforeyou.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import java.util.Locale;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;


import io.fabric.sdk.android.Fabric;

// CP102 陳建宏
public class RunningDataActivity extends FragmentActivity {
    Long mRecordTime ;
    private OdometerService odometer; //用它來代表OdometerService.
    private boolean bound = false; //用它來儲存activity是否綁定服務.
    private RunningFragment runningFragment;

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
            handler.postDelayed(this, 5000);
        }
    };

    Handler handler1 = new Handler();
    Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            if (bound && odometer != null) {
                runningFragment.draw2D();
            }
            handler1.postDelayed(this, 250000);
        }
    };


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

        initContent();

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
        //displayDraw2D();  劃線功能尚未完成,先關閉,
    }

    private void changeFragment(Fragment fragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.body, fragment);
        fragmentTransaction.commit();

    }

    private void initContent() {
        Fragment fragment = new RunningFragment();
        changeFragment(fragment);
        //setTitle(R.string.tsStart);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, OdometerService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE); //在activity啟動時綁定服務.
        Button button =  findViewById(R.id.btSubmit);
        button.setVisibility(button.GONE);


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
        if (bound) {
            unbindService(connection); //在activity停止時解除服務綁定.
            bound = false;
        }

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

        Intent intent = new Intent(this, OdometerService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE); //在activity啟動時綁定服務.

    }

    private void displayDistance() {
        handler.post(runnable);  //計算里程
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
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
        if (bound) {
            unbindService(connection); //在activity停止時解除服務綁定.
            bound = false;
        }
        return true;
    }

    private void displayDraw2D() {
        handler1.post(runnable1);  //計算里程
    }

}

