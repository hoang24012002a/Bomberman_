package com.mygdx.game.entities.StaticEntity.Item;

import com.mygdx.game.entities.StaticEntities;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;
import com.mygdx.game.gamesys.GameManager;

public class BombItem extends StaticEntities {
    private final int anotherBomb = 1;

    public BombItem(Brick brick){
    super(brick.getPositionX(), brick.getPositionY());
        this.canBreakable=true;
        texture = GameManager.bombItem;
    }

    public int getAnotherBomb() {
        return anotherBomb;
    }
}
