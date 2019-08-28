package com.tnta.superfish.superfish;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by theanh on 1/23/16.
 */
public class MainThread extends Thread{

    private SurfaceHolder surfaceholder;
    private GamePanel gamepanel;
    private boolean running;

    //Dua GamePanel vao MainThread
    public MainThread(SurfaceHolder surfaceholder, GamePanel gamepanel)
    {
        this.surfaceholder=surfaceholder;
        this.gamepanel=gamepanel;
    }

    public void setRunning(boolean r)
    {
        //khi running = true se tao ra vong lap
        running=r;

    }

    public boolean getRunning(){
        return running;
    }

    @SuppressLint("WrongCall")

    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();
        //long dem=0L;
        Canvas canvas=null;
        while(running)
        {
            //1.cap nhat lai trang thai game //2.render du lieu ra man hinh
            canvas=surfaceholder.lockCanvas();
            if(canvas!=null)
            {
                gamepanel.onDraw(canvas);
                surfaceholder.unlockCanvasAndPost(canvas);
            }
            //Log.d("testloop", "loop "+ (dem++));
        }
    }
}
