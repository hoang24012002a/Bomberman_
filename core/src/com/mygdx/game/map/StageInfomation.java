package com.mygdx.game.map;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.gamesys.GameManager;

public class StageInfomation extends Stage {
    private Pixmap pixmap = new Pixmap(992, 134, Pixmap.Format.RGBA8888);
    private TextureRegion KOB = new TextureRegion(new Texture("cartoon/KOB.png"));
    private TextureRegion heart = new TextureRegion(new Texture("cartoon/heart.png"));
    private TextureRegion balloon = new TextureRegion(new Texture("img/enemy/balloon/left/balloom_left1.png"));
    private TextureRegion oneal = new TextureRegion(new Texture("img/enemy/oneal/left/oneal_left1.png"));
    private TextureRegion doll = new TextureRegion(new Texture("img/enemy/doll/left/doll_left1.png"));
    private TextureRegion bomber = new TextureRegion(new Texture("img/player/down/player_down.png"));
    private TextureRegion anhLv1 = new TextureRegion(GameManager.Lv1);
    private TextureRegion anhLv2 = new TextureRegion(GameManager.Lv2);
    private TextureRegion anhLv3 = new TextureRegion(GameManager.Lv3);
    private Group hearts = new Group();
    private Group balloons = new Group();
    private Group oneals = new Group();
    private Group dolls = new Group();
    private StageScreen stageScreenLocal;
    private static int count = 3;
    private static int heartX = 300;
    private static final int heartY = 450;
    private static int balloonsX = 480;
    private static final int balloonsY = 450;
    private static int onealsX = 650;
    private static final int onealsY = 450;
    private static int dollsX = 790;
    private static final int dollsY = 450;
    public StageInfomation(StageScreen stageScreen){
        stageScreenLocal = stageScreen;
        pixmap.setColor(Color.BLUE);
        pixmap.fill();
        TextureRegion anhpixmap = new TextureRegion(new Texture(pixmap));
        MyActor myPixmap = new MyActor(anhpixmap);
        myPixmap.setPosition(0, 416);
        myPixmap.setBounds(myPixmap.getX(), myPixmap.getY(), anhpixmap.getRegionWidth(), anhpixmap.getRegionHeight());
        addActor(myPixmap);
        pixmap.dispose();
        MyActor myKOB = new MyActor(KOB);
        myKOB.setPosition(0, 465);
        myKOB.setBounds(myKOB.getX(), myKOB.getY(), KOB.getRegionWidth()/(float)9, KOB.getRegionHeight()/(float)9);
        addActor(myKOB);
        MyActor myBomber = new MyActor(bomber);
        myBomber.setPosition(120, 425);
        myBomber.setBounds(myBomber.getX(), myBomber.getY(), bomber.getRegionWidth()/(float)0.6, bomber.getRegionHeight()/(float)0.6);
        addActor(myBomber);
        addImageLever(stageScreenLocal.lv);
    }

    private void addImageLever(int lv) {
        if (lv == 1) {
            MyActor myLv = new MyActor(anhLv1);
            myLv.setPosition(840, 485);
            myLv.setBounds(myLv.getX(), myLv.getY(), anhLv1.getRegionWidth()/(float)1.3, anhLv1.getRegionHeight()/(float)1.3);
            addActor(myLv);
        } else if (lv == 2) {
            MyActor myLv = new MyActor(anhLv2);
            myLv.setPosition(840, 485);
            myLv.setBounds(myLv.getX(), myLv.getY(), anhLv1.getRegionWidth()/(float)1.3, anhLv1.getRegionHeight()/(float)1.3);
            addActor(myLv);
        } else {
            MyActor myLv = new MyActor(anhLv3);
            myLv.setPosition(840, 485);
            myLv.setBounds(myLv.getX(), myLv.getY(), anhLv1.getRegionWidth()/(float)1.3, anhLv1.getRegionHeight()/(float)1.3);
            addActor(myLv);
        }
    }

    private void createActorHeart(StageScreen stageScreen) {
        hearts.clear();
        for (int i = 0; i < stageScreen.numberlives; i++) {
            MyActor myHeart = new MyActor(heart);
            myHeart.setPosition(heartX + i * 45, heartY);
            myHeart.setBounds(myHeart.getX(), myHeart.getY(), heart.getRegionWidth() / 13, heart.getRegionHeight() / 13);
            hearts.addActor(myHeart);
        }
        addActor(hearts);
    }

    private void createActorBalloon(StageScreen stageScreen) {
        //System.out.println(stageScreen.balloons.size());
        balloons.clear();
        for (int i = 0; i < stageScreen.balloons.size(); i++) {
            MyActor myBalloon = new MyActor(balloon);
            myBalloon.setPosition(balloonsX + i * 45, balloonsY);
            myBalloon.setBounds(myBalloon.getX(), myBalloon.getY(), balloon.getRegionWidth(), balloon.getRegionHeight());
            balloons.addActor(myBalloon);
        }
        addActor(balloons);
    }

    private void createActorOneal(StageScreen stageScreen) {
        //System.out.println(stageScreen.oneals.size());
        oneals.clear();
        for (int i = 0; i < stageScreen.oneals.size(); i++) {
            MyActor myOneal = new MyActor(oneal);
            myOneal.setPosition(onealsX + i * 45, onealsY);
            myOneal.setBounds(myOneal.getX(), myOneal.getY(), oneal.getRegionWidth(), oneal.getRegionHeight());
            oneals.addActor(myOneal);
        }
        //oneals.clear();
        addActor(oneals);

    }

    private void createActorDoll(StageScreen stageScreen) {
        dolls.clear();
        for (int i = 0; i < stageScreen.dolls.size(); i++) {
            MyActor myDool = new MyActor(doll);
            myDool.setPosition(dollsX + i * 45, dollsY);
            myDool.setBounds(myDool.getX(), myDool.getY(), doll.getRegionWidth(), doll.getRegionHeight());
            dolls.addActor(myDool);
        }
        addActor(dolls);
    }

    @Override
    public void draw(){
        super.draw();
        createActorHeart(stageScreenLocal);
        createActorBalloon(stageScreenLocal);
        createActorOneal(stageScreenLocal);
        createActorDoll(stageScreenLocal);
    }

}

