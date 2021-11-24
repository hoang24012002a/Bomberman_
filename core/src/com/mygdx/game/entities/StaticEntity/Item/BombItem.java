package com.mygdx.game.entities.StaticEntity.Item;

import com.mygdx.game.entities.DynamicEntity.Bomber;
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

}
