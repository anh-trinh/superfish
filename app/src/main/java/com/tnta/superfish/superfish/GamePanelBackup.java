package com.tnta.superfish.superfish;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.tnta.superfish.superfish.controller.Controller;
import com.tnta.superfish.superfish.controller.maincharacter.MainFishController;
import com.tnta.superfish.superfish.model.IElement;
import com.tnta.superfish.superfish.model.subcharacter.enemy.Boss;
import com.tnta.superfish.superfish.model.subcharacter.enemy.NormalEnemy;
import com.tnta.superfish.superfish.model.nav.Energy;
import com.tnta.superfish.superfish.model.subcharacter.item.Food;
import com.tnta.superfish.superfish.model.nav.GameMenuButton;
import com.tnta.superfish.superfish.model.maincharacter.MainFish;
import com.tnta.superfish.superfish.model.subcharacter.enemy.SpecialEnemy;
import com.tnta.superfish.superfish.model.subcharacter.item.Bullet;
import com.tnta.superfish.superfish.model.subcharacter.item.BossBullet;
import com.tnta.superfish.superfish.model.subcharacter.item.Gem;
import com.tnta.superfish.superfish.model.subcharacter.item.Point;
import com.tnta.superfish.superfish.utils.collision.CollisionDetector;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by theanh on 1/23/16.
 */
/* Code chay Thread
a.       Khai báo 1 đối tượng tên “thread” thuộc lớp “MainThread”.
b.      Trong hàm tạo khởi tạo đối tượng “thread”.
c.       Trong hàm surfaceCreated cho thread chạy.
d.      Trong hàm surfaceDestroyed thì hủy thread.
 */
