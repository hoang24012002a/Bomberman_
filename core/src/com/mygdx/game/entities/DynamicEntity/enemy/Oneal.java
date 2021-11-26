package com.mygdx.game.entities.DynamicEntity.enemy;

import com.mygdx.game.entities.DynamicEntity.enemy.AI.AI_random;
import com.mygdx.game.gamesys.GameManager;

public class Oneal extends Enemy {
    public Oneal(float x, float y) {
        super(x, y);
        textureAtlas = GameManager.onealLeftDynamic.getKey();
        animation = GameManager.onealLeftDynamic.getValue();
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
        if (isAlive()) {
            final Oneal _this = this;
            textureAtlas = GameManager.onealDeadDynamic.getKey();
            animation = GameManager.onealDeadDynamic.getValue();
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
        } else if (direction == 1) {
            moveTop();
        } else if (direction == 2) {
            moveRight();
        } else if (direction == 3) {
            moveBottom();
        }
    }

    @Override
    protected void moveRight() {
        textureAtlas = GameManager.onealRightDynamic.getKey();
        animation = GameManager.onealRightDynamic.getValue();
        positionX += 0.5;
        if (positionX == this.getStage().getWidth()) {
            positionX = 0;
        }
        setPositionInMatrix(positionX, positionY, '2');
    }

    @Override
    protected void moveLeft() {
        textureAtlas = GameManager.onealLeftDynamic.getKey();
        animation = GameManager.onealLeftDynamic.getValue();
        positionX -= 0.5;
        if (positionX == 0) {
            positionX = this.getStage().getWidth();
        }
        setPositionInMatrix(positionX, positionY, '2');
    }

    @Override
    protected void moveTop() {
        textureAtlas = GameManager.onealRightDynamic.getKey();
        animation = GameManager.onealRightDynamic.getValue();
        positionY += 0.5;
        if (positionY == this.getStage().getHeight()) {
            positionY = 0;
        }
        setPositionInMatrix(positionX, positionY, '2');
    }

    @Override
    protected void moveBottom() {
        textureAtlas = GameManager.onealLeftDynamic.getKey();
        animation = GameManager.onealLeftDynamic.getValue();
        positionY -= 0.5;
        if (positionY == 0) {
            positionY = this.getStage().getHeight();
        }
        setPositionInMatrix(positionX, positionY, '2');
    }

    @Override
    protected int calculateDir() {
        return AI_random.random(4);
    }
}
