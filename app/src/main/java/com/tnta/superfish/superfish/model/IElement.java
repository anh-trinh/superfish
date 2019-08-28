package com.tnta.superfish.superfish.model;

import android.content.res.Resources;
import android.graphics.Bitmap;

public interface IElement {

    int getCoordinateX();

    void setCoordinateX(int coordinateX);

    int getCoordinateY();

    void setCoordinateY(int coordinateY);

    int getImageWidth();

    int getImageHeight();

    int getCoordinateXAtMiddleOfImage();

    int getCoordinateYAtMiddleOfImage();

    Bitmap getImageBitmap();

    void setImageBitmap(Bitmap characterImageBitmap);

    Resources getResources();

    void setResources(Resources resources);

    void moveOnXAxis(int moveDistance, int moveDirection);

    void moveOnYAxis(int moveDistance, int moveDirection);
}
