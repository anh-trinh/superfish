package com.tnta.superfish.superfish.model.maincharacter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.tnta.superfish.superfish.R;
import com.tnta.superfish.superfish.model.Element;

public class MainFish extends Element {

    private int []mainFishFirstStates={R.drawable.fish1,
            R.drawable.fish2, R.drawable.fish3, R.drawable.fish4,
            R.drawable.fish5, R.drawable.fish6, R.drawable.fish7,
            R.drawable.fish8, R.drawable.fish9, R.drawable.superfish};
    private int []mainFishSecondStates={R.drawable.fish1b,
            R.drawable.fish2b, R.drawable.fish3b, R.drawable.fish4b,
            R.drawable.fish5b, R.drawable.fish6b, R.drawable.fish7b,
            R.drawable.fish8b, R.drawable.fish9b, R.drawable.superfishb};
    public static int typearray=0;

    public MainFish(Resources resources, int coordinateX, int coordinateY, int fishType) {

        setResources(resources);

        Bitmap bitmap;
        if (typearray<32) {
            bitmap = BitmapFactory.decodeResource(getResources(), mainFishFirstStates[fishType]);
        }
        else {
            bitmap = BitmapFactory.decodeResource(getResources(), mainFishSecondStates[fishType]);
        }
        setImageBitmap(bitmap);

        coordinateX -= getImageBitmap().getWidth()/2;
        setCoordinateX(coordinateX);

        coordinateY -= getImageBitmap().getHeight()/2;
        setCoordinateY(coordinateY);
    }

}
