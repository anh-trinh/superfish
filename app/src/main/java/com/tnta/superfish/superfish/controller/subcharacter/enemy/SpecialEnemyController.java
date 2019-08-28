package com.tnta.superfish.superfish.controller.subcharacter.enemy;

import android.content.res.Resources;
import android.graphics.Canvas;

import com.tnta.superfish.superfish.controller.ElementController;
import com.tnta.superfish.superfish.controller.IElementController;
import com.tnta.superfish.superfish.model.subcharacter.enemy.SpecialEnemy;

public class SpecialEnemyController extends ElementController implements IElementController {

    private SpecialEnemy specialEnemy;

    public SpecialEnemy getSpecialEnemy() {
        return specialEnemy;
    }

    public void setSpecialEnemy(SpecialEnemy specialEnemy) {
        this.specialEnemy = specialEnemy;
        setElement(this.specialEnemy);
    }

    @Override
    public void doDraw() {
        doDrawElement();

        int moveDistance = getCanvas().getWidth() / 107;
        moveDistance += getSpecialEnemy().getAdditionalMoveDistance();
        if (getSpecialEnemy().isExist()) {
            getSpecialEnemy().moveOnXAxis(moveDistance, MOVE_RIGHT_TO_LEFT);
            SpecialEnemy.typearray++;
        }
        if (SpecialEnemy.typearray==48){
            SpecialEnemy.typearray=0;
        }
    }
}
