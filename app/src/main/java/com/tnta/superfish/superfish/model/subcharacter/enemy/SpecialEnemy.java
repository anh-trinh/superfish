package com.tnta.superfish.superfish.model.subcharacter.enemy;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.tnta.superfish.superfish.R;
import com.tnta.superfish.superfish.model.subcharacter.IMotionElement;
import com.tnta.superfish.superfish.model.subcharacter.MotionElement;

public class SpecialEnemy extends MotionElement implements IMotionElement {

    public static int typearray=0;

    public SpecialEnemy(Resources resources,
                        int coordinateX, int coordinateY,
                        boolean isExist, int additionalMoveDistance)
    {

        setCoordinateX(coordinateX);
        setCoordinateY(coordinateY);

        setResources(resources);

        if (typearray<32 || typearray > 48) {
            setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.specialenemy));
        }
        else {
            setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.specialenemyb));
        }

        setIsExist(isExist);

        setAdditionalMoveDistance(additionalMoveDistance);
    }

}
