package com.tnta.superfish.superfish;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

    private static final String TAG = GamePanel.class.getName();

    private MainThread mainThread;
    ParallaxBackground background;

    public GamePanel(Context context) {
        super(context);

        getHolder().addCallback(this);
        mainThread = new MainThread(getHolder(),this);
        setFocusable(true);

        background = new ParallaxBackground(this.getResources());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        canvas.drawColor(getResources().getColor(R.color.background_color));
        background.doDrawRunning(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        mainThread.setRunning(true);
        mainThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        if(mainThread.isAlive())
            mainThread.setRunning(false);
    }

    public void resume() {
        mainThread.setRunning(true);
        mainThread =new MainThread(getHolder(),this);
    }

    public void pause() {
        mainThread.setRunning(false);
        boolean retry = true;
        while (retry) {
            try {
                mainThread.join();
                retry = false;
            } catch (InterruptedException e) {
                Log.e(TAG, e.toString());
            }
        }
    }
}
