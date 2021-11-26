package com.mygdx.game.entities.StaticEntity.Item;

import com.mygdx.game.entities.DynamicEntity.Bomber;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;
import com.mygdx.game.entities.StaticEntity.Tile.Grass;
import com.mygdx.game.gamesys.GameManager;

public class BombItem extends Item {

    public BombItem(Brick brick){
        super(brick);
    }

    public BombItem(float positionX, float positionY){
        super(positionX, positionY);
        this.texture = GameManager.bombItem;
    }


    //    canBreakable==true &&
    @Override
    public void eatItem(Bomber bomber){
        if(canBreakable==true && positionX == bomber.getPositionX() && positionY == bomber.getPositionY()){
            this.broken = true;
            getStage().getActors().removeValue(this, true);
        }else
        {
            this.broken = false;
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

    @Override
    public void act(float delta){
        if(positionX == 90&&positionY==90){
            getStage().getActors().removeValue(this, true);
            getStage().addActor(new Grass(positionX, positionY));
        }
    }

}
