package com.mygdx.game.entities.StaticEntity.Bomb;

import com.mygdx.game.entities.AnimatedEntity;
import com.mygdx.game.gamesys.GameManager;
import com.mygdx.game.map.StageScreen;


/**
 * class Bomb.
 */
public class Bomb extends AnimatedEntity {
    public boolean explored = false;
    protected StageScreen stageScreen;
    private boolean checkFlame = false;

    public Bomb(float x, float y){
        super(x, y);
        stageScreen = StageScreen.me;
        textureAtlas = GameManager.bombFlick.getKey();
        animation = GameManager.bombFlick.getValue();

    }

    public boolean isExplored() {
        return explored;
    }

    public void updateExplored() {
        checkFlame = true;
    }

    public void removeBomb() {
        explored = true;
        remove();
        stageScreen.remove(this);
    }

    public boolean isCheckFlame() {
        return checkFlame;
    }
}
