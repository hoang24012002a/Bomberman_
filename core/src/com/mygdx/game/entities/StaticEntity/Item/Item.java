package com.mygdx.game.entities.StaticEntity.Item;

import com.mygdx.game.entities.DynamicEntity.Bomber;
import com.mygdx.game.entities.StaticEntities;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;
import com.mygdx.game.gamesys.GameManager;

public abstract class Item extends StaticEntities {

    protected boolean broken;

    public Item(Brick brick){
        super(brick.getPositionX(), brick.getPositionY());
        this.canBreakable=false;
        this.broken = false;
        this.texture = GameManager.brick;
    }

    public boolean isBroken() {
        return broken;
    }

//    nếu pos Bomber = pos Item xoá Item
    public abstract void eatItem(Bomber bomber);

//    show item inside brick
    public abstract void showItem(Brick brickBroken);
}
