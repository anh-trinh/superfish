package com.tnta.superfish.superfish;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

/*Buoc 1 Xay dung cau truc 2D
- Tao GamePanel.java extends SurfaceView implements SurfaceHolder.Callback
- Them getHolder().addCallback(this);
     setFocusable(true); vao constructor GamePanel
- Set man hinh, setContentView trong onCreate trong MainActivity
Buoc 2 Tao loop
- Tao class MainThread extends Thread
- Them code de chay Thread trong GamePanel.java
Buoc 3 Dua GamePanel vao MainThread
Buoc 4 Ve anh len vung Canvas
Buoc 5 Tao class Element
- Them Element vao GamePanel
Buoc 6 Lam nen
- Tao class ParallaxBackground
- Khai trong GamePanel
*/


public class MainActivity extends AppCompatActivity {

    public static Preferences preference;
    public static MediaPlayer bgmusic;
    GamePanel d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //cua so khong co thanh title
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //full man hinh
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        preference = new Preferences(getApplication());

        bgmusic = MediaPlayer.create(MainActivity.this, R.raw.bensound_funnysong_bg);
        bgmusic.setLooping(true);
        bgmusic.start();

        //tao doi tuong
        d = new GamePanel(this);
        setContentView(d);

        //setContentView(R.layout.activity_main);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);

        Handler mHandler = new Handler();
    }

    @Override
    protected void onResume() {
        super.onResume();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
        d.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //bgmusic.release();
        d.pause();
    }

    protected void onDestroy() {
        // TODO Auto-generated method stub

        super.onDestroy();
        Log.d("looptest", "huy thread");

    }
}
