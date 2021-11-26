package com.mygdx.game.entities.StaticEntity.Tile;

import com.mygdx.game.entities.StaticEntities;
import com.mygdx.game.gamesys.GameManager;


public class Wall extends StaticEntities {
    public Wall(float x, float y){
        super(x, y);
        this.canBreakable=false;
        this.texture = GameManager.wall;
    }

}
