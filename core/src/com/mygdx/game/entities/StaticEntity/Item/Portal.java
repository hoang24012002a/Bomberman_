package com.mygdx.game.entities.StaticEntity.Item;

import com.mygdx.game.entities.StaticEntities;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;
import com.mygdx.game.gamesys.GameManager;

public class Portal extends StaticEntities {
    public Portal(Brick brick){
        super(brick.getPositionX(), brick.getPositionY());
        this.canBreakable=true;
        texture = GameManager.portalItem;
    }
}
