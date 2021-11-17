package com.mygdx.game.entities.StaticEntity.Item;

import com.mygdx.game.entities.StaticEntities;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;
import com.mygdx.game.gamesys.GameManager;

public class FlameItem extends StaticEntities {

    public FlameItem(Brick brick){
        super(brick.getPositionX(), brick.getPositionY());
        this.canBreakable=true;
        texture = GameManager.flameItem;
    }


}
