package com.tnta.superfish.superfish.model.subcharacter.item;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.tnta.superfish.superfish.R;
import com.tnta.superfish.superfish.model.subcharacter.IMotionElement;
import com.tnta.superfish.superfish.model.subcharacter.MotionElement;

public class BossBullet extends MotionElement implements IMotionElement {

    public BossBullet(Resources res, int coordinateX, int coordinateY)
    {
        setImageBitmap(BitmapFactory.decodeResource(res, R.drawable.bossbullet));
        setCoordinateX(coordinateX-getImageBitmap().getWidth());
        setCoordinateY(coordinateY-getImageBitmap().getHeight()/2);
    }

}
