package com.mygdx.game.map;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class StageInfomation extends Stage {
    private Pixmap pixmap = new Pixmap(992, 134, Pixmap.Format.RGBA8888);
    private TextureRegion heart = new TextureRegion(new Texture("cartoon/heart.png"));
    private TextureRegion balloon = new TextureRegion(new Texture("img/enemy/balloon/left/balloom_left1.png"));
    private Group hearts = new Group();
    private Group balloons = new Group();
    private static int count = 3;
    private static int heartX = 300;
    private static final int heartY = 450;
    private static int balloonsX = 490;
    private static final int balloonsY = 450;
    public StageInfomation(){
        pixmap.setColor(Color.BLUE);
        pixmap.fill();
        TextureRegion anhpixmap = new TextureRegion(new Texture(pixmap));
        MyActor myPixmap = new MyActor(anhpixmap);
        myPixmap.setPosition(0, 416);
        myPixmap.setBounds(myPixmap.getX(), myPixmap.getY(), anhpixmap.getRegionWidth(), anhpixmap.getRegionHeight());
        addActor(myPixmap);
        pixmap.dispose();
        createActorHeart();
        createActorBalloon();
    }

    private void createActorHeart() {
        for (int i = 0; i < count; i++) {
            MyActor myHeart = new MyActor(heart);
            myHeart.setPosition(heartX + i * 45, heartY);
            myHeart.setBounds(myHeart.getX(), myHeart.getY(), heart.getRegionWidth() / 13, heart.getRegionHeight() / 13);
            hearts.addActor(myHeart);
        }
        addActor(hearts);
    }

    private void createActorBalloon() {
        for (int i = 0; i < 3; i++) {
            MyActor myBalloon = new MyActor(balloon);
            myBalloon.setPosition(balloonsX + i * 45, balloonsY);
            myBalloon.setBounds(myBalloon.getX(), myBalloon.getY(), balloon.getRegionWidth()/(float)1.2, balloon.getRegionHeight()/(float)1.2);
            balloons.addActor(myBalloon);
        }
        addActor(balloons);
    }

    /*private void createActorOneal() {
        for (int i = 0; i < 3; i++) {
            MyActor myBalloon = new MyActor(balloon);
            myBalloon.setPosition(balloonsX + i * 45, balloonsY);
            myBalloon.setBounds(myBalloon.getX(), myBalloon.getY(), balloon.getRegionWidth()/(float)1.2, balloon.getRegionHeight()/(float)1.2);
            balloons.addActor(myBalloon);
        }
        addActor(balloons);
    }*/

}

