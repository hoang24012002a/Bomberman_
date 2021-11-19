package com.mygdx.game.entities.StaticEntity.Tile;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.entities.StaticEntities;
import com.mygdx.game.gamesys.GameManager;

public class Brick extends StaticEntities {
    TextureAtlas textureAtlas;

    public Brick(float x, float y){
        super(x, y);
        this.canBreakable=true;
        texture=GameManager.brick;
    }

    public boolean isDestroy(){
        return true;
    }

    /*@Override
    public void create(){
        texture = GameManager.brick;
        textureAtlas = GameManager.brickExp.getKey();
    }

    public void brickExploded(){

    }

    @Override
    public void draw(Batch batch, float parentDelta){
        batch.draw(texture, 30, 30);
    }

    @Override
    public void render(){
        getStage().draw();
    }

    @Override
    public void dispose(){
        texture.dispose();;
        textureAtlas.dispose();
    }*/
}
