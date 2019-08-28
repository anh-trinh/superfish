package com.tnta.superfish.superfish.controller.subcharacter.item;

import com.tnta.superfish.superfish.controller.ElementController;
import com.tnta.superfish.superfish.controller.IElementController;
import com.tnta.superfish.superfish.model.subcharacter.item.Bullet;

public class BulletController extends ElementController implements IElementController {

    private Bullet bullet;

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
        setElement(this.bullet);
    }

    @Override
    public void doDraw() {
        doDrawElement();
        getBullet().moveOnXAxis(getCanvas().getWidth()/54, MOVE_LEFT_TO_RIGHT);
    }
}
