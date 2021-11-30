package com.mygdx.game.entities.StaticEntity.Tile;

import com.mygdx.game.entities.StaticEntities;
import com.mygdx.game.entities.StaticEntity.Bomb.Bomb;
import com.mygdx.game.entities.StaticEntity.Bomb.Flame;
import com.mygdx.game.entities.StaticEntity.Bomb.FlameManager;
import com.mygdx.game.entities.StaticEntity.Item.BombItem;
import com.mygdx.game.entities.StaticEntity.Item.FlameItem;
import com.mygdx.game.entities.StaticEntity.Item.Item;
import com.mygdx.game.entities.StaticEntity.Item.SpeedItem;
import com.mygdx.game.gamesys.GameManager;
import com.mygdx.game.map.StageScreen;

import java.util.concurrent.ThreadLocalRandom;


public class Brick extends StaticEntities {

    protected boolean brokenDown;             // nổ hay chưa
    protected boolean haveInside;
    protected Item item;
    protected int randomNum = ThreadLocalRandom.current().nextInt(0, 3); // to random Item
    protected StageScreen stageScreen;

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
        // TODO: get flame pos and length
        float flameLeght = FlameManager.getFlameLengt();  // là cộng cả the last
        // TODO: get pos and calculate what brick need exp
        final float toTestX = 150;
        final float toTestY = 150;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    if(positionX == toTestX && positionY == toTestY){
                        brokenDown = true;
                        remove();
                        stageScreen.addActor(new Flame(positionX, positionY, GameManager.brickExp));
                    }
                    Thread.sleep(1000);
                    if(brokenDown){
                        if(haveInside){
                            if(randomNum == 0){
                                stageScreen.addActor(new BombItem(positionX, positionY));
                            }else if(randomNum == 1){
                                stageScreen.addActor(new FlameItem(positionX, positionY));
                            } else {
                                stageScreen.addActor(new SpeedItem(positionX, positionY));
                            }
                        }else{
                            stageScreen.addActor(new Grass(positionX, positionY));
                        }
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
