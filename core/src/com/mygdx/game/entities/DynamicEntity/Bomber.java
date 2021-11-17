package com.mygdx.game.entities.DynamicEntity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.entities.AnimatedEntity;
import com.mygdx.game.gamesys.GameManager;

public class Bomber extends AnimatedEntity {
    private int code = 0; //Mã phím vừa bấm.

    public Bomber() {
        super();
        textureAtlas = GameManager.playerDownStatic.getKey();
        animation = GameManager.playerDownStatic.getValue();
        code = Input.Keys.S;
    }

    public Bomber(float x, float y) {
        super(x, y);
        textureAtlas = GameManager.playerDownStatic.getKey();
        animation = GameManager.playerDownStatic.getValue();
        code = Input.Keys.S;
    }

    @Override
    public void act(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            textureAtlas = GameManager.playerRightDynamic.getKey();
            animation = GameManager.playerRightDynamic.getValue();
            positionX += 1;
            code = Input.Keys.D;
            return;
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            textureAtlas = GameManager.playerLeftDynamic.getKey();
            animation = GameManager.playerLeftDynamic.getValue();
            positionX -= 1;
            code = Input.Keys.A;
            return;
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            textureAtlas = GameManager.playerDownDynamic.getKey();
            animation = GameManager.playerDownDynamic.getValue();
            positionY -= 1;
            code = Input.Keys.S;
            return;
        } else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            textureAtlas = GameManager.playerUpDynamic.getKey();
            animation = GameManager.playerUpDynamic.getValue();
            positionY += 1;
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
        }
    }
}
