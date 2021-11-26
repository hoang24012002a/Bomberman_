package com.mygdx.game.entities.StaticEntity.Tile;

import com.mygdx.game.entities.StaticEntities;
import com.mygdx.game.entities.StaticEntity.Bomb.Flame;
import com.mygdx.game.entities.StaticEntity.Item.BombItem;
import com.mygdx.game.entities.StaticEntity.Item.FlameItem;
import com.mygdx.game.entities.StaticEntity.Item.Item;
import com.mygdx.game.entities.StaticEntity.Item.SpeedItem;
import com.mygdx.game.gamesys.GameManager;

import java.util.concurrent.ThreadLocalRandom;


public class Brick extends StaticEntities {

    protected boolean brokenDown;             // nổ hay chưa
    protected Flame flame;
    protected boolean haveInside;
    protected Item item;
    protected int randomNum = ThreadLocalRandom.current().nextInt(0, 3);

    public Brick(float x, float y){
        super(x, y);
        this.canBreakable=true;
        this.texture= GameManager.brick;
        this.haveInside = false;
        this.brokenDown=false;
    }

    public Brick(float x, float y, boolean haveInside){
        super(x, y);
        this.canBreakable = true;
        this.haveInside = true;
        this.texture = GameManager.brick;
        this.brokenDown = false;
    }

    public void setBrokenDown(boolean brokenDown) {
        this.brokenDown = brokenDown;
    }

    public boolean isBrokenDown() {
        return brokenDown;
    }

    public boolean isHaveInside() {
        return haveInside;
    }


//    positionX >= (posFlameX-32) || positionX <= (posFlameX+32+32) || positionY >= (posFlameY-32) || positionY <= (posFlameY+32+32
//   need flame lenght and flame pos to check
    @Override
    public void act(float delta){
        float flameLeght = 32;  // là cộng cả the last
        float posFlameX = 90;
        float posFlameY  = 90;
        if(positionX == 150 && positionY == 150){
            brokenDown = true;
            getStage().getActors().removeValue(this, true);
           getStage().addActor(new Flame(positionX, positionY, GameManager.brickExp));
           if(haveInside){
                if(randomNum == 0){
                    getStage().addActor(new BombItem(positionX, positionY));
                }else if(randomNum == 1){
                    getStage().addActor(new FlameItem(positionX, positionY));
                } else {
                    getStage().addActor(new SpeedItem(positionX, positionY));
                }
           }else{
               getStage().addActor(new Grass(positionX, positionY));
           }
        }
    }
}
