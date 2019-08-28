package com.tnta.superfish.superfish.model.subcharacter.item;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.tnta.superfish.superfish.R;
import com.tnta.superfish.superfish.model.subcharacter.IMotionElement;
import com.tnta.superfish.superfish.model.subcharacter.MotionElement;

import java.util.Random;

public class Food extends MotionElement implements IMotionElement {

    int []foodSets = {R.drawable.food1,R.drawable.food2};

    public Food(Resources res, int coordinateX, int coordinateY, boolean isExist, int additionalMoveDistance)
    {
        int foodType = selectRandomFoodType();
        setImageBitmap(BitmapFactory.decodeResource(res, foodSets[foodType]));

        setCoordinateX(coordinateX);
        setCoordinateY((int)(Math.random()*((coordinateY-0)+1)));

        setIsExist(isExist);

        setAdditionalMoveDistance(additionalMoveDistance);

    }

    private int selectRandomFoodType(){
        Random rand = new Random();
        int foodType = Math.abs(rand.nextInt(2));
        return foodType;
    }

}
