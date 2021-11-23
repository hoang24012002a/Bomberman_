package com.mygdx.game.entities.StaticEntity.Bomb;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.entities.AnimatedEntity;
import com.mygdx.game.entities.StaticEntity.Item.FlameItem;
import com.mygdx.game.gamesys.GameManager;


/**
 * class Bomb.
 */
public class Bomb extends AnimatedEntity {

    protected final float timeToExplode = 2000; // 2000ms

    public Bomb(float x, float y){
        super(x, y);
        textureAtlas = GameManager.bombFlicker.getKey();
        animation = GameManager.bombFlicker.getValue();
        // đang tìm cách để set thời gian nổ
        animation = GameManager.bombExp.getValue();
    }

}
