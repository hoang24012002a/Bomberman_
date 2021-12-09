package com.mygdx.game.entities.StaticEntity.Bomb;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.entities.AnimatedEntity;
import com.mygdx.game.gamesys.GameManager;
import com.mygdx.game.map.StageScreen;
import javafx.util.Pair;

import java.util.ArrayList;

public class FlameManager extends Flame {
    public Array<Flame> flames;
    protected static int flameItem = 0;
    protected final int timeExp = 3000;
    protected StageScreen stageScreen;

    public FlameManager(float positionX, float positionY){
        super(positionX, positionY);
        this.stageScreen = StageScreen.me;
        this.flames = new Array<>(flameItem*2+5);
        addFlame();
        checkExploded();
        System.out.println(sizeFlame());
//        outPos();
    }
    public FlameManager(Flame flame){
        super(flame.getPositionX(), flame.getPositionY());
        this.flames = new Array<>(flameItem*2+5);
        addFlame();
    }


    public void addFlame(){
        flames.add(new Flame(positionX, positionY));
        flames.add(new Flame(positionX, positionY+(flameItem+1)*32, GameManager.flameVerTopLast));
        flames.add(new Flame(positionX, positionY-(flameItem+1)*32, GameManager.flameVerDownLast));
        flames.add(new Flame(positionX-(flameItem+1)*32, positionY, GameManager.flameHorLeftLast));
        flames.add(new Flame(positionX+(flameItem+1)*32, positionY, GameManager.flameHorRightLast));
        // dọc trên + ngang phải
        for(int i = 1; i <=flameItem; i++){
            flames.add(new Flame(positionX, positionY+i*32, GameManager.flameVertical));
            flames.add(new Flame(positionX+i*32, positionY, GameManager.flameHorizontal));
        }
        // dọc dưới + ngang trái
        for(int i = flameItem; i>=1; i--){
            flames.add(new Flame(positionX, positionY-i*32, GameManager.flameVertical));
            flames.add(new Flame(positionX-i*32, positionY, GameManager.flameHorizontal));
        }
    }

    public void removeLeftFlame(float posXNearestLeft){
        /**
         * TO DO:  get positionX of brick and wall nearest
         * */
        Array.ArrayIterator<Flame> iterator = flames.iterator();
        if(positionX-getFlameLengt() <= posXNearestLeft){
            while (iterator.hasNext()){
                Flame temp  = iterator.next();
                if(temp.getPositionX() <= posXNearestLeft){
                    flames.removeValue(temp, true);
                }
            }
        }
    }

    public void removeRightFlame(float posXNearestRight){
        /**
         * TO DO: get positionX of brick and wall nearest
         * */
        Array.ArrayIterator<Flame> iterator = flames.iterator();
        if(positionX+getFlameLengt() >= posXNearestRight){
            while (iterator.hasNext()){
                Flame temp  = iterator.next();
                if(temp.getPositionX() >= posXNearestRight){
                    flames.removeValue(temp, true);
                }
            }
        }
    }

    public void removeTopFlame(float posYNearestTop){
        /**
         * TO DO: get positionY of brick and wall nearest
         * */
        Array.ArrayIterator<Flame> iterator = flames.iterator();
        if(positionY+getFlameLengt()>=posYNearestTop){
            while (iterator.hasNext()){
                Flame temp = iterator.next();
                if(temp.getPositionY()>=posYNearestTop){
                    flames.removeValue(temp, true);
                }
            }
        }
    }

    public void removeDownFLame(float posYNearestDown){
        /**
         * TO DO: get positionY of brick and wall nearest
         * */
        Array.ArrayIterator<Flame> iterator = flames.iterator();
        if((positionY-getFlameLengt())<=posYNearestDown){
            while (iterator.hasNext()){
                Flame temp = iterator.next();
                if(temp.getPositionY() <= posYNearestDown){
                    flames.removeValue(temp, true);
                }
            }
        }
    }

    public static float getFlameLengt(){
        return (FlameManager.flameItem+1)*32;
    }


    public void checkExploded(){
        ArrayList<Actor> nearest = stageScreen.bombArounds(positionX, positionY);
        removeLeftFlame(nearest.get(3).getX());
        removeRightFlame(nearest.get(2).getX());
        removeTopFlame(nearest.get(0).getY());
        removeDownFLame(nearest.get(1).getY());
    }

    //    để check xem chỉ cần 1 cái nổ rồi thì sẽ remove nó trong class Bomber
    public boolean isBurned(){
        for(int i = 0; i < sizeFlame(); i++){
//            System.out.println("burned");
            if(getFlames().get(i).burned){
                return true;
            }
        }
        return false;
    }

    //    để check vị trí của flame xem có đúng không
    public void outPos(){
        for(int i = 0; i < flames.size; i++){
            System.out.println(flames.get(i).getPositionX()+"-"+ flames.get(i).getPositionY());
        }
    }

    public Array<Flame> getFlames() {
        return flames;
    }

    public int sizeFlame(){
        return flames.size;
    }


    public static void updateItem(){
        flameItem++;
    }

    public static void beginItem(){
        flameItem = 0;
    }

    //    nếu phát sinh vấn đề
    private int dem = 0;
    @Override
    public void act(float delta){
//        final FlameManager flameManager = this;
//        final Array.ArrayIterator<Flame> iterator = flames.iterator();
//        new Thread(
//                new Runnable() {
//                  @Override
//                  public void run() {
//                        stageScreen.addFlames(flameManager);
//                  }
//                })
//            .start();
//        dem++;
//        if (dem == 200) {
//            Array.ArrayIterator<Flame> iterator = flames.iterator();
//            while (iterator.hasNext()){
//                stageScreen.remove(iterator.next());
//            }
//        }
//        final FlameManager flameManager = this;
//        new Thread(
//                new Runnable() {
//                    @Override
//                    public void run() {
//                        try{
//                            Thread.sleep(1800);
//                            stageScreen.addFlames(flameManager);
//                        }catch (InterruptedException e){
//                            e.printStackTrace();
//                        }
//                    }
//                })
//                .start();
    }
}