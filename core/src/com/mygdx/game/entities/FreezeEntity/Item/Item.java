package com.mygdx.game.entities.FreezeEntity.Item;

import com.mygdx.game.entities.StaticEntities;
import com.mygdx.game.entities.FreezeEntity.Tile.Brick;
import com.mygdx.game.map.StageScreen;

public abstract class Item extends StaticEntities {

    protected boolean broken;
    protected StageScreen stageScreen;

    public Item(Brick brick){
        super(brick.getPositionX(), brick.getPositionY());
        this.canBreakable=true;
        this.broken = false;
        this.canPass = true;
        this.stageScreen = StageScreen.me;
    }

    public Item(float positionX, float positionY){
        super(positionX, positionY);
        this.broken = false;
        this.canBreakable = true;
        this.canPass = true;
        this.stageScreen = StageScreen.me;
    }

    public abstract boolean isBroken();

    //    nếu pos Bomber = pos Item xoá Item
    public abstract void eatItem(float x, float y);

    //    show item inside brick
    public abstract void showItem(Brick brickBroken);
}
