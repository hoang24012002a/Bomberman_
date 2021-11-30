package com.mygdx.game.entities.StaticEntity.Bomb;

import com.mygdx.game.entities.AnimatedEntity;
import com.mygdx.game.gamesys.GameManager;
import com.mygdx.game.map.StageScreen;


/**
 * class Bomb.
 */
public class Bomb extends AnimatedEntity {
    private boolean explored = false;
    protected final int timeToExplode = 3000; // 2000ms
    protected int numberOfBomb = 1;
    private StageScreen stageScreen;

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
        final Bomb _this = this;
        textureAtlas = GameManager.bombFlick.getKey();
        animation = GameManager.bombFlick.getValue();
        //TODO: nen lam theo cach nay.
        //TODO: tại sao khi explore = true lại không hoạt động???
        dem++;
        if (dem == 100 && getStage().getActors().notEmpty()) {
            dem = 0;
            explored = true;
            remove();
            if(explored){
                System.out.println("true");
                stageScreen.addFlames(new FlameManager(positionX, positionY));
            }
        }
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try{
//                    Thread.sleep(1000);
//                    remove();
//                    stageScreen.addFlames(new FlameManager(positionX, positionY));
//                } catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        return;
    }

    public boolean isExplored() {
        return explored;
    }
}
