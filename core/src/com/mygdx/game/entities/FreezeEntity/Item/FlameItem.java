package com.mygdx.game.entities.FreezeEntity.Item;

import com.mygdx.game.entities.FreezeEntity.Tile.Brick;
import com.mygdx.game.gamesys.GameManager;
import com.mygdx.game.map.StageScreen;

public class FlameItem extends Item {

    protected int numberOfFlameItem;
    protected StageScreen stageScreen;


    public FlameItem(float positionX, float positionY){
        super(positionX, positionY);
        this.stageScreen = StageScreen.me;
        this.texture =GameManager.flameItem;
    }

    public FlameItem(Brick brick){
        super(brick);
        this.numberOfFlameItem = 0;
        this.texture = GameManager.flameItem;
    }

    public int getNumberOfFlameItem() {
        return numberOfFlameItem;
    }

    @Override
    public void eatItem(float x, float y){
        if(canBreakable == true && positionX == x && positionY == y){
            this.broken = true;
            remove();
//            stageScreen.addActor(new Grass(positionX, positionY));
            stageScreen.remove(this);
        }
        if(broken){
//            TODO: man moi
        }
    }
    @Override
    public boolean isBroken() {
        if(remove()){
            System.out.println("removeFlameItem");
//            stageScreen.remove(this);
//            stageScreen.addActor(new Grass(positionX, positionY));
            return true;
        }else{
            System.out.println("not yet remove");
            return false;
        }
    }

    @Override
    public void showItem(Brick brickBroken){
        if(brickBroken.isBrokenDown()){
            this.texture = GameManager.flameItem;
        }
    }

//    @Override
//    public void act(float delta){
//        float currentBomberX = stageScreen.bomber.getPositionX();
//        float currentBomberY = stageScreen.bomber.getPositionY();
////        eatItem(currentBomberX, currentBomberY);
//
//    }
}
