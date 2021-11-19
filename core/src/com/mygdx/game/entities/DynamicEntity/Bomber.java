package com.mygdx.game.entities.DynamicEntity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.gamesys.GameManager;

public class Bomber extends Character {
    private int code = 0; //Mã phím vừa bấm.

    public Bomber() {
        super();
        textureAtlas = GameManager.playerDownStatic.getKey();
        animation = GameManager.playerDownStatic.getValue();
        code = Input.Keys.S;
        speed = 1;
    }

    public Bomber(float x, float y) {
        super(x, y);
        textureAtlas = GameManager.playerDownStatic.getKey();
        animation = GameManager.playerDownStatic.getValue();
        code = Input.Keys.S;
        speed = 1;
    }

    @Override
    public void act(float delta) {
        killed();
        if (!isAlive()) {
            textureAtlas = GameManager.playerDeadDynamic.getKey();
            animation = GameManager.playerDeadDynamic.getValue();
            return;
        }
        // right.
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            textureAtlas = GameManager.playerRightDynamic.getKey();
            animation = GameManager.playerRightDynamic.getValue();
            if (canMoveRight()) {
                positionX += speed;
            }
            code = Input.Keys.D;
            return;
            // left
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            textureAtlas = GameManager.playerLeftDynamic.getKey();
            animation = GameManager.playerLeftDynamic.getValue();
            if (canMoveLeft()) {
                positionX -= speed;
            }
            code = Input.Keys.A;
            return;
            //bottom.
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            textureAtlas = GameManager.playerDownDynamic.getKey();
            animation = GameManager.playerDownDynamic.getValue();
            if (canMoveBottom()) {
                positionY -= speed;
            }
            code = Input.Keys.S;
            return;
        } else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            textureAtlas = GameManager.playerUpDynamic.getKey();
            animation = GameManager.playerUpDynamic.getValue();
            if (canMoveTop()) {
                positionY += speed;
            }
            code = Input.Keys.W;
            return;
        }
        switch (code) {
            case Input.Keys.A:
                textureAtlas = GameManager.playerLeftStatic.getKey();
                animation = GameManager.playerLeftStatic.getValue();
                break;
            case Input.Keys.W:
                textureAtlas = GameManager.playerUpStatic.getKey();
                animation = GameManager.playerUpStatic.getValue();
                break;
            case Input.Keys.D:
                textureAtlas = GameManager.playerRightStatic.getKey();
                animation = GameManager.playerRightStatic.getValue();
                break;
            case Input.Keys.S:
                textureAtlas = GameManager.playerDownStatic.getKey();
                animation = GameManager.playerDownStatic.getValue();
                break;
        }
    }

    protected void killed() {
        if (positionX >= 100 || positionX + 48 > 100) {
            alive = false;
            return;
        }
    }
}
