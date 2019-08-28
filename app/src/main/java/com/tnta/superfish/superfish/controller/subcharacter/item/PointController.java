package com.tnta.superfish.superfish.controller.subcharacter.item;

import android.content.res.Resources;
import android.graphics.Canvas;

import com.tnta.superfish.superfish.controller.ElementController;
import com.tnta.superfish.superfish.controller.IElementController;
import com.tnta.superfish.superfish.model.subcharacter.item.Point;

public class PointController extends ElementController implements IElementController {

    private Point point;

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
        setElement(this.point);
    }

    @Override
    public void doDraw() {
        doDrawElement();

        int moveDistance = getCanvas().getHeight()/154;
        if (getPoint().isExist()) {
            getPoint().moveOnYAxis(moveDistance, MOVE_UP_TO_DOWN);
        }
    }
}
