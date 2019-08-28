package com.tnta.superfish.superfish.model.subcharacter.enemy;

import android.content.res.Resources;
import android.graphics.BitmapFactory;

import com.tnta.superfish.superfish.R;
import com.tnta.superfish.superfish.model.subcharacter.IMotionElement;
import com.tnta.superfish.superfish.model.subcharacter.MotionElement;

import java.util.Random;

public class NormalEnemy extends MotionElement implements IMotionElement {

    private static final int []normalEnemyFirstStates={R.drawable.shark, R.drawable.jellyfish, R.drawable.bomb};
    private static final int []normalEnemySecondStates={R.drawable.sharkb, R.drawable.jellyfishb, R.drawable.bombb};
    public static int typearray = 0;
    private int normalEnemyType;

    public NormalEnemy(Resources resources, int coordinateX, int coordinateY, boolean isExist, int additionalMoveDistance){

        setResources(resources);

        int normalEnemyType = selectRandomNormalEnemyType();
        setNormalEnemyType(normalEnemyType);
        if (typearray < 32 || typearray > 48) {
            setImageBitmap(BitmapFactory.decodeResource(getResources(), normalEnemyFirstStates[getNormalEnemyType()]));
        }
        else {
            setImageBitmap(BitmapFactory.decodeResource(getResources(), normalEnemySecondStates[getNormalEnemyType()]));
        }

        setCoordinateX(coordinateX);
        setCoordinateY(coordinateY);

        setIsExist(isExist);

        setAdditionalMoveDistance(additionalMoveDistance);
    }

    private int selectRandomNormalEnemyType(){
        Random random = new Random();
        int normalEnemyType = random.nextInt(3);
        return normalEnemyType;
    }

    public int getNormalEnemyType() {
        return normalEnemyType;
    }

    public void setNormalEnemyType(int normalEnemyType) {
        this.normalEnemyType = normalEnemyType;
    }


}