public class GamePanelBackup extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread thread; //a. khai bao bien thread
    public static MainFish mainFish;
    GameMenuButton buttonGame = new GameMenuButton(getResources());
    boolean checkButton=false;

    public static boolean superfishmode=false;

    ParallaxBackground background; //bien hinh nen chuyen dong

    boolean isAlive = true;
    boolean checkOver = false;

    boolean breaktime=false;

    int typefish=0;
    int checkType=0;
    int savedLevelEnergy;

    int element_x=0;
    int canvas_x=0;
    int canvas_y=0;

    ArrayList<Bullet> bullets=new ArrayList<Bullet>();
    int thoigiannapdan=0; //bang 10 moi ban tiep duoc, tao do tre khi ban
    int limitthoigiannapdan=12;
    int save_point_bullet=0;

    ArrayList<NormalEnemy>enemies=new ArrayList<NormalEnemy>();
    int thoigiankethu=0;//thoigianrakethu, 10 sera

    ArrayList<Point>diem=new ArrayList<Point>();
    int saved_point=0;
    int diemso=0;
    int typespeed=0;
    ArrayList<Integer>diem_enemies=new ArrayList<Integer>();

    int highscore;
    boolean best=false;

    SpecialEnemy specialEnemy;

    ArrayList<Food>foods=new ArrayList<Food>();

    Gem gems;
    boolean checkPower=true;
    int sobullet=0;
    int sobulletused=0;
    int typegem=0;
    int typebullet=0;

    public static int energyLevel=0;
    Energy energys = new Energy(getResources());

    private SoundPool sounds;
    private SoundPool sounds2;
    private SoundPool sounds3;
    private SoundPool sounds4;
    private SoundPool sounds5;

    private int fireshot;
    private int watershot;
    private int leafshot;
    private int thundershot;
    private int groundshot;
    private int[] shotSounds = {fireshot, watershot, leafshot, thundershot, groundshot};

    private int eatfood;
    private int enemy;
    private int eatgem;
    private int gameover;
    private int elementhit;
    private int bossbulletattack;
    int checkOverSound=0;

    int distance=0;

    Boss boss;
    ArrayList<BossBullet> bossbullets=new ArrayList<BossBullet>();
    boolean checkBoss=false;
    int bossattack=0;
    int saved_point_boss=0;
    int thoigianbossbullet=0;

    Controller controller = new Controller();

    public GamePanelBackup(Context context) {
        super(context);

        //nhu mot hanlder cho cac event tren surface
        getHolder().addCallback(this);

        //thread =new MainThread(getHolder(),this); //b. khoi tao bien thread

        background=new ParallaxBackground(this.getResources());

        sounds = new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        sounds2= new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        sounds3= new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        sounds4= new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        sounds5= new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        fireshot = sounds.load(context, R.raw.fireshot, 1);
        watershot = sounds.load(context, R.raw.watershot, 1);
        leafshot = sounds.load(context, R.raw.leafshot, 1);
        thundershot = sounds.load(context, R.raw.thundershot, 1);
        groundshot = sounds.load(context, R.raw.groundshot, 1);
        eatfood = sounds3.load(context, R.raw.eatfood, 1);
        enemy = sounds2.load(context, R.raw.enemies, 1);
        eatgem = sounds3.load(context, R.raw.eatgem, 1);
        gameover = sounds4.load(context, R.raw.gameover, 1);
        elementhit = sounds3.load(context, R.raw.elementhit, 1);
        bossbulletattack = sounds5.load(context, R.raw.bossbullet, 1);

        setFocusable(true);
    }

    public void doDrawBullet(Canvas canvas)
    {
        if(thoigiannapdan>=limitthoigiannapdan) {
            thoigiannapdan=0;
            Bullet motviendan=
                    new Bullet(getResources(), mainFish.getCoordinateX()+mainFish.getImageWidth(), mainFish.getCoordinateY(),typebullet);

            int forsobulletused;
            if (superfishmode==false){
                forsobulletused=50;
            }
            else {
                forsobulletused=20;
            }
            if (sobullet<=100&&energyLevel>0) {
                bullets.add(motviendan);
                sobullet++;
                sobulletused++;
                if (sobulletused == forsobulletused) {
                    energyLevel--;
                    if (energyLevel < 0) {
                        energyLevel = 0;
                    }
                    sobulletused=0;
                }
                sounds.play(shotSounds[typebullet], 1.0f, 1.0f, 0, 0, 1.5f);
            }
        }
        for(int i=0;i<bullets.size();i++) {
            if (energyLevel>0) {
                doDrawByController(bullets.get(i));
            }
            else {
                bullets.clear();
            }
        }
        for(int i=0;i<bullets.size();i++) {
            if (bullets.get(i).getCoordinateX() > (canvas.getWidth()+bullets.get(i).getImageWidth())) {
                bullets.remove(i);
            }
        }
    }

    //ve tap hop kethu
    public void doDrawEnemies(Canvas canvas)
    {
        if(thoigiankethu>=25)
        {
            if (breaktime==false) {
                thoigiankethu = 0;
                NormalEnemy motkethu = new NormalEnemy(getResources(), canvas.getWidth(), generateRandomCoordinateY(canvas), !checkOver, typespeed);
                enemies.add(motkethu);
                diem_enemies.add(motkethu.getNormalEnemyType());
            }
            else {
                thoigiankethu=0;
            }
        }

        for(int i = 0; i<enemies.size(); i++){
            Controller controller = new Controller(canvas, enemies.get(i));
            controller.doDraw();
        }

        //Xoa bot enemies da dung trong array
        for(int i=0;i<enemies.size();i++){
            if(enemies.get(i).isPassOver(canvas)){
                enemies.remove(i);
                diem_enemies.remove(i);
            }
        }
        //Log.d("viendan","so vien: "+enemies.size());
    }

    public void doDrawPoint(Canvas canvas)
    {

        for(int i=0;i<diem.size();i++) {
            Controller controller = new Controller(canvas, diem.get(i));
            controller.doDraw();
        }

        //Xoa bot diem da dung trong array
        for(int i=0;i<diem.size();i++) {
            if (diem.get(i).getCoordinateY() > (canvas.getHeight()+diem.get(i).getImageHeight())){
                diem.remove(i);}
        }
    }

    public void doDrawSpecialEnemy(Canvas canvas)
    {
        if (specialEnemy==null) {
            Random rand = new Random();
            int specialEnemyTime = Math.abs(rand.nextInt(200));
            if (specialEnemyTime == 50) {
                specialEnemy = new SpecialEnemy(getResources(),canvas.getWidth(), mainFish.getCoordinateY(),!checkOver,typespeed);
            }
        }
        if (specialEnemy!=null) {
            Controller controller = new Controller(canvas, specialEnemy);
            controller.doDraw();
        }
        if(specialEnemy!=null&&(specialEnemy.isPassOver(canvas))){
            specialEnemy=null;
        }
    }

    public void doDrawBoss(Canvas canvas)
    {

        if (boss==null) {
            boss = new Boss(getResources(), canvas.getWidth(), canvas.getHeight()/2, !checkOver);
        }
        if (boss!=null) {
            Controller controller = new Controller(canvas, boss);
            controller.doDraw();
        }
        if(boss!=null && boss.isPassOver(canvas)){
            boss=null;
        }
    }

    public void doDrawBossBullet(Canvas canvas)
    {
        if (thoigianbossbullet>=25&&boss!=null) {
            thoigianbossbullet=0;
            sounds5.play(bossbulletattack, 1.0f, 1.0f, 0, 0, 1.5f);
            BossBullet motbossbullet = new BossBullet(getResources(), boss.getCoordinateX(), (canvas.getHeight()/2));
            bossbullets.add(motbossbullet);
        }
        for(int i=0;i<bossbullets.size();i++) {
            Controller controller = new Controller(canvas, bossbullets.get(i));
            controller.doDraw();
        }
        for(int i=0;i<bossbullets.size();i++) {
            if (bossbullets.get(i).getCoordinateX() > (canvas.getWidth()+bossbullets.get(i).getImageWidth())) {
                bossbullets.remove(i);
            }
        }
    }

    public void doDrawFood(Canvas canvas)
    {
        if (foods.size()<=2) {
            Random rand = new Random();
            int foodTime = Math.abs(rand.nextInt(50));
            if (foodTime == 25) {
                Food food = new Food(getResources(), canvas.getWidth(), canvas.getHeight(), !checkOver, typespeed);
                foods.add(food);
            }
        }
        if (foods.size()>0) {
            for(int i=0;i<foods.size();i++) {
                Controller controller = new Controller(canvas, foods.get(i));
                controller.doDraw();
            }
        }
        for(int i=0;i<foods.size();i++) {
            if (foods.get(i).isPassOver(canvas)) {
                foods.remove(i);
            }
        }
    }

    public void doDrawGem(Canvas canvas)
    {
        if (gems==null) {
            Random rand = new Random();
            int gemTime = Math.abs(rand.nextInt(300));
            if (gemTime == 50) {
                Random rand2 = new Random();
                if (diemso>=8000) {
                    typegem = Math.abs(rand2.nextInt(5));
                }
                if (diemso>=6000&&diemso<8000) {
                    typegem = Math.abs(rand2.nextInt(4));
                }
                if (diemso>=4000&&diemso<6000) {
                    typegem = Math.abs(rand2.nextInt(3));
                }
                if (diemso>=2000&&diemso<4000) {
                    typegem = Math.abs(rand2.nextInt(2));
                }
                if (diemso<2000){
                    typegem=0;
                }
                gems = new Gem(getResources(), canvas.getWidth(), canvas.getHeight(), typegem, !checkOver, typespeed);
            }
        }
        if (gems!=null) {
            Controller controller = new Controller(canvas, gems);
            controller.doDraw();
        }
        if(gems!=null&&(gems.isPassOver(canvas))){
            gems=null;
        }
    }

    public void xetvachamenemies()
    {
        try{
            for(int i=0;i<bullets.size();i++) {
                for (int j = 0; j < enemies.size(); j++) {
                    CollisionDetector collisionDetector = new CollisionDetector(bullets.get(i), enemies.get(j));
                    if (collisionDetector.isCollision()) {
                        if (diem_enemies.get(j) == 0) {
                            diemso += 10;
                        } else if (diem_enemies.get(j) == 1) {
                            diemso += 20;
                        } else if (diem_enemies.get(j) == 2) {
                            diemso += 30;
                        }
                        bullets.remove(i);
                        Point motdiem;
                        if (diemso > highscore && best == false) {
                            best = true;
                            motdiem = new Point(getResources(),
                                    enemies.get(j).getCoordinateX(), enemies.get(j).getCoordinateY(), 5, !checkOver);
                        } else {
                            motdiem = new Point(getResources(),
                                    enemies.get(j).getCoordinateX(), enemies.get(j).getCoordinateY(), diem_enemies.get(j), !checkOver);
                        }
                        diem.add(motdiem);
                        enemies.remove(j);
                        diem_enemies.remove(j);
                        sounds2.play(enemy, 1.0f, 1.0f, 0, 0, 1.5f);
                    }
                }
            }
        }catch(Exception e)
        {
            Log.e("loi xetvachamenemies",e.toString());
        }

    }

    public void xetvachambossbullet()
    {
        try{
            for(int i=0;i<bullets.size();i++) {
                for (int j = 0; j < bossbullets.size(); j++) {
                    CollisionDetector collisionDetector = new CollisionDetector(bullets.get(i), bossbullets.get(j));
                    if (boss != null && collisionDetector.isCollision()) {
                        bullets.remove(i);
                        if (superfishmode == true) {
                            bossbullets.remove(j);
                        }
                        sounds2.play(enemy, 1.0f, 1.0f, 0, 0, 1.5f);
                    }
                }
            }
        }catch(Exception e)
        {
            Log.d("loi xetvachambossbullet",e.toString());
        }

    }

    public void xetvachamspenemy(){
        try {
            for (int i = 0; i < bullets.size(); i++) {
                CollisionDetector collision = new CollisionDetector(bullets.get(i), specialEnemy);
                if (collision.isCollision()) {
                    diemso += 40;
                    bullets.remove(i);
                    Point motdiem2;
                    if (diemso > highscore && best == false) {
                        best = true;
                        motdiem2 = new Point(getResources(),
                                specialEnemy.getCoordinateX(), specialEnemy.getCoordinateY(), 5, !checkOver);
                    } else {
                        motdiem2 = new Point(getResources(),
                                specialEnemy.getCoordinateX(), specialEnemy.getCoordinateY(), 6, !checkOver);
                    }
                    diem.add(motdiem2);
                    specialEnemy = null;
                    sounds2.play(enemy, 1.0f, 1.0f, 0, 0, 1.5f);
                }
            }
        }catch(Exception e)
            {
                Log.d("loi xetvachamspenemy",e.toString());
            }
    }

    public void xetvachamboss(){
        try {
            for (int i = 0; i < bullets.size(); i++) {
                CollisionDetector collision = new CollisionDetector(bullets.get(i), boss);
                if (collision.isCollision()) {
                    if (superfishmode==true){
                        diemso += (100-(bossattack*10));
                        bullets.remove(i);
                        Point motdiem2;
                        if (diemso > highscore && best == false) {
                            best = true;
                            motdiem2 = new Point(getResources(),
                                    boss.getCoordinateX(), boss.getCoordinateY(), 5, !checkOver);
                        } else {
                            motdiem2 = new Point(getResources(),
                                    boss.getCoordinateX(), boss.getCoordinateY(), 3, !checkOver);
                        }
                        diem.add(motdiem2);
                        bossattack = 0;
                        boss = null;
                        typespeed=typespeed/2;
                        checkBoss = false;
                    }
                    else {
                        bossattack++;
                        diemso += 10;
                        bullets.remove(i);
                        Point motdiem2;
                        if (diemso > highscore && best == false) {
                            best = true;
                            motdiem2 = new Point(getResources(),
                                    boss.getCoordinateX(), boss.getCoordinateY(), 5, !checkOver);
                        } else if (bossattack == 10) {
                            motdiem2 = new Point(getResources(),
                                    boss.getCoordinateX(), boss.getCoordinateY(), 7, !checkOver);
                        } else {
                            motdiem2 = new Point(getResources(),
                                    boss.getCoordinateX(), boss.getCoordinateY(), 0, !checkOver);
                        }
                        diem.add(motdiem2);
                        if (bossattack == 10) {
                            bossattack = 0;
                            boss = null;
                            checkBoss = false;
                            typespeed = typespeed / 2;
                            breaktime = true;
                            for (int j = enemies.size()-1;j>=0; j--) {
                                Point motdiem;
                                if (diemso > highscore && best == false) {
                                    best = true;
                                    motdiem = new Point(getResources(),
                                            enemies.get(j).getCoordinateX(), enemies.get(j).getCoordinateY(), 5, !checkOver);
                                } else {
                                    motdiem = new Point(getResources(),
                                            enemies.get(j).getCoordinateX(), enemies.get(j).getCoordinateY(), diem_enemies.get(j), !checkOver);
                                }
                                diem.add(motdiem);
                                enemies.remove(j);
                                diem_enemies.remove(j);
                                if (j==0) {
                                    breaktime = false;
                                }
                            }
                        }
                    }
                    sounds2.play(enemy, 1.0f, 1.0f, 0, 0, 1.5f);
                }
            }
        }catch(Exception e)
        {
            Log.d("loi xetvachamboss",e.toString());
        }
    }

    public void xetvachamelement()
    {
        try{
            CollisionDetector collisionDetector = new CollisionDetector();
            for(int i=0;i<enemies.size();i++){
                collisionDetector.setElement(mainFish, enemies.get(i));
                if(collisionDetector.isCollision())
                {
                    sounds3.play(elementhit, 1.0f, 1.0f, 0, 0, 1.5f);
                    checkOver = true;
                }
            }
            for (int j = 0; j < bossbullets.size(); j++){
                collisionDetector.setElement(mainFish, bossbullets.get(j));
                if(boss!=null&&collisionDetector.isCollision()){
                    sounds3.play(elementhit, 1.0f, 1.0f, 0, 0, 1.5f);
                    checkOver = true;
                }
            }
            collisionDetector.setElement(mainFish, specialEnemy);
            boolean isMainFishImpactSpeacialEnemy = collisionDetector.isCollision();
            collisionDetector.setElement(mainFish, boss);
            boolean isMainFishImpactBoss = collisionDetector.isCollision();
            if(isMainFishImpactSpeacialEnemy||isMainFishImpactBoss){
                sounds3.play(elementhit, 1.0f, 1.0f, 0, 0, 1.5f);
                checkOver = true;
            }
        }catch(Exception e)
        {
            Log.d("loi xetvachamelement",e.toString());
        }

    }

    public void xeteatfood()
    {
        try{
            for(int i=0;i<foods.size();i++) {
                CollisionDetector collisionDetector = new CollisionDetector(mainFish, foods.get(i));
                if (collisionDetector.isCollision()) {
                    diemso += 100;
                    Point motdiem;
                    energyLevel++;
                    if (energyLevel > 91) {
                        energyLevel = 91;
                    }
                    if (diemso > highscore && best == false) {
                        best = true;
                        motdiem = new Point(getResources(),
                                foods.get(i).getCoordinateX(), foods.get(i).getCoordinateY(), 5, !checkOver);
                    } else {
                        motdiem = new Point(getResources(),
                                foods.get(i).getCoordinateX(), foods.get(i).getCoordinateY(), 3, !checkOver);
                    }
                    foods.remove(i);
                    diem.add(motdiem);
                    sounds3.play(eatfood, 1.0f, 1.0f, 0, 0, 1.5f);
                }
            }
        }catch(Exception e)
        {
            Log.d("loi xeteatfood",e.toString());
        }

    }

    public void xeteatgem()
    {
        try{
            CollisionDetector collisionDetector = new CollisionDetector(mainFish, gems);
            if(collisionDetector.isCollision())
            {
                diemso += 5;
                Point motdiem;
                if (checkPower==true){
                    sobullet=0;
                }
                typebullet=gems.getGemType();
                if (energyLevel>0) {
                    checkPower = true;
                }
                if (diemso > highscore && best == false) {
                    best = true;
                    motdiem = new Point(getResources(),
                            gems.getCoordinateX(), gems.getCoordinateY(), 5, !checkOver);
                } else {
                    motdiem = new Point(getResources(),
                            gems.getCoordinateX(), gems.getCoordinateY(), 4, !checkOver);
                }
                gems=null;
                diem.add(motdiem);
                sounds3.play(eatgem, 1.0f, 1.0f, 0, 0, 1.5f);
            }
        }catch(Exception e)
        {
            Log.d("loi xeteatgem",e.toString());
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        canvas.drawColor(getResources().getColor(R.color.background_color));
        background.doDrawRunning(canvas);
        thoigiankethu++;
        element_x = canvas.getWidth()/24;
        canvas_x=canvas.getWidth();
        canvas_y=canvas.getHeight();

        controller.setCanvas(canvas);

        if(mainFish !=null) {
            MainActivity.bgmusic.stop();
            if (checkOver == true) {
                checkOverSound++;
                this.doDrawFood(canvas);
                this.doDrawGem(canvas);
                if (checkBoss==true){
                    doDrawBoss(canvas);
                    doDrawBossBullet(canvas);
                }

                controller.setElement(energys);
                controller.doDraw();

                this.doDrawEnemies(canvas);//ve tap hop Enemies
                this.doDrawSpecialEnemy(canvas);
                this.doDrawPoint(canvas);
                MainFishController controller2 = new MainFishController();
                controller2.setCanvas(canvas);
                controller2.setMainFish(mainFish);
                controller2.doDrawGameOverMove();
                String text = "Oh No!";
                Paint p = new Paint();
                Rect bounds = new Rect();
                p.setColor(Color.WHITE);
                p.setStyle(Paint.Style.FILL_AND_STROKE);
                p.setTextSize(canvas.getHeight() / 15);
                p.getTextBounds(text, 0, text.length(), bounds);
                canvas.drawText(text, (canvas.getWidth() / 2) - (bounds.width() / 2), 2 * bounds.height(), p);
                if (diemso > highscore) {
                    MainActivity.preference.setScore("" + diemso);
                    best = false;
                    String text2 = "New High Score: " + diemso;
                    Paint p2 = new Paint();
                    Rect bounds2 = new Rect();
                    p2.setColor(Color.WHITE);
                    p2.setTextSize(canvas.getHeight() / 15);
                    p2.setStyle(Paint.Style.FILL_AND_STROKE);
                    p2.getTextBounds(text2, 0, text2.length(), bounds2);
                    canvas.drawText(text2, (canvas.getWidth() / 2) - (bounds2.width() / 2), (canvas.getHeight() / 2) - (bounds2.height() / 2), p2);

                } else {
                    String text2 = "Your Score: " + diemso;
                    Paint p2 = new Paint();
                    Rect bounds2 = new Rect();
                    p2.setColor(Color.WHITE);
                    p2.setTextSize(canvas.getHeight() / 15);
                    p2.setStyle(Paint.Style.FILL_AND_STROKE);
                    p2.getTextBounds(text2, 0, text2.length(), bounds2);
                    canvas.drawText(text2, (canvas.getWidth() / 2) - (bounds2.width() / 2), (canvas.getHeight() / 2) - (bounds2.height() / 2), p2);
                }
                if (checkOverSound == 1) {
                    sounds4.play(gameover, 1.0f, 1.0f, 0, 0, 1.5f);
                    checkOverSound++;
                }
                if (mainFish.getCoordinateX() > canvas.getWidth() || mainFish.getCoordinateY() > canvas.getHeight()) {
                    enemies.clear();
                    diem_enemies.clear();
                    bullets.clear();
                    diem.clear();
                    specialEnemy = null;
                    diemso = 0;
                    foods.clear();
                    energys = new Energy(getResources());
                    typefish = 0;
                    typespeed = 0;
                    checkType = 0;
                    checkOver = false;
                    checkPower = false;
                    thoigiankethu=0;
                    thoigiannapdan=0;
                    limitthoigiannapdan=12;
                    save_point_bullet=0;
                    thoigianbossbullet=0;
                    typegem = 0;
                    gems = null;
                    mainFish = null;
                    checkOverSound = 0;
                    energyLevel = 0;
                    sobullet = 0;
                    sobulletused=0;
                    typebullet = 0;
                    saved_point = 0;
                    savedLevelEnergy = 0;
                    distance=0;
                    boss=null;
                    bossbullets.clear();
                    checkBoss=false;
                    bossattack=0;
                    saved_point_boss=0;
                    best=false;
                    bullets.clear();
                    superfishmode=false;
                    breaktime=false;
                    //MainActivity.bgmusic.start();
                }
            }
            else {
                doDrawByController(mainFish);
                doDrawByController(energys);
                if (energyLevel==91){
                    superfishmode=true;
                }
                else {
                    superfishmode=false;
                }
                if (checkPower == true) {
                    thoigiannapdan++;
                    doDrawBullet(canvas);
                }
                if (energyLevel==1){
                    savedLevelEnergy=0;
                }
                if (energyLevel==0){
                    savedLevelEnergy=1;
                }
                if (energyLevel - savedLevelEnergy == 11) {
                    savedLevelEnergy = energyLevel - 1;
                    typefish++;
                }
                if (energyLevel - savedLevelEnergy == 0) {
                    savedLevelEnergy = energyLevel - 10;
                    typefish--;
                }
                if (diemso - saved_point >= 1000) {
                    saved_point+=1000;
                    typespeed+=canvas.getWidth()/960;
                }
                if (diemso - save_point_bullet >= 2000) {
                    save_point_bullet+=2000;
                    if (limitthoigiannapdan>9){
                        limitthoigiannapdan--;
                    }
                }
                if (diemso - saved_point_boss >= 10000) {
                    saved_point_boss+=10000;
                    checkBoss=true;
                }
                this.doDrawFood(canvas);
                this.doDrawGem(canvas);
                if (checkBoss==true){
                    thoigianbossbullet++;
                    doDrawBoss(canvas);
                    doDrawBossBullet(canvas);
                }
                this.doDrawEnemies(canvas);//ve tap hop Enemies
                this.doDrawSpecialEnemy(canvas);
                this.doDrawPoint(canvas);
                xetvachamenemies();//xetvacham
                if (superfishmode==true) {
                    xetvachamspenemy();
                }
                xetvachamboss();
                xetvachambossbullet();
                xetvachamelement();
                xeteatfood();
                xeteatgem();
                String text = "" + diemso;
                Paint p = new Paint();
                Rect bounds = new Rect();
                p.setColor(Color.WHITE);
                p.setStyle(Paint.Style.FILL_AND_STROKE);
                p.setTextSize(canvas.getHeight() / 15);
                p.getTextBounds(text, 0, text.length(), bounds);
                canvas.drawText(text, (canvas.getWidth() / 2) - (bounds.width() / 2), 2 * bounds.height(), p);
            }
        }
        else {
            if (checkButton == false) {
                doDrawByController(buttonGame);
                if (MainActivity.preference.getScore() == null) {
                    String text2 = "Click to start a new game";
                    Paint p2 = new Paint();
                    Rect bounds2 = new Rect();
                    p2.setColor(Color.WHITE);
                    p2.setTextSize(canvas.getHeight() / 15);
                    p2.setStyle(Paint.Style.STROKE);
                    p2.setStrokeWidth(3);
                    p2.getTextBounds(text2, 0, text2.length(), bounds2);
                    canvas.drawText(text2, (canvas.getWidth() / 2) - (bounds2.width() / 2), (canvas.getHeight() / 2) - (bounds2.height() / 2), p2);
                } else {
                    String text2 = "Click to start a new game";
                    Paint p2 = new Paint();
                    Rect bounds2 = new Rect();
                    p2.setColor(Color.WHITE);
                    p2.setTextSize(canvas.getHeight() / 15);
                    p2.setStyle(Paint.Style.STROKE);
                    p2.setStrokeWidth(3);
                    p2.getTextBounds(text2, 0, text2.length(), bounds2);
                    canvas.drawText(text2, (canvas.getWidth() / 2) - (bounds2.width() / 2), (canvas.getHeight() / 2) - (bounds2.height()), p2);
                    String text3 = "High Score: " + MainActivity.preference.getScore();
                    Paint p3 = new Paint();
                    Rect bounds3 = new Rect();
                    p3.setColor(Color.WHITE);
                    p3.setTextSize(canvas.getHeight() / 21);
                    p3.setStyle(Paint.Style.FILL_AND_STROKE);
                    p3.getTextBounds(text3, 0, text3.length(), bounds3);
                    canvas.drawText(text3, (canvas.getWidth() / 2) - (bounds3.width() / 2), (canvas.getHeight() / 2), p3);
                }
            }
            else {
                String text2 = "Try to get the highest score";
                Paint p2 = new Paint();
                Rect bounds2 = new Rect();
                p2.setColor(Color.WHITE);
                p2.setTextSize(canvas.getHeight() / 15);
                p2.setStyle(Paint.Style.FILL_AND_STROKE);
                p2.getTextBounds(text2, 0, text2.length(), bounds2);
                canvas.drawText(text2, (canvas.getWidth() / 2) - (bounds2.width() / 2), (canvas.getHeight() / 2) - (bounds2.height() / 2), p2);
                String text3 = "Swipe to eat food and attack enemies";
                Paint p3 = new Paint();
                Rect bounds3 = new Rect();
                p3.setColor(Color.WHITE);
                p3.setTextSize(canvas.getHeight() / 15);
                p3.setStyle(Paint.Style.FILL_AND_STROKE);
                p3.getTextBounds(text3, 0, text3.length(), bounds3);
                canvas.drawText(text3, (canvas.getWidth() / 2) - (bounds3.width() / 2), (canvas.getHeight() / 2) - (bounds2.height() / 2)-(bounds3.height()), p3);
                String text4 = "Welcome to Holy Fish!";
                Paint p4 = new Paint();
                Rect bounds4 = new Rect();
                p4.setColor(Color.YELLOW);
                p4.setTextSize(canvas.getHeight() / 15);
                p4.setStyle(Paint.Style.FILL_AND_STROKE);
                p4.getTextBounds(text4, 0, text4.length(), bounds4);
                canvas.drawText(text4, (canvas.getWidth() / 2) - (bounds4.width() / 2), (canvas.getHeight() / 2) - (bounds2.height() / 2)-(bounds3.height())-(bounds4.height()), p4);
                String text5 = "Raise your fish to become a super fish";
                Paint p5 = new Paint();
                Rect bounds5 = new Rect();
                p5.setColor(Color.WHITE);
                p5.setTextSize(canvas.getHeight() / 15);
                p5.setStyle(Paint.Style.FILL_AND_STROKE);
                p5.getTextBounds(text5, 0, text5.length(), bounds5);
                canvas.drawText(text5, (canvas.getWidth() / 2) - (bounds5.width() / 2), (canvas.getHeight() / 2) + (bounds2.height() / 2), p5);
                String text6 = "Now click to start a new game";
                Paint p6 = new Paint();
                Rect bounds6 = new Rect();
                p6.setColor(Color.YELLOW);
                p6.setTextSize(canvas.getHeight() / 15);
                p6.setStyle(Paint.Style.FILL_AND_STROKE);
                p6.getTextBounds(text6, 0, text6.length(), bounds6);
                canvas.drawText(text6, (canvas.getWidth() / 2) - (bounds6.width() / 2), (canvas.getHeight() / 2) + (bounds2.height() / 2)+(bounds5.height()), p6);
            }
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        //c. gán trạng thái cho thread và kích cho thread chay
        thread.setRunning(true);
        thread.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        //d. huy thread
        if(thread.isAlive())
            thread.setRunning(false);
    }

    /**
     * Start or resume the game.
     */
    public void resume() {
        thread.setRunning(true);
        //thread =new MainThread(getHolder(),this);
    }

    /**
     * Pause the game loop
     */
    public void pause() {
        thread.setRunning(false);
        boolean retry = true;
        while (retry) {
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
                // try again shutting down the thread
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        if(mainFish ==null&&checkOver!=true)
        {
            if(MainActivity.preference.getScore()!=null) {
                highscore = Integer.parseInt(MainActivity.preference.getScore());
            }
            else {
                highscore=0;
            }

            if (checkButton==false&&buttonGame != null && (((int) event.getX() > (buttonGame.getCoordinateX() - buttonGame.getImageWidth())) && ((int) event.getX() < canvas_x)) && (((int) event.getY() > buttonGame.getCoordinateY()) && ((int) event.getY() < buttonGame.getImageHeight()))) {
                checkButton=true;
            }
            else if (checkButton==true&&buttonGame != null && (((int) event.getX() > (buttonGame.getCoordinateX() - buttonGame.getImageWidth())) && ((int) event.getX() < canvas_x)) && (((int) event.getY() > buttonGame.getCoordinateY()) && ((int) event.getY() < buttonGame.getImageHeight()))){
                checkButton=true;
            }
            else {
                checkButton=false;
                mainFish = new MainFish(getResources(),element_x, (int) event.getY(), 0);
                mainFish.setCoordinateX(element_x);
                //Log.d("abc","khoi tao dau tien");
            }
            return true;
        }
        /*else if (mainFish!=null&&checkOver!=true)
        {
            distance=mainFish.mY-(int)event.getY();
            Log.i("distanceaaaaa",""+distance);
            //mainFish.mX=mainFish.bitmap.getWidth()/2;
            //mainFish.mY=(int)event.getY()-mainFish.bitmap.getHeight()/2;
        }*/

        /*
        if(event.getAction()==MotionEvent.ACTION_DOWN)
        {
            mainFish.mX=mainFish.bitmap.getWidth()/2;
            mainFish.mY=(int)event.getY()-mainFish.bitmap.getHeight()/2;
            Log.d("abc","ddddddddddddddddddddddddddddown");
        }
        if(event.getAction()==MotionEvent.ACTION_UP)
        {
            mainFish.mX=mainFish.bitmap.getWidth()/2;
            mainFish.mY=(int)event.getY()-mainFish.bitmap.getHeight()/2;
            Log.d("abc","uuuuuuuuuuuuuuuuuuuuuuuuuuuup");
        }*/
        else if(mainFish !=null&&checkOver!=true&&event.getAction()==MotionEvent.ACTION_MOVE)
        {
            mainFish =new MainFish(getResources(), mainFish.getCoordinateX(), mainFish.getCoordinateY(),typefish);
            //Log.d("abc","mmmmmmmmmmmmmmmmmmmmmmmmmmove");
            mainFish.setCoordinateX(element_x);
            if (distance>0) {
                mainFish.setCoordinateY((int) event.getY() + distance);
                if ((mainFish.getCoordinateY())>=canvas_y){
                    distance=canvas_y-(int) event.getY();
                    mainFish.setCoordinateY((int) event.getY()+distance);
                }
            }
            else if (distance<0){
                mainFish.setCoordinateY((int) event.getY() - (-distance));
                if ((mainFish.getCoordinateY())<=0){
                    distance=0-(int) event.getY();
                    mainFish.setCoordinateY((int) event.getY()- (-distance));
                }
            }
            else {
                mainFish.setCoordinateY((int) event.getY());
            }
        }

        distance= mainFish.getCoordinateY()-(int)event.getY();

        return true;//super.onTouchEvent(event);
    }

    private int generateRandomCoordinateY(Canvas canvas) {

        int maxValue = canvas.getHeight();
        int minValue = 0;

        int coordinateY = (int) (Math.random() * maxValue + minValue);

        return coordinateY;
    }

    private void doDrawByController(IElement element) {
        controller.setElement(element);
        controller.doDraw();
    }
}
