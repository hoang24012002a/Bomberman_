package com.mygdx.game.entities.StaticEntity.Bomb;


import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.entities.AnimatedEntity;
import com.mygdx.game.entities.DynamicEntity.Character;
import com.mygdx.game.entities.StaticEntity.Tile.Grass;
import com.mygdx.game.gamesys.GameManager;
import com.mygdx.game.map.StageScreen;


public class Flame extends AnimatedEntity {

    protected final int timeExp = 3000;
    protected StageScreen stageScreen;
    protected boolean burned = false;

    public Flame(float positionX, float positionY){
        super(positionX, positionY);
        this.stageScreen = StageScreen.me;
        this.textureAtlas = GameManager.bombExploded;
        this.animation = GameManager.bombExp;
    }

    public Flame(float positionX, float positionY, Animation flameType){
        super(positionX, positionY);
        this.stageScreen = StageScreen.me;
        this.animation = flameType;
    }

    public Flame getFlame(){
        System.out.println(positionX+"-"+positionY);
        return this;
    }

    /**
     * 3 method bên dưới để check xem nó là loại flame gì để lm nổ brick
     * phải lm 3 method này vì không thể lấy position của flameManager ở class Brick
     * */
    public boolean isHorizontalFlame(){
        if(this.animation == GameManager.flameHorizontal){
            return true;
        }else{
            return false;
        }
    }

    public boolean isVerticalFlame(){
        if(this.animation == GameManager.flameVertical){
            return true;
        }else{
            return false;
        }
    }

    public boolean isCenterFlame(){
        if(this.animation == GameManager.bombExp){
            return true;
        }else{
            return false;
        }
    }

    public void getIndexOfFlame(){
        System.out.println(getStage().getActors().size);
    }

    private int dem = 0;
    @Override
    public void act(float delta){
        final Flame _this = this;
        // TODO: 11/26/2021 nen lam theo cach nay.
        dem++;
        if (dem == 1) {
            Actor actor = stageScreen.getAt(positionX + 2 , positionY + 2);
            Actor actor1 = stageScreen.getAt(positionX + 30, positionY + 2);
            Actor actor2 = stageScreen.getAt(positionX + 2, positionY + 30);
            Actor actor3 = stageScreen.getAt(positionX + 2, positionY + 30);
            if (actor instanceof Character) {
                ((Character) actor).killed();
            }
            if (actor1 instanceof Character) {
                ((Character) actor1).killed();
            }
            if (actor2 instanceof Character) {
                ((Character) actor2).killed();
            }
            if (actor3 instanceof Character) {
                ((Character) actor3).killed();
            }
        } else if (dem == 50) {
            dem = 0;
            burned = true;
            if(burned){
                System.out.println("removed");
            }else{
                System.out.println("not yet");
            }
            remove();
            stageScreen.remove(this);
        }
    }
}