package com.mygdx.game.entities.StaticEntity.Item;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.entities.DynamicEntity.Bomber;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;
import com.mygdx.game.gamesys.GameManager;

public class FlameItem extends Item {
    protected int numberOfFlameItem;

    public FlameItem(Brick brick){
        super(brick);
        this.numberOfFlameItem = 0;
    }

    public int getNumberOfFlameItem() {
        return numberOfFlameItem;
    }

    @Override
    public void eatItem(Bomber bomber){
        if(canBreakable == true && positionX == bomber.getPositionX() && positionY == bomber.getPositionY()){
            this.broken = true;
            this.texture.dispose();
        }else{
            this.broken = false;
        }
    }

    @Override
    public void showItem(Brick brickBroken){
        if(brickBroken.isBrokenDown()){
            this.texture = GameManager.flameItem;
        }
    }

    @Override
    public void draw(Batch batch, float parentDelta){
        batch.draw(GameManager.flameItem, positionX, positionY);
    }

    @Override
    public void render(){}

    @Override
    public void dispose(){
        this.texture.dispose();
        this.numberOfFlameItem = 0;
    }
}
