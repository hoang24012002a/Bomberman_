package com.mygdx.game.entities.DynamicEntity.enemy;

import com.mygdx.game.entities.DynamicEntity.enemy.AI.AI_Low;
import com.mygdx.game.gamesys.GameManager;

public class Doll extends Enemy {
    public Doll(float x, float y) {
        super(x, y);
        ai = new AI_Low(this);
        speed = 2.0f;
        textureAtlas = GameManager.dollLeftDynamic.getKey();
        animation = GameManager.dollLeftDynamic.getValue();
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
            textureAtlas = GameManager.dollDeadDynamic.getKey();
            animation = GameManager.dollDeadDynamic.getValue();
            timeKill++;
            if (timeKill == 10) {
                GameManager.dollDeadSound.play();
            }
            if (timeKill == 100) {
                setPositionInMatrix(getX(), getY(), 'n');
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
        textureAtlas = GameManager.dollRightDynamic.getKey();
        animation = GameManager.dollRightDynamic.getValue();
        if (canMoveRight()) {
            positionY += (Math.round(positionY / 32) * 32 - positionY);
            positionX += speed;
        }
        setPositionInMatrix(positionX, positionY, '3');
    }

    @Override
    protected void moveLeft() {
        textureAtlas = GameManager.dollLeftDynamic.getKey();
        animation = GameManager.dollLeftDynamic.getValue();
        if (canMoveLeft()) {
            positionY += (Math.round(positionY / 32) * 32 - positionY);
            positionX -= speed;
        }
        setPositionInMatrix(positionX, positionY, '3');
    }

    @Override
    protected void moveTop() {
        textureAtlas = GameManager.dollRightDynamic.getKey();
        animation = GameManager.dollRightDynamic.getValue();
        if (canMoveTop()) {
            positionX += (Math.round(positionX / 32) * 32 - positionX);
            positionY += speed;
        }
        setPositionInMatrix(positionX, positionY, '3');
    }

    @Override
    protected void moveBottom() {
        textureAtlas = GameManager.dollLeftDynamic.getKey();
        animation = GameManager.dollLeftDynamic.getValue();
        if (canMoveBottom()) {
            positionX += (Math.round(positionX / 32) * 32 - positionX);
            positionY -= speed;
        }
        setPositionInMatrix(positionX, positionY, '3');
    }

    @Override
    protected int calculateDir() {
        return ai.calDir();
    }

    @Override
    public boolean canMoveBottom() {
        return getY() >= 32;
    }

    @Override
    public boolean canMoveLeft() {
        return getX() >= 32;
    }

    @Override
    public boolean canMoveRight() {
        return getX() <= 32 * 29;
    }

    @Override
    public boolean canMoveTop() {
        return getY() <= 32 * 11;
    }
}
