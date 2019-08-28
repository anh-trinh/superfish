package com.tnta.superfish.superfish.model.subcharacter;

import android.graphics.Canvas;

import com.tnta.superfish.superfish.model.IElement;

public interface IMotionElement extends IElement {

    boolean isExist();

    void setIsExist(boolean isExist);

    boolean isPassOver(Canvas canvas);
}
