package com.mygdx.game.entities.StaticEntity.Item;

import com.mygdx.game.entities.DynamicEntity.Bomber;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;
import com.mygdx.game.entities.StaticEntity.Tile.Grass;
import com.mygdx.game.gamesys.GameManager;
import com.mygdx.game.map.StageScreen;

public class SpeedItem extends Item {
    private static final int SPEED_BOOST = 10;
    protected StageScreen stageScreen;

    public SpeedItem(float positionX, float positionY){
        super(positionX, positionY);
        this.texture = GameManager.speedItem;
        this.broken = false;
    }

    public SpeedItem(Brick brick){
        super(brick);
    }

    public static int getSpeedBoost() {
        return SPEED_BOOST;
    }

    @Override
    public void eatItem(float x, float y){
        if(canBreakable == true && positionX == x && positionY==y){
            this.broken= true;
            remove();
            stageScreen.addActor(new Grass(positionX, positionY));
        }else{
            this.broken = false;
        }
    }

    @Override
    public boolean isBroken(){
        if(remove()){
            System.out.println("removeFlameItem");
            stageScreen.remove(this);
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
            this.texture = GameManager.speedItem;
        }else{
            return;
        }
    }

//    @Override
//    public void act(float delta){
//        float currentBomberX = stageScreen.bomber.getPositionX();
//        float currentBomberY = stageScreen.bomber.getPositionY();
//        eatItem(currentBomberX, currentBomberY);
//    }
}
