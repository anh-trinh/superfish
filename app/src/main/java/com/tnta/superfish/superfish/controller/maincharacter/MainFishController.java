package com.tnta.superfish.superfish.controller.maincharacter;

import android.content.res.Resources;
import android.graphics.Canvas;

import com.tnta.superfish.superfish.controller.ElementController;
import com.tnta.superfish.superfish.controller.IElementController;
import com.tnta.superfish.superfish.model.maincharacter.MainFish;

public class MainFishController extends ElementController implements IElementController {

    private MainFish mainFish;

    public MainFish getMainFish() {
        return mainFish;
    }

    public void setMainFish(MainFish mainFish) {
        this.mainFish = mainFish;
        setElement(this.mainFish);
    }

    @Override
    public void doDraw() {

        doDrawElement();

        MainFish.typearray++;
        if (MainFish.typearray==48){
            MainFish.typearray=0;
        }
    }

    public void doDrawGameOverMove(){

        getCanvas().drawBitmap(getElement().getImageBitmap(), getElement().getCoordinateX(),getElement().getCoordinateY(), null);

        getMainFish().moveOnXAxis(getCanvas().getWidth()/135, MOVE_LEFT_TO_RIGHT);
        getMainFish().moveOnYAxis(getCanvas().getHeight()/222, MOVE_UP_TO_DOWN);

        MainFish.typearray++;
        if (MainFish.typearray==48){
            MainFish.typearray=0;
        }
    }
}
