package com.mygdx.game.entities.DynamicEntity.enemy;

import com.mygdx.game.entities.DynamicEntity.enemy.AI.AI_Low;
import com.mygdx.game.gamesys.GameManager;

public class Balloon extends Enemy {
    public Balloon(float x, float y) {
        super(x, y);
        ai = new AI_Low(this);
        speed = 0.5f;
        textureAtlas = GameManager.balloonLeftDynamic.getKey();
        animation = GameManager.balloonLeftDynamic.getValue();
    }

    private int timeKill = 0;
    private int timeChangeDirection = 0;
    @Override
    public void act(float delta) {
        timeChangeDirection++;
        if (timeChangeDirection == 40) {
            direction = calculateDir();
            timeChangeDirection = 0;
        }
        if (!isAlive()) {
            textureAtlas = GameManager.balloonDeadDynamic.getKey();
            animation = GameManager.balloonDeadDynamic.getValue();
            timeKill++;
            if (timeKill == 10) {
                GameManager.balloonDeadSound.play();
            }
            if (timeKill == 100) {
                setPositionInMatrix(getX(), getY(), 'n');
                stageScreen.balloons.remove(this);
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
        textureAtlas = GameManager.balloonRightDynamic.getKey();
        animation = GameManager.balloonRightDynamic.getValue();
        if (canMoveRight()) {
            positionY += (Math.round(positionY / 32) * 32 - positionY );
            positionX += speed;
        }
        setPositionInMatrix(positionX, positionY, '1');
    }

    @Override
    protected void moveLeft() {
        textureAtlas = GameManager.balloonLeftDynamic.getKey();
        animation = GameManager.balloonLeftDynamic.getValue();
        if (canMoveLeft()) {
            positionY += (Math.round(positionY / 32) * 32 - positionY);
            positionX -= speed;
        }
        setPositionInMatrix(positionX, positionY, '1');
    }

    @Override
    protected void moveTop() {
        textureAtlas = GameManager.balloonRightDynamic.getKey();
        animation = GameManager.balloonRightDynamic.getValue();
        if (canMoveTop()) {
            positionX += (Math.round(positionX / 32) * 32 - positionX);
            positionY += speed;
        }
        setPositionInMatrix(positionX, positionY, '1');
    }

    @Override
    protected void moveBottom() {
        textureAtlas = GameManager.balloonLeftDynamic.getKey();
        animation = GameManager.balloonLeftDynamic.getValue();
        if (canMoveBottom()) {
            positionX += (Math.round(positionX / 32) * 32 - positionX);
            positionY -= speed;
        }
        setPositionInMatrix(positionX, positionY, '1');
    }

    @Override
    protected int calculateDir() {
        return ai.calDir();
    }
}
