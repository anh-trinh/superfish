package com.tnta.superfish.superfish.controller.subcharacter.item;

import android.content.res.Resources;
import android.graphics.Canvas;

import com.tnta.superfish.superfish.controller.ElementController;
import com.tnta.superfish.superfish.controller.IElementController;
import com.tnta.superfish.superfish.model.nav.GameMenuButton;
import com.tnta.superfish.superfish.model.subcharacter.item.Gem;

public class GemController extends ElementController implements IElementController {

    private Gem gem;

    public Gem getGem() {
        return gem;
    }

    public void setGem(Gem gem) {
        this.gem = gem;
        setElement(this.gem);
    }

    @Override
    public void doDraw() {
        doDrawElement();

        int moveDistance = getCanvas().getWidth() / 384;
        moveDistance += getGem().getAdditionalMoveDistance();

        if (getGem().isExist()) {
            getGem().moveOnXAxis(moveDistance, MOVE_RIGHT_TO_LEFT);
        }
    }

}
