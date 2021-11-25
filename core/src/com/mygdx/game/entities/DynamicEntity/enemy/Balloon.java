package com.mygdx.game.entities.DynamicEntity.enemy;

import com.mygdx.game.entities.DynamicEntity.enemy.AI.AI_random;
import com.mygdx.game.gamesys.GameManager;

import java.util.ArrayList;

public class Balloon extends Enemy {

    public Balloon(float x, float y) {
        super(x, y);
        speed = 0.5f;
        textureAtlas = GameManager.balloonLeftDynamic.getKey();
        animation = GameManager.balloonLeftDynamic.getValue();
        //random direction per 1.5s
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (alive) {
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
    public void dispose() {

    }
    private int dem = 0;
    @Override
    public void act(float delta) {
        if (!isAlive()) {
            textureAtlas = GameManager.balloonDeadDynamic.getKey();
            animation = GameManager.balloonDeadDynamic.getValue();
            dem++;
            if (dem == 100) {
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
            positionY += (Math.round(positionY / 32) * 32 - positionY);
            positionX += speed;
        }
    }

    @Override
    protected void moveLeft() {
        textureAtlas = GameManager.balloonLeftDynamic.getKey();
        animation = GameManager.balloonLeftDynamic.getValue();
        if (canMoveLeft()) {
            positionY += (Math.round(positionY / 32) * 32 - positionY);
            positionX -= speed;
        }
    }

    @Override
    protected void moveTop() {
        textureAtlas = GameManager.balloonRightDynamic.getKey();
        animation = GameManager.balloonRightDynamic.getValue();
        if (canMoveTop()) {
            positionX += (Math.round(positionX / 32) * 32 - positionX);
            positionY += speed;
        }
    }

    @Override
    protected void moveBottom() {
        textureAtlas = GameManager.balloonLeftDynamic.getKey();
        animation = GameManager.balloonLeftDynamic.getValue();
        if (canMoveBottom()) {
            positionX += (Math.round(positionX / 32) * 32 - positionX);
            positionY -= speed;
        }
    }

    @Override
    protected int calculateDir() {
        ArrayList<Integer> dir = new ArrayList<>();
        if (canMoveBottom()) dir.add(3);
        if (canMoveLeft()) dir.add(0);
        if (canMoveRight()) dir.add(2);
        if (canMoveTop()) dir.add(1);
        int index = AI_random.random(dir.size());
        return dir.get(index);
    }
}
