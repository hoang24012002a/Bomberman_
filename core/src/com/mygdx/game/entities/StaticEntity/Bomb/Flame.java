package com.mygdx.game.entities.StaticEntity.Bomb;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.mygdx.game.entities.AnimatedEntity;
import com.mygdx.game.gamesys.GameManager;


public class Flame extends AnimatedEntity {

    protected int flameItem;
    protected final int timeExp = 3000;

    public Flame(float positionX, float positionY){
        super(positionX, positionY);
        this.textureAtlas = GameManager.bombExploded;
        this.animation = GameManager.bombExp;
        this.flameItem = 0;
    }

    public Flame(float positionX, float positionY, Animation flameType){
        super(positionX, positionY);
        this.animation = flameType;
    }

    public Flame getFlame(){
        System.out.println(positionX+"-"+positionY);
        return this;
    }

    public void updateFlameItem(){
        this.flameItem++;
    }

    public int getFlameItem(){
        return flameItem;
    }

    public void getIndexOfFlame(){
        System.out.println(getStage().getActors().size);
    }

    private int dem = 0;
    @Override
    public void act(float delta){
        final Flame _this = this;
        // TODO: 11/26/2021 nen lam theo cach nay.
        dem++;
        if (dem == 200) {
            remove();
        }
//        new Thread(
//                new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            if (getStage().getActors().notEmpty()) {
//                                Thread.sleep(timeExp);
//                                System.out.println("run");
//                                getStage().getActors().removeValue(_this, true);
//                            }
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                })
//                .start();
//        return;
    }
}
