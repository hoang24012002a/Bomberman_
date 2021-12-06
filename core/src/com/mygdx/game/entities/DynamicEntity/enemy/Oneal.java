package com.mygdx.game.entities.DynamicEntity.enemy;

import com.mygdx.game.entities.DynamicEntity.enemy.AI.AI_Low;
import com.mygdx.game.entities.DynamicEntity.enemy.AI.AI_Medium;
import com.mygdx.game.gamesys.GameManager;


public class Oneal extends Enemy {
    public Oneal(float x, float y) {
        super(x, y);
        ai = new AI_Medium(this);
        textureAtlas = GameManager.onealLeftDynamic.getKey();
        animation = GameManager.onealLeftDynamic.getValue();
        speed = 0.5f;
    }

    private int timeKill = 0;
    private int timeChangeDirection = 0;
    @Override
    public void act(float delta) {
        timeChangeDirection++;
        if (timeChangeDirection == 20) {
            speed = (float) Math.random() + 0.5f;
            direction = calculateDir();
            timeChangeDirection = 0;
        }
        if (!isAlive()) {
            textureAtlas = GameManager.onealDeadDynamic.getKey();
            animation = GameManager.onealDeadDynamic.getValue();
            timeKill++;
            if (timeKill == 10) {
                GameManager.onealDeadSound.play();
            }
            if (timeKill == 100) {
                setPositionInMatrix(getX(), getY(), 'n');
                stageScreen.oneals.remove(this);
                stageScreen.remove(this);
                numberEnemy--;
                remove();
            }
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
    protected void moveRight() {
        textureAtlas = GameManager.onealRightDynamic.getKey();
        animation = GameManager.onealRightDynamic.getValue();
        if (canMoveRight()) {
            positionY += (Math.round(positionY / 32) * 32 - positionY);
            positionX += speed;
        }
        setPositionInMatrix(positionX, positionY, '2');
    }

    @Override
    protected void moveLeft() {
        textureAtlas = GameManager.onealLeftDynamic.getKey();
        animation = GameManager.onealLeftDynamic.getValue();
        //System.out.println(positionX);
        if (canMoveLeft()) {
            positionY += (Math.round(positionY / 32) * 32 - positionY);
            positionX -= speed;
        }
        setPositionInMatrix(positionX, positionY, '2');
    }

    @Override
    protected void moveTop() {
        textureAtlas = GameManager.onealRightDynamic.getKey();
        animation = GameManager.onealRightDynamic.getValue();
        if (canMoveTop()) {
            positionX += (Math.round(positionX / 32) * 32 - positionX);
            positionY += speed;
        }
        setPositionInMatrix(positionX, positionY, '2');
    }

    @Override
    protected void moveBottom() {
        textureAtlas = GameManager.onealLeftDynamic.getKey();
        animation = GameManager.onealLeftDynamic.getValue();
        if (canMoveBottom()) {
            positionX += (Math.round(positionX / 32) * 32 - positionX);
            positionY -= speed;
        }
        setPositionInMatrix(positionX, positionY, '2');
    }

    @Override
    protected int calculateDir() {
        return ai.calDir();
    }
}
