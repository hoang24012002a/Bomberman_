package com.mygdx.game.entities.StaticEntity.Item;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.entities.DynamicEntity.Bomber;
import com.mygdx.game.entities.StaticEntities;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;
import com.mygdx.game.gamesys.GameManager;

public class BombItem extends Item {


    public BombItem(Brick brick){
        super(brick);
    }

    @Override
    public void eatItem(Bomber bomber){
        if(canBreakable==true && positionX == bomber.getPositionX() && positionY == bomber.getPositionY()){
            this.broken = true;
            this.texture.dispose();
        }else
        {
            this.broken = false;
        }
    }

    @Override
    public void showItem(Brick brickBroken){
        if(brickBroken.isBrokenDown()){
            this.texture = GameManager.bombItem;
        }else{
            return;
        }
    }

    @Override
    public void draw(Batch batch, float parentDelta){
        batch.draw(GameManager.bombItem, positionX, positionY);
    }

    @Override
    public void render(){}

    @Override
    public void dispose(){
        this.texture.dispose();
    }
}
