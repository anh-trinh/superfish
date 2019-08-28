package com.tnta.superfish.superfish.model.subcharacter;

import android.graphics.Canvas;

import com.tnta.superfish.superfish.model.Element;

public abstract class MotionElement extends Element implements IMotionElement {

    private Canvas canvas;

    private boolean isExist;
    private int additionalMoveDistance;

    @Override
    public boolean isExist() {
        return this.isExist;
    }

    @Override
    public void setIsExist(boolean isExist) {
        this.isExist = isExist;
    }

    @Override
    public boolean isPassOver(Canvas canvas){
        this.canvas = canvas;
        if (isPassOverLeftOfScreen() || isPassOverTopOfScreen()){
            return true;
        }
        return false;
    }

    private boolean isPassOverLeftOfScreen(){
        if (getCoordinateX() < -getImageWidth()){
            return true;
        }
        return false;
    }

    private boolean isPassOverTopOfScreen(){
        if (getCoordinateY() + getImageHeight() > this.canvas.getHeight()){
            return true;
        }
        return false;
    }

    public int getAdditionalMoveDistance() {
        return additionalMoveDistance;
    }

    public void setAdditionalMoveDistance(int additionalMoveDistance) {
        this.additionalMoveDistance = additionalMoveDistance;
    }
}
