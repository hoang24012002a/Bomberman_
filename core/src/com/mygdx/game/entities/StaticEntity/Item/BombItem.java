package com.mygdx.game.entities.StaticEntity.Item;

import com.mygdx.game.entities.DynamicEntity.Bomber;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;
import com.mygdx.game.entities.StaticEntity.Tile.Grass;
import com.mygdx.game.gamesys.GameManager;
import com.mygdx.game.map.StageScreen;

public class BombItem extends Item {

    protected StageScreen stageScreen;

    public BombItem(Brick brick){
        super(brick);
    }

    public BombItem(float positionX, float positionY){
        super(positionX, positionY);
        this.texture = GameManager.bombItem;
        this.broken = false;
    }


    //    canBreakable==true &&
    @Override
    public void eatItem(float x, float y){
        if(canBreakable==true && positionX ==  x && positionY == y){
            this.broken = true;
            remove();
//            stageScreen.addActor(new Grass(positionX, positionY));
            stageScreen.remove(this);
        }else
        {
            this.broken = false;
        }
    }

    @Override
    public boolean isBroken(){
        if(this.remove()){
            System.out.println("removeBombItem");
//            stageScreen.remove(this);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void showItem(Brick brickBroken){
        if(brickBroken.isBrokenDown()){
            this.texture = GameManager.bombItem;
        }else{
            return;
        }
    }

//    @Override
//    public void act(float delta){
//        float currentBomberX = stageScreen.bomber.getPositionX();
//        float currentBomberY = stageScreen.bomber.getPositionY();
////        if(positionX == currentBomberX && positionY== currentBomberY){
//////            getStage().getActors().removeValue(this, true);
////            remove();
//////            getStage().addActor(new Grass(positionX, positionY));
////            stageScreen.remove(this);
////        }
//        eatItem(currentBomberX, currentBomberY);
//    }
}
