package com.tnta.superfish.superfish.controller.subcharacter.item;

import android.content.res.Resources;
import android.graphics.Canvas;

import com.tnta.superfish.superfish.controller.ElementController;
import com.tnta.superfish.superfish.controller.IElementController;
import com.tnta.superfish.superfish.model.subcharacter.item.BossBullet;

public class BossBulletController extends ElementController implements IElementController {

    private BossBullet bossBullet;

    public BossBullet getBossBullet() {
        return bossBullet;
    }

    public void setBossBullet(BossBullet bossBullet) {
        this.bossBullet = bossBullet;
        setElement(this.bossBullet);
    }

    @Override
    public void doDraw() {
        doDrawElement();
        getBossBullet().moveOnXAxis(getCanvas().getWidth()/54, MOVE_RIGHT_TO_LEFT);
    }
}
