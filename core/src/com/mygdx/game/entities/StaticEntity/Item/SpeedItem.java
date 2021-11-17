package com.mygdx.game.entities.StaticEntity.Item;

import com.mygdx.game.entities.StaticEntities;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;
import com.mygdx.game.gamesys.GameManager;

public class SpeedItem extends StaticEntities {
    private static final int SPEED_BOOST = 10;

    public SpeedItem(Brick brick){
        super(brick.getPositionX(), brick. getPositionY());
        this.canBreakable=true;
        texture = GameManager.speedItem;
    }

    public static int getSpeedBoost() {
        return SPEED_BOOST;
    }
}
