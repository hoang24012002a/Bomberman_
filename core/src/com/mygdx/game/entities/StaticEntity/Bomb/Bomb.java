package com.mygdx.game.entities.StaticEntity.Bomb;

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

    public boolean isExplored() {
        return explored;
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
//            getStage().getActors().removeValue(this, true);
            remove();
            stageScreen.remove(this);
//            stageScreen.mapMatrix[(int)positionX/32][(int)positionY/32] = ' ';
            if(this.remove()){
                if(explored){
                    System.out.println("nổ");
                    stageScreen.addFlames(new FlameManager(positionX, positionY));
                } else {
                    System.out.println("chưa nổ đâu");
                }
            }else{
                    System.out.println("chưa cút đâu");
            }
        }
    }
}
