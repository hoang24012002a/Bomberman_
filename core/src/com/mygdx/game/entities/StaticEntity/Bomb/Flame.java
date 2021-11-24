package com.mygdx.game.entities.StaticEntity.Bomb;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.entities.AnimatedEntity;
import com.mygdx.game.gamesys.GameManager;
import javafx.util.Pair;


public class Flame extends AnimatedEntity {

    protected int flameLengt;  // dài trái

    public Flame(float positionX, float positionY){
        super(positionX, positionY);
        this.animation = GameManager.bombExp;
    }

    public Flame(float positionX, float positionY, Animation flameType){
        super(positionX, positionY);
        this.animation = flameType;
    }
//    add thêm 1 flame ngang vào 2 bên của bomb
//    thứ tự trả về trái-> phải
    public Pair<Flame, Flame> addHorizontalFlame(){
        return new Pair<>(new Flame(positionX-16, positionY, GameManager.flameHorizontal), new Flame(positionX+16, positionY, GameManager.flameHorizontal));
    }

//    add thêm 1 flame dọc vào 2 bên của bomb
//    thứ tự trả về dưới lên trên
    public Pair<Flame, Flame> addVerticalFlame(){
        return new Pair<>(new Flame(positionX, positionY-16, GameManager.flameVertical), new Flame(positionX, positionY+16, GameManager.flameVertical));
    }
/// trái sang phải -> trên xuống dưới
    public Array<Flame> getFlameHorizon(){
        Array<Flame> flameArray = new Array<>();
        int n = flameLengt / 16;
        for(int i = n+1; i >= 1; i--){
            if(i == n+1){
                flameArray.add(new Flame(positionX-(n+1)*16, positionY, GameManager.flameHorLeftLast));
            }else{
                flameArray.add(new Flame(positionX-i*16,positionY, GameManager.flameHorizontal ));
            }
        }
        for(int i = 1; i <= n+1; i++){
            if(i == n+1){
                flameArray.add(new Flame(positionX+(n+1)*16, positionY, GameManager.flameHorRightLast));
            }else{
                flameArray.add(new Flame(positionX+i*16, positionY, GameManager.flameHorizontal));
            }
        }
        for(int i = n+1; i >=1; i--){
            if(i == n + 1){
                flameArray.add(new Flame(positionX, positionY-(n+1)*16, GameManager.flameVerDownLast));
            }else{
                flameArray.add(new Flame(positionX, positionY-i*16, GameManager.flameVertical));
            }
        }
        for(int i = 1; i <= n+1; i++){
            if(i == n+1){
                flameArray.add(new Flame(positionX, positionY+(n+1)*16, GameManager.flameVerTopLast));
            }else{
                flameArray.add(new Flame(positionX, positionY+i*16, GameManager.flameVertical));
            }
        }
        return flameArray;
    }

    public void updateFlameLenght(){
        this.flameLengt+=16;
    }

    @Override
    public void act(float delta){
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.draw(batch, parentAlpha);
    }


//    public void getBrickBroken(Brick brick){
//        if(positionX-flameLengt <= brick.getPositionX()){
//            brick.showBrickExp();
//        }
//        if(positionX+flameLengt >= brick.getPositionX()){
//            brick.showBrickExp();
//        }
//        if(positionY-flameLengt <= brick.getPositionY()){
//            brick.showBrickExp();
//        }
//        if(positionY+flameLengt >= brick.getPositionY()){
//            brick.showBrickExp();
//        }
//    }

}
