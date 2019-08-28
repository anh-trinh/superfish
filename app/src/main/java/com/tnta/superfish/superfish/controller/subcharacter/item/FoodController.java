package com.tnta.superfish.superfish.controller.subcharacter.item;

import android.content.res.Resources;
import android.graphics.Canvas;

import com.tnta.superfish.superfish.controller.ElementController;
import com.tnta.superfish.superfish.controller.IElementController;
import com.tnta.superfish.superfish.model.subcharacter.item.Food;

public class FoodController extends ElementController implements IElementController {

    private Food food;

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
        setElement(this.food);
    }

    @Override
    public void doDraw() {
        doDrawElement();

        int moveDistance = getCanvas().getWidth() / 240;
        moveDistance += getFood().getAdditionalMoveDistance();
        if (getFood().isExist()) {
            getFood().moveOnXAxis(moveDistance, MOVE_RIGHT_TO_LEFT);
        }
    }
}
