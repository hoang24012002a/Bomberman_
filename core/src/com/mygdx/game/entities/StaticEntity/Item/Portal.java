package com.mygdx.game.entities.StaticEntity.Item;

import com.mygdx.game.entities.DynamicEntity.Bomber;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;
import com.mygdx.game.gamesys.GameManager;

public class Portal extends Item {
    public Portal(Brick brick){
        super(brick);
    }

    @Override
    public void eatItem(Bomber bomber){
        if(positionX == bomber.getPositionX() && positionY == bomber.getPositionY()){
            this.broken = true;
//            cần 1 biến bool all enemy die để eatPortal
//
        }else{
            this.broken = false;
        }
    }

    @Override
    public void showItem(Brick brickBroken){
        if(brickBroken.isBrokenDown()){
            this.texture = GameManager.portalItem;
        }else {
            return;
        }
    }

}
