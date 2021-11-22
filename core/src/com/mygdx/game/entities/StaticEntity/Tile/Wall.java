package com.mygdx.game.entities.StaticEntity.Tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.mygdx.game.entities.StaticEntities;
import com.mygdx.game.gamesys.GameManager;


public class Wall extends StaticEntities {
    public Wall(float x, float y){
        super(x, y);
        this.canBreakable=false;
        texture = GameManager.wall;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(GameManager.wall, positionX, positionY);
    }

    @Override
    public void render(){}
    @Override
    public void dispose() {
        texture.dispose();
    }
}
