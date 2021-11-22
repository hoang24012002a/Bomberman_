package com.mygdx.game.entities.StaticEntity.Tile;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.entities.StaticEntities;
import com.mygdx.game.gamesys.GameManager;

public class Brick extends StaticEntities {
    protected TextureAtlas textureAtlas;
    protected boolean brokenDown;             // nổ hay chưa
    protected Animation animation;

    public Brick(float x, float y){
        super(x, y);
        this.canBreakable=true;
        texture=GameManager.brick;
        this.brokenDown=false;
    }

    public boolean isDestroy(){
        return true;
    }

    public void setBrokenDown(boolean brokenDown) {
        this.brokenDown = brokenDown;
    }

    public boolean isBrokenDown() {
        return brokenDown;
    }

    public void showBrickExp(){
        if(isBrokenDown()){
            this.texture.dispose();
            this.animation = GameManager.brickExp;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {}

    @Override
    public void render(){}
    @Override
    public void dispose() {
        texture.dispose();
        textureAtlas.dispose();
    }
}
