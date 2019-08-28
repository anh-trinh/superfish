package com.tnta.superfish.superfish.controller;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.Log;

import com.tnta.superfish.superfish.model.IElement;

public class Controller {

    private IElementController elementController;
    private ElementControllerFactory elementControllerFactory = new ElementControllerFactory();
    private Canvas canvas;
    private IElement element;

    public Controller() {}

    public Controller(Canvas canvas, IElement element){
        setCanvas(canvas);
        setElement(element);
    }

    public void doDraw(){
        elementController = elementControllerFactory.getController(getCanvas(), getElement());
        elementController.doDraw();
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

}
