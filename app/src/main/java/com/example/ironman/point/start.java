package com.example.ironman.point;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import java.util.logging.LogRecord;

import static com.example.ironman.point.R.layout.start;

/**
 * Created by Ironman on 2015/11/13.
 */
public class start extends Activity

{
   private Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        setContentView(start);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(start.this, login.class);
                startActivity(intent);
            }
        }, 2500);
}}