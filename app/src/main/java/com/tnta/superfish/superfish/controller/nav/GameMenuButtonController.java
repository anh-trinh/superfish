package com.tnta.superfish.superfish.controller.nav;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.Log;

import com.tnta.superfish.superfish.controller.ElementController;
import com.tnta.superfish.superfish.controller.IElementController;
import com.tnta.superfish.superfish.model.nav.GameMenuButton;

public class GameMenuButtonController extends ElementController implements IElementController {

    private GameMenuButton gameMenuButton = new GameMenuButton(getResources());

    public GameMenuButton getGameMenuButton() {
        return gameMenuButton;
    }

    public void setGameMenuButton(GameMenuButton gameMenuButton) {
        this.gameMenuButton = gameMenuButton;
        setElement(this.gameMenuButton);
    }

    @Override
    public void doDraw() {
        getGameMenuButton().setCoordinateX(0);
        getGameMenuButton().setCoordinateY(0);
        setElement(getGameMenuButton());
        doDrawElement();
    }
}
