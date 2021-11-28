package com.mygdx.game.entities.DynamicEntity.enemy;

import com.mygdx.game.entities.DynamicEntity.Bomber;
import com.mygdx.game.entities.DynamicEntity.enemy.AI.AI_random;
import com.mygdx.game.gamesys.GameManager;

import java.util.ArrayList;

public class Oneal extends Enemy {
    private Bomber bomber;
    public Oneal(float x, float y) {
        super(x, y);
        bomber = Bomber.bomber;
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
            if (timeKill == 100) {
                setPositionInMatrix(getX(), getY(), 'n');
                stageScreen.remove(this);
                remove();
                numberEnemy--;
            }
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
        ArrayList<Integer> dir = new ArrayList<>();
        if (canMoveBottom()) dir.add(3);
        if (canMoveLeft()) dir.add(0);
        if (canMoveRight()) dir.add(2);
        if (canMoveTop()) dir.add(1);
        boolean check = false;
        double distance = Float.MAX_VALUE;
        int min = 0;
        for (int i = 0; i < dir.size(); i++) {
            if (dir.get(i) == 0) {
                double temp = Math.sqrt((getX() - speed - bomber.getX()) * (getX() - speed - bomber.getX())
                        + (getY() - bomber.getY()) * (getY() - bomber.getY()));
                if (temp < distance) {
                    distance = temp;
                    min = i;
                }
            } else if (dir.get(i) == 2) {
                double temp = Math.sqrt((getX() + speed - bomber.getX()) * (getX() + speed - bomber.getX())
                        + (getY() - bomber.getY()) * (getY() - bomber.getY()));
                if (temp < distance) {
                    distance = temp;
                    min = i;
                }
            } else if (dir.get(i) == 1) {
                double temp = Math.sqrt((getX() - bomber.getX()) * (getX() - bomber.getX())
                        + (getY() + speed - bomber.getY()) * (getY() + speed - bomber.getY()));
                if (temp < distance) {
                    distance = temp;
                    min = i;
                }
            } else {
                double temp = Math.sqrt((getX() - bomber.getX()) * (getX() - bomber.getX())
                        + (getY() - speed - bomber.getY()) * (getY() - speed - bomber.getY()));
                if (temp < distance) {
                    distance = temp;
                    min = i;
                }
            }
        }
        return dir.get(min);
    }
}
