package com.example.janhon.bonusrunningbeforeyou.Running;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
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

import io.fabric.sdk.android.Fabric;

// CP102 陳建宏
public class RunningDataActivity extends FragmentActivity {
    Long mRecordTime ;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_running_data);
        Chronometer text_timer = findViewById(R.id.text_timer);
        text_timer.setBase(SystemClock.elapsedRealtime());
        text_timer.start();
        enableDebugMode();
        enableAtRuntime();
        //Crashlytics.log(Log.DEBUG, "tag", "message");
        Button button = findViewById(R.id.btPause);
        Button button1 =  findViewById(R.id.btPlay);
        button1.setVisibility(button1.GONE);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onPauseClick(v);
            }
        });
    }


    public void onPauseClick(View view) {
        Chronometer text_timer = findViewById(R.id.text_timer);
        text_timer.stop();
        mRecordTime = SystemClock.elapsedRealtime();
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
    }
}
