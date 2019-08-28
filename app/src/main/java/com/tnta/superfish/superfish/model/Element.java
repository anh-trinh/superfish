package com.tnta.superfish.superfish.model;

import android.content.res.Resources;
import android.graphics.Bitmap;

public abstract class Element implements IElement {

    private int coordinateX;
    private int coordinateY;
    private Bitmap imageBitmap;
    private Resources resources;

    @Override
    public int getCoordinateX() {
        return this.coordinateX;
    }

    @Override
    public void setCoordinateX(int coordinateX){
        this.coordinateX = coordinateX;
    }

    @Override
    public int getCoordinateY() {
        return this.coordinateY;
    }

    @Override
    public void setCoordinateY(int coordinateY){
        this.coordinateY = coordinateY;
    }

    @Override
    public int getImageWidth(){
        return this.imageBitmap.getWidth();
    }

    @Override
    public int getImageHeight(){
        return this.imageBitmap.getHeight();
    }

    @Override
    public int getCoordinateXAtMiddleOfImage(){
        int aHalfWidthOfImage = getImageWidth() / 2;
        return this.coordinateX + aHalfWidthOfImage;
    }

    @Override
    public int getCoordinateYAtMiddleOfImage(){
        int aHalfHeightOfImage = getImageHeight() / 2;
        return this.coordinateY + aHalfHeightOfImage;
    }

    @Override
    public Bitmap getImageBitmap() {
        return this.imageBitmap;
    }

    @Override
    public void setImageBitmap(Bitmap characterImageBitmap) {
        this.imageBitmap = characterImageBitmap;
    }

    @Override
    public Resources getResources() {
        return this.resources;
    }

    @Override
    public void setResources(Resources resources) {
        this.resources = resources;
    }

    @Override
    public void moveOnXAxis(int moveDistance, int moveDirection){
        this.coordinateX += moveDistance * moveDirection;
        setCoordinateX(this.coordinateX);
    }

    @Override
    public void moveOnYAxis(int moveDistance, int moveDirection){
        this.coordinateY += moveDistance * moveDirection;
        setCoordinateY(this.coordinateY);
    }

}
