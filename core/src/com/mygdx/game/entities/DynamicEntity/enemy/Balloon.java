package com.mygdx.game.entities.DynamicEntity.enemy;

import com.mygdx.game.entities.DynamicEntity.enemy.AI.AI_random;
import com.mygdx.game.gamesys.GameManager;

public class Balloon extends Enemy {

    private int direction = 0;

    public Balloon() {
        super();
        textureAtlas = GameManager.balloonLeftDynamic.getKey();
        animation = GameManager.balloonLeftDynamic.getValue();
        //random direction per 1.5s
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(1500);
                        direction = calculateDir();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
                try {
                    while (true) {
                        Thread.sleep(1500);
                        direction = calculateDir();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void act(float delta) {
        killed();
        if (!isAlive()) {
            final Balloon _this = this;
            textureAtlas = GameManager.balloonDeadDynamic.getKey();
            animation = GameManager.balloonDeadDynamic.getValue();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1500);
                        getStage().getActors().removeValue(_this, true);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            return;
        }
        if (direction == 0) {
            moveLeft();
        } else if (direction == 2) {
            moveRight();
        } else if (direction == 1) {
            moveTop();
        } else if (direction == 3) {
            moveBottom();
        }
    }

    @Override
    protected void killed() {
        if (positionX == 150) {
            alive = false;
        }
    }

    @Override
    protected void moveRight() {
        textureAtlas = GameManager.balloonRightDynamic.getKey();
        animation = GameManager.balloonRightDynamic.getValue();
        positionX += 0.5;
        if (positionX == this.getStage().getWidth()) {
            positionX = 0;
        }
    }

    @Override
    protected void moveLeft() {
        textureAtlas = GameManager.balloonLeftDynamic.getKey();
        animation = GameManager.balloonLeftDynamic.getValue();
        positionX -= 0.5;
        if (positionX == 0) {
            positionX = this.getStage().getWidth();
        }
    }

    @Override
    protected void moveTop() {
        textureAtlas = GameManager.balloonRightDynamic.getKey();
        animation = GameManager.balloonRightDynamic.getValue();
        positionY += 0.5;
        if (positionY == this.getStage().getHeight()) {
            positionY = 0;
        }
    }

    @Override
    protected void moveBottom() {
        textureAtlas = GameManager.balloonLeftDynamic.getKey();
        animation = GameManager.balloonLeftDynamic.getValue();
        positionY -= 0.5;
        if (positionY == 0) {
            positionY = this.getStage().getHeight();
        }
    }

    @Override
    protected int calculateDir() {
        return AI_random.random();
    }
}
