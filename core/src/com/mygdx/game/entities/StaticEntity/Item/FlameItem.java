package com.mygdx.game.entities.StaticEntity.Item;

import com.mygdx.game.entities.DynamicEntity.Bomber;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;
import com.mygdx.game.entities.StaticEntity.Tile.Grass;
import com.mygdx.game.gamesys.GameManager;

public class FlameItem extends Item {

    protected int numberOfFlameItem;


    public FlameItem(float positionX, float positionY){
        super(positionX, positionY);
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
    public void eatItem(Bomber bomber){
        if(canBreakable == true && positionX == bomber.getPositionX() && positionY == bomber.getPositionY()){
            this.broken = true;
            this.texture.dispose();
        }else{
            this.broken = false;
        }
    }

    @Override
    public void showItem(Brick brickBroken){
        if(brickBroken.isBrokenDown()){
            this.texture = GameManager.flameItem;
        }
    }

    @Override
    public void act(float delta){
        if(positionX == 90 && positionY == 90){
            getStage().getActors().removeValue(this, true);
            getStage().addActor(new Grass(positionX, positionY));
        }
    }

}
