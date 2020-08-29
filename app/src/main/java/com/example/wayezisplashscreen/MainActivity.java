package com.example.wayezisplashscreen;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class MainActivity extends Activity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(this, R.raw.nastnigh);

        SurfaceView sv = (SurfaceView) findViewById(R.id.surfaceView2);
        SurfaceHolder holder = sv.getHolder();
        holder.addCallback(new Callback(){
            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) { }

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mp.setDisplay(holder);
                mp.start();
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) { }
        });

    }

    @Override
    protected void onPause(){
        super.onPause();

        if(null != mp) mp.release();
        mp = null;
    }
}abc