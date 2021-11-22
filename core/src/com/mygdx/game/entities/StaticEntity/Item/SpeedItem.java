package com.mygdx.game.entities.StaticEntity.Item;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.entities.DynamicEntity.Bomber;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;
import com.mygdx.game.gamesys.GameManager;

public class SpeedItem extends Item {
    private static final int SPEED_BOOST = 10;

    public SpeedItem(Brick brick){
        super(brick);
    }

    public static int getSpeedBoost() {
        return SPEED_BOOST;
    }

    @Override
    public void eatItem(Bomber bomber){
        if(canBreakable == true && positionX == bomber.getPositionX() && positionY==bomber.getPositionY()){
            this.broken= true;
            this.texture.dispose();
        }else{
            this.broken = false;
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

    @Override
    public void draw(Batch batch, float parentDelta){
        batch.draw(GameManager.speedItem, positionX, positionY);
    }

    @Override
    public void render(){}

    @Override
    public void dispose(){
        this.texture.dispose();
    }
}
