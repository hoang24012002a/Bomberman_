package com.mygdx.game.entities.StaticEntity.Bomb;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.gamesys.GameManager;

public class FlameManager extends Flame {
    protected Array<Flame> flames;
    protected static int flameItem = 2;
    protected final int timeExp = 3000;

    public FlameManager(float positionX, float positionY){
        super(positionX, positionY);
        this.flames = new Array<>(flameItem*2+5);
        addFlame();
        checkExploded();
        outPos();
    }
    public FlameManager(Flame flame){
        super(flame.getPositionX(), flame.getPositionY());
        this.flames = new Array<>(flameItem*2+5);
        addFlame();
        outPos();
    }


    public void addFlame(){
        flames.add(new Flame(positionX, positionY, GameManager.bombExp));
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

    public void removeLeftFlame(){
        /**
         * TO DO:  get positionX of brick and wall nearest
         * */
        float posXNearest = 236;
        Array.ArrayIterator<Flame> iterator = flames.iterator();
        if(positionX-getFlameLengt() <= posXNearest){
            while (iterator.hasNext()){
                Flame temp  = iterator.next();
                if(temp.getPositionX() <= posXNearest){
                    flames.removeValue(temp, true);
                }
            }
        }
    }

    public void removeRightFlame(){
        /**
         * TO DO: get positionX of brick and wall nearest
         * */
        float posXNearest = 364;
        Array.ArrayIterator<Flame> iterator = flames.iterator();
        if(positionX+getFlameLengt() >= posXNearest){
            while (iterator.hasNext()){
                Flame temp  = iterator.next();
                if(temp.getPositionX() >= posXNearest){
                    flames.removeValue(temp, true);
                }
            }
        }
    }

    public void removeTopFlame(){
        /**
         * TO DO: get positionY of brick and wall nearest
         * */
        float posYNearest = 364;
        Array.ArrayIterator<Flame> iterator = flames.iterator();
        if(positionY+getFlameLengt()>=posYNearest){
            while (iterator.hasNext()){
                Flame temp = iterator.next();
                if(temp.getPositionY()>=posYNearest){
                    flames.removeValue(temp, true);
                }
            }
        }
    }

    public void removeDownFLame(){
        /**
         * TO DO: get positionY of brick and wall nearest
         * */
        float posYNearest = 236;
        Array.ArrayIterator<Flame> iterator = flames.iterator();
        if((positionY-getFlameLengt())<=posYNearest){
            while (iterator.hasNext()){
                Flame temp = iterator.next();
                if(temp.getPositionY() <= posYNearest){
                    flames.removeValue(temp, true);
                }
            }
        }
    }

    public float getFlameLengt(){
        return (FlameManager.flameItem+1)*32;
    }

    public void checkExploded(){
        removeLeftFlame();
        removeRightFlame();
        removeTopFlame();
        removeDownFLame();
    }

    public void outPos(){
        for(int i = 0; i < flames.size; i++){
            System.out.println(flames.get(i).getPositionX()+"-"+ flames.get(i).getPositionY());
        }
    }

    public Array<Flame> getFlames() {
        return flames;
    }

    public int sizeFla(){
        return flames.size;
    }

    public void updateItem(){
        flameItem++;
    }

    @Override
    public void act(float delta){
        final FlameManager flameManager = this;
        final Array<Flame> _this = flames;
    new Thread(
            new Runnable() {
              @Override
              public void run() {
                try {
                  Thread.sleep(timeExp);
                  getStage().getActors().removeAll(_this, true);
                  flames.removeAll(flames, true);
                  System.out.println("run");
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            })
        .start();
    }
}
