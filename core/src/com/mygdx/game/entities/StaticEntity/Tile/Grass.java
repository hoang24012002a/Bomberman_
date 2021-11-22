package com.mygdx.game.entities.StaticEntity.Tile;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.entities.StaticEntities;
import com.mygdx.game.gamesys.GameManager;

public class Grass extends StaticEntities {
    public Grass(float x, float y){
        super(x, y);
        this.canBreakable=false;
        texture= GameManager.grass;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(GameManager.grass, positionX, positionY);
    }

    @Override
    public void render(){}

    public void dispose() {
        texture.dispose();
    }
}
