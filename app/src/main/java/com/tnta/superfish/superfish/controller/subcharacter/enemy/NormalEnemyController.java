package com.tnta.superfish.superfish.controller.subcharacter.enemy;

import android.content.res.Resources;
import android.graphics.Canvas;

import com.tnta.superfish.superfish.controller.ElementController;
import com.tnta.superfish.superfish.controller.IElementController;
import com.tnta.superfish.superfish.model.IElement;
import com.tnta.superfish.superfish.model.subcharacter.enemy.NormalEnemy;

public class NormalEnemyController extends ElementController implements IElementController {

    private int sharkMoveDistance;
    private int jellyMoveDistance;
    private int bombMoveDistance;
    private int[] normalEnemyMoveDistances;

    private NormalEnemy normalEnemy;

    public NormalEnemy getNormalEnemy() {
        return normalEnemy;
    }

    public void setNormalEnemy(NormalEnemy normalEnemy) {
        this.normalEnemy = normalEnemy;
        setElement(this.normalEnemy);
    }

    @Override
    public void doDraw() {
        doDrawElement();
        setMoveDistances(getCanvas());
        if (getNormalEnemy().isExist()){
            int moveDistance = normalEnemyMoveDistances[normalEnemy.getNormalEnemyType()];
            moveDistance += getNormalEnemy().getAdditionalMoveDistance();
            getNormalEnemy().moveOnXAxis(moveDistance, MOVE_RIGHT_TO_LEFT);
            NormalEnemy.typearray++;
        }
        if (NormalEnemy.typearray==48){
            NormalEnemy.typearray=0;
        }
    }

    private void setMoveDistances(Canvas canvas) {
        sharkMoveDistance = canvas.getWidth()/240;
        jellyMoveDistance = canvas.getWidth()/174;
        bombMoveDistance = canvas.getWidth()/137;
        this.normalEnemyMoveDistances = new int[]{sharkMoveDistance, jellyMoveDistance, bombMoveDistance};
    }
}
