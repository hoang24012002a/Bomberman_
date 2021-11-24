package com.mygdx.game.entities.StaticEntity.Bomb;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.gamesys.GameManager;

public class FlameManager extends Flame {
    protected Flame center;
    protected Array<Flame> flames;
    public FlameManager(float positionX, float positionY){
        super(positionX, positionY);
        this.center = new Flame(positionX, positionY);
        this.flames = new Array<>();
        //flames.add(new Flame(positionX, positionY));
        flames.add(new Flame(positionX, positionY+16, GameManager.flameVerTopLast));
        flames.add(new Flame(positionX, positionY-16, GameManager.flameVerDownLast));
        flames.add(new Flame(positionX-16, positionY, GameManager.flameHorLeftLast));
        flames.add(new Flame(positionX+16, positionY, GameManager.flameHorRightLast));
        out();
    }

    public void out(){
//    System.out.println(center.getPositionX());
    System.out.println(flames.get(0).getPositionX());
    System.out.println(flames.get(1).getPositionX());
    }

    public Array<Flame> getFlames() {
        return flames;
    }

    public int sizeFla(){
        int n = getFlames().size;
        return n;
    }

//    public Array<Flame> vcl(){
//        int n = center.flameLengt/16;
//        flames.add(center);
//        flames.add(new Flame(center.getPositionX()-(n+1)*16,center.getPositionY(), GameManager.flameHorLeftLast));
//        flames.add(new Flame(center.getPositionX()+(n+1)*16,center.getPositionY(), GameManager.flameHorRightLast));
//        flames.add(new Flame(center.getPositionX(), center.getPositionY()-(n+1)*16, GameManager.flameVerDownLast));
//        flames.add(new Flame(center.getPositionX(), center.getPositionY()+(n+1)*16, GameManager.flameVerTopLast));
//        return flames;
//    }
}
