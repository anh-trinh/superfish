package com.tnta.superfish.superfish.model.subcharacter.item;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.tnta.superfish.superfish.R;
import com.tnta.superfish.superfish.model.subcharacter.MotionElement;
import com.tnta.superfish.superfish.model.subcharacter.IMotionElement;

public class Point extends MotionElement implements IMotionElement {

    int[] pointSets = {
            R.drawable.point5,
            R.drawable.point10,
            R.drawable.point20,
            R.drawable.point30,
            R.drawable.point40,
            R.drawable.point100,
            R.drawable.bosspoint,
            R.drawable.highscore
    };

    public Point(Resources resources, int coordinateX, int coordinateY, int pointType, boolean isExist) {

        setImageBitmap(BitmapFactory.decodeResource(resources, pointSets[pointType]));

        setCoordinateX(coordinateX);
        setCoordinateY(coordinateY);

        setIsExist(isExist);
    }

}
