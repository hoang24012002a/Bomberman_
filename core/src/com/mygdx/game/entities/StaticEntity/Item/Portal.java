package com.mygdx.game.entities.StaticEntity.Item;

import com.mygdx.game.entities.DynamicEntity.Bomber;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;
import com.mygdx.game.entities.StaticEntity.Tile.Grass;
import com.mygdx.game.gamesys.GameManager;

public class Portal extends Item {

    protected boolean allEnemyDie;

    public Portal(float positionX, float positionY){
        super(positionX, positionY);
        this.allEnemyDie = false;
        this.texture = GameManager.portalItem;
    }

    public Portal(Brick brick){
        super(brick);
        this.allEnemyDie = false;
        this.texture = GameManager.portalItem;
    }

    @Override
    public void eatItem(Bomber bomber){
        if(positionX == bomber.getPositionX() && positionY == bomber.getPositionY()){
            this.broken = true;
//            cần 1 biến bool all enemy die để eatPortal
//
        }else{
            this.broken = false;
        }
    }

    @Override
    public void showItem(Brick brickBroken){
        if(brickBroken.isBrokenDown()){
            this.texture = GameManager.portalItem;
        }else {
            return;
        }
    }


    //    qua man mới
    @Override
    public void act(float delta){
        if(positionX == 90 && positionY == 90 && allEnemyDie){
            getStage().getActors().removeValue(this, true);
            getStage().addActor(new Grass(positionX, positionY));
        }
    }
}
