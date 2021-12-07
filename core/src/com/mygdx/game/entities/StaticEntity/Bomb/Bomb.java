package com.mygdx.game.entities.StaticEntity.Bomb;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.entities.AnimatedEntity;
import com.mygdx.game.gamesys.GameManager;
import com.mygdx.game.map.StageScreen;


/**
 * class Bomb.
 */
public class Bomb extends AnimatedEntity {
    public boolean explored = false;
    protected final int timeToExplode = 3000; // 2000ms
    protected int numberOfBomb = 1;
    protected StageScreen stageScreen;

    public Bomb(float x, float y){
        super(x, y);
        stageScreen = StageScreen.me;
        textureAtlas = GameManager.bombFlick.getKey();
        animation = GameManager.bombFlick.getValue();

    }

    public int getNumberOfBomb() {
        return numberOfBomb;
    }

    private int dem = 0;
    @Override
    public void act(float delta) {
        textureAtlas = GameManager.bombFlick.getKey();
        animation = GameManager.bombFlick.getValue();
        //TODO: nen lam theo cach nay.
        //TODO: tại sao khi explore = true lại không hoạt động???
        dem++;
        if (dem == 100 && getStage().getActors().notEmpty()) {
            dem = 0;
            explored = true;
            remove();
            //this.
            //stageScreen.addBomb(this);
            //stageScreen.remove(_this);
            if(explored){
                System.out.println("true");
            }
        }
        return;
    }

    public boolean isExplored() {
        return explored;
    }
}
