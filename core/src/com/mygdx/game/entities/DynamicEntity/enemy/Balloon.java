package com.mygdx.game.entities.DynamicEntity.enemy;

import com.mygdx.game.entities.AnimatedEntity;
import com.mygdx.game.gamesys.GameManager;

public class Balloon extends AnimatedEntity {

    private int direction = 0;

    public Balloon() {
        super();
        textureAtlas = GameManager.balloonLeftDynamic.getKey();
        animation = GameManager.balloonLeftDynamic.getValue();
        //random direction per 1.5s
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1500);
                        direction = (int) (Math.random() * 4);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public Balloon(float x, float y) {
        super(x, y);
        textureAtlas = GameManager.balloonLeftDynamic.getKey();
        animation = GameManager.balloonLeftDynamic.getValue();
        //random direction per 1.5s
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1500);
                        direction = (int) (Math.random() * 4);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void act(float delta) {
        if (direction == 0) {
            textureAtlas = GameManager.balloonLeftDynamic.getKey();
            animation = GameManager.balloonLeftDynamic.getValue();
            positionX -= 0.5;
            if (positionX == 0) {
                positionX = this.getStage().getWidth();
            }
            setPosition(positionX, positionY);
        } else if (direction == 2) {
            textureAtlas = GameManager.balloonRightDynamic.getKey();
            animation = GameManager.balloonRightDynamic.getValue();
            positionX += 0.5;
            if (positionX == this.getStage().getWidth()) {
                positionX = 0;
            }
            setPosition(positionX, positionY);
        } else if (direction == 1) {
            textureAtlas = GameManager.balloonRightDynamic.getKey();
            animation = GameManager.balloonRightDynamic.getValue();
            positionY += 0.5;
            if (positionY == this.getStage().getHeight()) {
                positionY = 0;
            }
            setPosition(positionX, positionY);
        } else if (direction == 3) {
            textureAtlas = GameManager.balloonLeftDynamic.getKey();
            animation = GameManager.balloonLeftDynamic.getValue();
            positionY -= 0.5;
            if (positionY == 0) {
                positionY = this.getStage().getHeight();
            }
            setPosition(positionX, positionY);
        }
    }
}
