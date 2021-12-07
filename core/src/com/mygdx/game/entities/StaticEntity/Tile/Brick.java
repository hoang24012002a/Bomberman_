package com.mygdx.game.entities.StaticEntity.Tile;

import com.badlogic.gdx.Game;
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
    protected final Flame brickEXP = new Flame(positionX, positionY, GameManager.brickExp);

    public Brick(float x, float y){
        super(x, y);
        this.canBreakable=true;
        this.stageScreen = StageScreen.me;
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

    public boolean checkExplode(){
        // TODO: get flame pos and length
        float flameLeght = FlameManager.getFlameLengt();  // là cộng cả the last
        // TODO: get pos and calculate what brick need exp
        /**Left explode**/
        if(stageScreen.getAt(positionX+32, positionY) instanceof Flame){
            if(((Flame) stageScreen.getAt(positionX+32, positionY)).isHorizontalFlame() ||
                    ((Flame) stageScreen.getAt(positionX+32, positionY)).isCenterFlame()){
                return true;
            }else{
                System.out.println(false);
                return false;
            }

        }
        /**Right explode**/
        else if(stageScreen.getAt(positionX-32, positionY) instanceof Flame){
            if(((Flame) stageScreen.getAt(positionX-32, positionY)).isHorizontalFlame() ||
                    ((Flame) stageScreen.getAt(positionX-32, positionY)).isCenterFlame()){
                return true;
            }else{
                System.out.println(false);
                return false;
            }
        }
        /**Down explode**/
        else if(stageScreen.getAt(positionX, positionY+32) instanceof Flame){
            if(((Flame) stageScreen.getAt(positionX, positionY+32)).isVerticalFlame()||
                    ((Flame) stageScreen.getAt(positionX, positionY+32)).isCenterFlame()){
                return true;
            }else{
                System.out.println(false);
                return false;
            }
        }
        /**Up explode**/
        else if(stageScreen.getAt(positionX, positionY-32) instanceof Flame){
            if(((Flame) stageScreen.getAt(positionX, positionY-32)).isVerticalFlame()||
                    ((Flame) stageScreen.getAt(positionX, positionY-32)).isCenterFlame()){
                return true;
            }else{
                System.out.println(false);
                return false;
            }
        }else{
            return false;
        }
    }

//    public void changeChar(){
//        stageScreen.getAt(positionX, positionY);
//        char space = " ";
//        stageScreen.mapMatrix[(int)positionX/32][(int) positionY/32] = space;
//    }


    //    positionX >= (posFlameX-32) || positionX <= (posFlameX+32+32) || positionY >= (posFlameY-32) || positionY <= (posFlameY+32+32
//   need flame lenght and flame pos to check
    private int dem = 0;
    @Override
    public void act(float delta){
//        // TODO: get flame pos and length
//        float flameLeght = FlameManager.getFlameLengt();  // là cộng cả the last
//        // TODO: get pos and calculate what brick need exp
//        final float toTestX = FlameManager.getFlameCenter().getPositionX();
//        final float toTestY = FlameManager.getFlameCenter().getPositionY();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try{
//                    if(checkExplode()){
//                        brokenDown = true;
//                        remove();
//                        stageScreen.addActor(new Flame(positionX, positionY, GameManager.brickExp));
//                    }
//                    Thread.sleep(1000);
//                    if(brokenDown){
//                        if(haveInside){
//                            if(randomNum == 0){
//                                stageScreen.addActor(new BombItem(positionX, positionY));
//                            }else if(randomNum == 1){
//                                stageScreen.addActor(new FlameItem(positionX, positionY));
//                            } else {
//                                stageScreen.addActor(new SpeedItem(positionX, positionY));
//                            }
//                        }else{
//                            stageScreen.addActor(new Grass(positionX, positionY));
//                        }
//                    }
//                } catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                if(checkExplode()){
//                    brokenDown = true;
//                    remove();
//                    System.out.println("exp");
//                    stageScreen.addActor(new Flame(positionX, positionY, GameManager.brickExp));
//                }try{
//                    Thread.sleep(3000);
//                    if(brokenDown){
//                        if(haveInside){
//                            if(randomNum == 0){
//                                stageScreen.addActor(new BombItem(positionX, positionY));
//                            }else if(randomNum == 1){
//                                stageScreen.addActor(new FlameItem(positionX, positionY));
//                            }else {
//                                stageScreen.addActor(new SpeedItem(positionX, positionY));
//                            }
//                        }else{
////                            stageScreen.mapMatrix[(int)positionX/32][(int)positionY/32] = (String) " ";
//                            stageScreen.addActor(new Grass(positionX, positionY));
//                        }
//                    }
//                } catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//            }
//        }).start();
        if(checkExplode()){
            brokenDown = true;
            stageScreen.remove(this);
            System.out.println("exploded");
            stageScreen.addActor(brickEXP);
            dem++;
        }if(dem == 50 && brokenDown){
            if(haveInside){
                if(randomNum == 0){
                    stageScreen.addActor(new BombItem(positionX, positionY));
                }else if(randomNum == 1){
                    stageScreen.addActor(new FlameItem(positionX, positionY));
                }else {
                    stageScreen.addActor(new SpeedItem(positionX, positionY));
                }
            }else{
//                stageScreen.mapMatrix[(int)positionX/32][(int)positionY/32] = ' ';
//                stageScreen.addActor(new Grass(positionX, positionY));
            }
        }
    }
}