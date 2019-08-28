package com.tnta.superfish.superfish.controller;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.Log;

import com.tnta.superfish.superfish.controller.maincharacter.MainFishController;
import com.tnta.superfish.superfish.controller.nav.EnergyController;
import com.tnta.superfish.superfish.controller.nav.GameMenuButtonController;
import com.tnta.superfish.superfish.controller.subcharacter.enemy.BossController;
import com.tnta.superfish.superfish.controller.subcharacter.enemy.NormalEnemyController;
import com.tnta.superfish.superfish.controller.subcharacter.enemy.SpecialEnemyController;
import com.tnta.superfish.superfish.controller.subcharacter.item.BossBulletController;
import com.tnta.superfish.superfish.controller.subcharacter.item.BulletController;
import com.tnta.superfish.superfish.controller.subcharacter.item.FoodController;
import com.tnta.superfish.superfish.controller.subcharacter.item.GemController;
import com.tnta.superfish.superfish.controller.subcharacter.item.PointController;
import com.tnta.superfish.superfish.model.IElement;
import com.tnta.superfish.superfish.model.maincharacter.MainFish;
import com.tnta.superfish.superfish.model.nav.Energy;
import com.tnta.superfish.superfish.model.nav.GameMenuButton;
import com.tnta.superfish.superfish.model.subcharacter.enemy.Boss;
import com.tnta.superfish.superfish.model.subcharacter.enemy.NormalEnemy;
import com.tnta.superfish.superfish.model.subcharacter.enemy.SpecialEnemy;
import com.tnta.superfish.superfish.model.subcharacter.item.BossBullet;
import com.tnta.superfish.superfish.model.subcharacter.item.Bullet;
import com.tnta.superfish.superfish.model.subcharacter.item.Food;
import com.tnta.superfish.superfish.model.subcharacter.item.Gem;
import com.tnta.superfish.superfish.model.subcharacter.item.Point;

public class ElementControllerFactory {

    private MainFishController mainFishController = new MainFishController();
    private BossController bossController = new BossController();
    private NormalEnemyController normalEnemyController = new NormalEnemyController();
    private SpecialEnemyController specialEnemyController = new SpecialEnemyController();
    private BossBulletController bossBulletController = new BossBulletController();
    private BulletController bulletController = new BulletController();
    private FoodController foodController = new FoodController();
    private GemController gemController = new GemController();
    private PointController pointController = new PointController();
    private EnergyController energyController = new EnergyController();
    private GameMenuButtonController gameMenuButton = new GameMenuButtonController();

    public IElementController getController(Canvas canvas, IElement element){

        if (element instanceof MainFish){
            mainFishController.setResources(element.getResources());
            mainFishController.setCanvas(canvas);
            mainFishController.setMainFish((MainFish) element);
            return mainFishController;
        }
        else if (element instanceof Boss) {
            bossController.setResources(element.getResources());
            bossController.setCanvas(canvas);
            bossController.setBoss((Boss) element);
            return bossController;
        }
        else if (element instanceof NormalEnemy){
            normalEnemyController.setResources(element.getResources());
            normalEnemyController.setCanvas(canvas);
            normalEnemyController.setNormalEnemy((NormalEnemy) element);
            return normalEnemyController;
        }
        else if (element instanceof SpecialEnemy){
            specialEnemyController.setResources(element.getResources());
            specialEnemyController.setCanvas(canvas);
            specialEnemyController.setSpecialEnemy((SpecialEnemy) element);
            return specialEnemyController;
        }
        else if (element instanceof BossBullet){
            bossBulletController.setResources(element.getResources());
            bossBulletController.setCanvas(canvas);
            bossBulletController.setBossBullet((BossBullet) element);
            return bossBulletController;
        }
        else if (element instanceof Bullet){
            bulletController.setResources(element.getResources());
            bulletController.setCanvas(canvas);
            bulletController.setBullet((Bullet) element);
            return bulletController;
        }
        else if (element instanceof Food){
            foodController.setResources(element.getResources());
            foodController.setCanvas(canvas);
            foodController.setFood((Food) element);
            return foodController;
        }
        else if (element instanceof Gem){
            gemController.setResources(element.getResources());
            gemController.setCanvas(canvas);
            gemController.setGem((Gem) element);
            return gemController;
        }
        else if (element instanceof Point){
            pointController.setResources(element.getResources());
            pointController.setCanvas(canvas);
            pointController.setPoint((Point) element);
            return pointController;
        }
        else if (element instanceof Energy) {
            energyController.setResources(element.getResources());
            energyController.setCanvas(canvas);
            energyController.setEnergy((Energy) element);
            return energyController;
        }
        else if (element instanceof GameMenuButton) {
            gameMenuButton.setResources(element.getResources());
            gameMenuButton.setCanvas(canvas);
            gameMenuButton.setGameMenuButton((GameMenuButton) element);
            return gameMenuButton;
        }

        return null;
    }
}
