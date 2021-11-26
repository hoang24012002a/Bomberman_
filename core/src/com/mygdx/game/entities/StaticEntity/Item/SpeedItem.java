package com.mygdx.game.entities.StaticEntity.Item;

import com.mygdx.game.entities.DynamicEntity.Bomber;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;
import com.mygdx.game.entities.StaticEntity.Tile.Grass;
import com.mygdx.game.gamesys.GameManager;

public class SpeedItem extends Item {
    private static final int SPEED_BOOST = 10;

    public SpeedItem(float positionX, float positionY){
        super(positionX, positionY);
        this.texture = GameManager.speedItem;
    }

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
    public void act(float delta){
        if(positionX == 90 && positionY == 90){
            getStage().getActors().removeValue(this, true);
            getStage().addActor(new Grass(positionX, positionY));
        }
    }
}
