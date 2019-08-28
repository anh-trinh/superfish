package com.tnta.superfish.superfish.model.subcharacter.item;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.tnta.superfish.superfish.R;
import com.tnta.superfish.superfish.model.subcharacter.IMotionElement;
import com.tnta.superfish.superfish.model.subcharacter.MotionElement;

public class Gem extends MotionElement implements IMotionElement {

    int gemType;

    int[] gemSets = {
            R.drawable.firegem,
            R.drawable.watergem,
            R.drawable.leafgem,
            R.drawable.thundergem,
            R.drawable.groundgem};

    public Gem(Resources resources, int coordinateX, int coordinateY, int gemType, boolean isExist, int additionalMoveDistance) {

        setGemType(gemType);

        setImageBitmap(BitmapFactory.decodeResource(resources, gemSets[getGemType()]));

        setCoordinateX(coordinateX);
        setCoordinateY((int)(Math.random()*((coordinateY-0)+1)));

        setIsExist(isExist);

        setAdditionalMoveDistance(additionalMoveDistance);
    }

    public int getGemType() {
        return gemType;
    }

    public void setGemType(int gemType) {
        this.gemType = gemType;
    }

}
