package com.mygdx.game.entities.StaticEntity.Item;

import com.mygdx.game.entities.DynamicEntity.Bomber;
import com.mygdx.game.entities.StaticEntities;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;

public abstract class Item extends StaticEntities {

    protected boolean broken;

    public Item(Brick brick){
        super(brick.getPositionX(), brick.getPositionY());
        this.canBreakable=true;
        this.broken = false;
    }

    public Item(float positionX, float positionY){
        super(positionX, positionY);
        this.broken = false;
        this.canBreakable  = true;
    }

    public boolean isBroken() {
        return broken;
    }

//    nếu pos Bomber = pos Item xoá Item
    public abstract void eatItem(Bomber bomber);

//    show item inside brick
    public abstract void showItem(Brick brickBroken);
}
