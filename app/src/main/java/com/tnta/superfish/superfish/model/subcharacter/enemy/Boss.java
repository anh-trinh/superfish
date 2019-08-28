package com.tnta.superfish.superfish.model.subcharacter.enemy;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.tnta.superfish.superfish.R;
import com.tnta.superfish.superfish.model.subcharacter.IMotionElement;
import com.tnta.superfish.superfish.model.subcharacter.MotionElement;

public class Boss extends MotionElement implements IMotionElement {

    public Boss(Resources resources, int coordinateX, int coordinateY, boolean isExist){

        setResources(resources);

        Bitmap bossBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.boss);
        setImageBitmap(bossBitmap);

        setCoordinateX(coordinateX);
        setCoordinateY(generateCoordinateYAtMiddleOfScreen(getImageBitmap(), coordinateY));

        setIsExist(isExist);
    }

    private int generateCoordinateYAtMiddleOfScreen(Bitmap bossBitmap, int coordinateYAtMiddleOfScreen) {
        int aHalfOfBossImageHeight = bossBitmap.getHeight()/2;
        int coordinateY = coordinateYAtMiddleOfScreen - aHalfOfBossImageHeight;
        return coordinateY;
    }

}
