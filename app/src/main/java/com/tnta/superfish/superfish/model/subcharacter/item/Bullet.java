package com.tnta.superfish.superfish.model.subcharacter.item;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.SoundPool;

import com.tnta.superfish.superfish.R;
import com.tnta.superfish.superfish.model.subcharacter.IMotionElement;
import com.tnta.superfish.superfish.model.subcharacter.MotionElement;

public class Bullet extends MotionElement implements IMotionElement {

    int[] bulletSets = {
            R.drawable.firebullet,
            R.drawable.waterbullet,
            R.drawable.leafbullet,
            R.drawable.thunderbullet,
            R.drawable.groundbullet
    };

    private SoundPool sounds;

    public Bullet(Resources resources, int coordinateX, int coordinateY, int bulletType) {

        setResources(resources);

        setImageBitmap(BitmapFactory.decodeResource(getResources(), bulletSets[bulletType]));

        setCoordinateX(coordinateX);
        setCoordinateY(coordinateY - getImageBitmap().getHeight()/2);
    }

}
