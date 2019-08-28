package com.tnta.superfish.superfish.controller;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.Log;

import com.tnta.superfish.superfish.model.IElement;

public abstract class ElementController implements IElementController {

    private Resources resources;
    private Canvas canvas;
    private IElement element;

    protected static final int MOVE_LEFT_TO_RIGHT = 1;
    protected static final int MOVE_RIGHT_TO_LEFT = -1;
    protected static final int MOVE_UP_TO_DOWN = 1;
    protected static final int MOVE_DOWN_TO_UP = -1;

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public IElement getElement() {
        return element;
    }

    public void setElement(IElement element) {
        this.element = element;
    }

    @Override
    public void doDrawElement() {
        getCanvas().drawBitmap(getElement().getImageBitmap(), getElement().getCoordinateX(), getElement().getCoordinateY(), null);
    }

}
