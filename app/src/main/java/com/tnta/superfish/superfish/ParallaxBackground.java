package com.tnta.superfish.superfish;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

/**
 * Created by theanh on 1/23/16.
 */
public class ParallaxBackground {

    private int toadonen1_X = 0;
    private int toadonen2_X = 0;
    private int toadonen3_X = 0;
    private int toadonen4_X = 0;
    private int toadonen5_X = 0;
    private Bitmap hinhnen1;
    private Bitmap hinhnen2;
    private Bitmap hinhnen3;
    private Bitmap hinhnen4;
    private Bitmap hinhnen5;

    public ParallaxBackground(Resources c)
    {
        hinhnen1 = BitmapFactory.decodeResource(c, R.drawable.bg4);
        hinhnen2 = BitmapFactory.decodeResource(c, R.drawable.bg1);
        hinhnen3 = BitmapFactory.decodeResource(c, R.drawable.bg3);
        hinhnen4 = BitmapFactory.decodeResource(c, R.drawable.bg2);
        hinhnen5 = BitmapFactory.decodeResource(c, R.drawable.bg3);

    }

    public void doDrawRunning(Canvas canvas) {

        toadonen1_X = toadonen1_X - 2;

        //giam toa do de dich chuyen cho nen1
        toadonen2_X = toadonen2_X - 1;

        //giam toa do de dich chuyen cho nen2
        toadonen3_X = toadonen3_X - 3;

        toadonen4_X = toadonen4_X - 3;

        toadonen5_X = toadonen5_X - 4;

        int toadonen1_phu_X = hinhnen1.getWidth() - (-toadonen1_X);

        if (toadonen1_phu_X <= 0) {
            toadonen1_X = 0;
            canvas.drawBitmap(hinhnen1, toadonen1_X, canvas.getHeight()/2-hinhnen1.getHeight(), null);

        } else {
            canvas.drawBitmap(hinhnen1, toadonen1_X, canvas.getHeight()/2-hinhnen1.getHeight(), null);
            canvas.drawBitmap(hinhnen1, toadonen1_phu_X, canvas.getHeight()/2-hinhnen1.getHeight(), null);
        }

        // tinh do lech cho hinh 2 (xem hinh minh hoa)
        int toadonen2_phu_X = hinhnen2.getWidth() - (-toadonen2_X);

        //da di chuyen het thi quay lai tu dau
        if (toadonen2_phu_X <= 0) {
            toadonen2_X = 0;
            // chi can ve 1 tam
            canvas.drawBitmap(hinhnen2,toadonen2_X, canvas.getHeight()-hinhnen5.getHeight()-hinhnen2.getHeight(), null);

        } else {
            // ve 1 tam lech va tam 2 noi duoi theo
            canvas.drawBitmap(hinhnen2, toadonen2_X, canvas.getHeight()-hinhnen5.getHeight()/2-hinhnen2.getHeight(), null);
            canvas.drawBitmap(hinhnen2, toadonen2_phu_X, canvas.getHeight()-hinhnen5.getHeight()/2-hinhnen2.getHeight(), null);
        }

        int toadonen3_phu_X = hinhnen3.getWidth() - (-toadonen3_X);

        if (toadonen3_phu_X <= 0) {
            toadonen3_X = 0;
            canvas.drawBitmap(hinhnen3, toadonen3_X, canvas.getHeight()-hinhnen5.getHeight()/3-hinhnen3.getHeight(), null);

        } else {
            canvas.drawBitmap(hinhnen3, toadonen3_X, canvas.getHeight()-hinhnen5.getHeight()/3-hinhnen3.getHeight(), null);
            canvas.drawBitmap(hinhnen3, toadonen3_phu_X, canvas.getHeight()-hinhnen5.getHeight()/3-hinhnen3.getHeight(), null);
        }

        int toadonen4_phu_X = hinhnen4.getWidth() - (-toadonen4_X);

        //da di chuyen het thi quay lai tu dau
        if (toadonen4_phu_X <= 0) {
            toadonen4_X = 0;
            // chi can ve 1 tam
            canvas.drawBitmap(hinhnen4,toadonen4_X, canvas.getHeight()-hinhnen5.getHeight()/2-hinhnen4.getHeight(), null);

        } else {
            // ve 1 tam lech va tam 2 noi duoi theo
            canvas.drawBitmap(hinhnen4, toadonen4_X, canvas.getHeight()-hinhnen5.getHeight()/2-hinhnen4.getHeight(), null);
            canvas.drawBitmap(hinhnen4, toadonen4_phu_X, canvas.getHeight()-hinhnen5.getHeight()/2-hinhnen4.getHeight(), null);
        }

        int toadonen5_phu_X = hinhnen5.getWidth() - (-toadonen5_X);

        if (toadonen5_phu_X <= 0) {
            toadonen5_X = 0;
            // chi can ve 1 tam
            canvas.drawBitmap(hinhnen5,toadonen5_X, canvas.getHeight()-hinhnen5.getHeight(), null);

        } else {
            // ve 1 tam lech va tam 2 noi duoi theo
            canvas.drawBitmap(hinhnen5, toadonen5_X, canvas.getHeight()-hinhnen5.getHeight(), null);
            canvas.drawBitmap(hinhnen5, toadonen5_phu_X, canvas.getHeight()-hinhnen5.getHeight(), null);
        }

    }
}
