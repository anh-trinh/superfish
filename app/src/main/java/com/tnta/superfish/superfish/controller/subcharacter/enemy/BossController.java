package com.tnta.superfish.superfish.controller.subcharacter.enemy;

import android.content.res.Resources;
import android.graphics.Canvas;

import com.tnta.superfish.superfish.controller.ElementController;
import com.tnta.superfish.superfish.controller.IElementController;
import com.tnta.superfish.superfish.model.subcharacter.enemy.Boss;

public class BossController extends ElementController implements IElementController {

    private Boss boss;

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
        setElement(this.boss);
    }

    @Override
    public void doDraw() {
        doDrawElement();
        int moveDistance = getCanvas().getWidth() / 240;
        if (getBoss().isExist()) {
            getBoss().moveOnXAxis(moveDistance, MOVE_RIGHT_TO_LEFT);
        }
    }
}
