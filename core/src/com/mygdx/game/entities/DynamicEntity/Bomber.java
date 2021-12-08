package com.mygdx.game.entities.DynamicEntity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.entities.DynamicEntity.enemy.Enemy;
import com.mygdx.game.entities.FreezeEntity.Bomb.Bomb;
import com.mygdx.game.entities.FreezeEntity.Bomb.Flame;
import com.mygdx.game.entities.FreezeEntity.Bomb.FlameManager;
import com.mygdx.game.entities.FreezeEntity.Item.*;
import com.mygdx.game.gamesys.GameManager;

import java.util.ArrayList;

public class Bomber extends Character {
    private int code = 0; //Mã phím vừa bấm.
    private int maxBomb = 5;
    private ArrayList<Bomb> listBomb;
    public static boolean nextLevel = false;
    //  thêm một array flame manager để add và xoá như arraylistBom
    //  thêm một array flame manager để add và xoá như arraylistBom
    private ArrayList<FlameManager> listFlame;
    public static Bomber bomber;

    public Bomber(float x, float y) {
        super(x, y);
        bomber = this;
        listBomb = new ArrayList<>();
        listFlame = new ArrayList<>();
        textureAtlas = GameManager.playerDownStatic.getKey();
        animation = GameManager.playerDownStatic.getValue();
        code = Input.Keys.S;
        speed = 5.0f;   // fix hered
    }

    private int timeKill = 0;
    @Override
    public void act(float delta) {
        removeBombExplored();
        removeFlameBurned();
        if (!alive) {
            timeKill++;
            textureAtlas = GameManager.playerDeadDynamic.getKey();
            animation = GameManager.playerDeadDynamic.getValue();
            if (timeKill == 10) {
                GameManager.playerDeadSound.play();
            }
            if (timeKill == 92) {
                System.out.println("workkkkkkkkkkk");
                stageScreen.live = false;
                removeFlameBurned();
                //removeFlame();
                alive = true;
                timeKill = 0;
                remove();
                //stageScreen.remove(this);
            }
            return;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            moveRight();
            if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
                System.out.println("press Space");
                if(canPlaceBomb()){
                    placeBomb();
                }
            }
            return;
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            moveLeft();
            if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
                System.out.println("press Space");
                if(canPlaceBomb()){
                    placeBomb();
                }
            }
            return;
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            moveBottom();
            if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
                System.out.println("press Space");
                if(canPlaceBomb()){
                    placeBomb();
                }
            }
            return;
        } else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            moveTop();
            if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
                System.out.println("press Space");
                if(canPlaceBomb()){
                    placeBomb();
                }
            }
            return;
        }
        switch (code) {
            case Input.Keys.A:
                textureAtlas = GameManager.playerLeftStatic.getKey();
                animation = GameManager.playerLeftStatic.getValue();
                break;
            case Input.Keys.W:
                textureAtlas = GameManager.playerUpStatic.getKey();
                animation = GameManager.playerUpStatic.getValue();
                break;
            case Input.Keys.D:
                textureAtlas = GameManager.playerRightStatic.getKey();
                animation = GameManager.playerRightStatic.getValue();
                break;
            case Input.Keys.S:
                textureAtlas = GameManager.playerDownStatic.getKey();
                animation = GameManager.playerDownStatic.getValue();
                break;
        }
    }

    @Override
    public float getX() {
        return positionX;
    }
    @Override
    public float getY() {
        return positionY;
    }


    public void setX(float X) {
        positionX = X;
    }

    public void setY(float Y) {
        positionY = Y;
    }

    @Override
    protected void moveRight() {
        textureAtlas = GameManager.playerRightDynamic.getKey();
        animation = GameManager.playerRightDynamic.getValue();
        if (canMoveRight()) {
            Actor actor = stageScreen.getAt(positionX + 33, positionY + 16);
            eadItem(actor);
            if (!isAlive(actor))  {
                killed();
                return;
            }
            positionY += (Math.round(positionY / 32) * 32 - positionY);
            positionX += speed;
        }
        setPositionInMatrix(positionX, positionY, 'p');
        code = Input.Keys.D;
    }

    @Override
    protected void moveLeft() {
        textureAtlas = GameManager.playerLeftDynamic.getKey();
        animation = GameManager.playerLeftDynamic.getValue();
        if (canMoveLeft()) {
            Actor actor = stageScreen.getAt(positionX - 1, positionY + 16);
            eadItem(actor);
            if (!isAlive(actor))  {
                killed();
                return;
            }
            positionY += (Math.round(positionY / 32) * 32 - positionY);
            positionX -= speed;
        }
        setPositionInMatrix(positionX, positionY, 'p');
        code = Input.Keys.A;
    }

    @Override
    protected void moveTop() {
        textureAtlas = GameManager.playerUpDynamic.getKey();
        animation = GameManager.playerUpDynamic.getValue();
        if (canMoveTop()) {
            Actor actor = stageScreen.getAt(positionX + 16, positionY + 33);
            eadItem(actor);
            if (!isAlive(actor))  {
                killed();
                return;
            }
            positionX += (Math.round(positionX / 32) * 32 - positionX);
            positionY += speed;
        }
        setPositionInMatrix(positionX, positionY, 'p');
        code = Input.Keys.W;
    }

    @Override
    protected void moveBottom() {
        textureAtlas = GameManager.playerDownDynamic.getKey();
        animation = GameManager.playerDownDynamic.getValue();
        if (canMoveBottom()) {
            Actor actor = stageScreen.getAt(positionX + 16, positionY - 1);
            eadItem(actor);
            if (!isAlive(actor))  {
                killed();
                return;
            }
            positionX += (Math.round(positionX / 32) * 32 - positionX);
            positionY -= speed;
        }
        setPositionInMatrix(positionX, positionY, 'p');
        code = Input.Keys.S;
    }

    @Override
    public boolean isAlive(Actor actor) {
        if (!alive) {
            return false;
        }
        if (actor instanceof Enemy || actor instanceof Flame) {
            return false;
        }
        return true;
    }

    private void eadItem(Actor item) {
            if (!(item instanceof Item) || !((Item) item).isBroken()) {
                return;
            }
            //System.out.println("love");
            GameManager.eatItemSound.play();
            if (item instanceof BombItem) {
                maxBomb++;
                item.remove();
                stageScreen.remove(item);
            } else if (item instanceof SpeedItem) {
                speed += 1;
                item.remove();
                stageScreen.remove(item);
            } else if (item instanceof FlameItem) {
                //TODO: raise flame length.
                //  update độ dài flame lên 1;
                FlameManager.updateItem();
                item.remove();
                stageScreen.remove(item);
            } else if (item instanceof Portal) {
                System.out.println("love");
                nextLevel = true;
                if (Enemy.numberEnemy == 0) {
                    // TODO: 12/7/2021
                    nextLevel = true;
                }
            }
    }

    private boolean canPlaceBomb() {
        float currentX = Math.round(getX() / 32) * 32;
        float currentY = Math.round(getY() / 32) * 32;
        Actor actor = stageScreen.getAt(currentX, currentY);
        if (listBomb.size() >= maxBomb) {
            return false;
        }
        return !(actor instanceof Bomb) && !(actor instanceof Item);
    }

    private void placeBomb() {
        float currentX = Math.round(getX() / 32) * 32;
        float currentY = Math.round(getY() / 32) * 32;
        Bomb newBomb = new Bomb(currentX, currentY);
        final FlameManager flameManager = new FlameManager(currentX, currentY);
        listBomb.add(newBomb);
        listFlame.add(flameManager);
        stageScreen.addBomb(newBomb);
//      Để bắt thời gian biến mất của quả bom khoảng 1,8s
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1800);
                    stageScreen.addFlames(flameManager);
                    GameManager.bombExplodedSound.play();
                    if(flameManager.isBurned()){
                        removeFlameBurned();
                    }
                    /*if(flameManager.isBurned()){
                        System.out.println("xoabom");
                        removeFlameBurned();
                    }*/
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
//        stageScreen.addFlames(flameManager);
        GameManager.placeBombSound.play();
    }

    private void removeBombExplored() {
        for (int i = 0; i < listBomb.size(); i++) {
            if (listBomb.get(i).isExplored()) {
                stageScreen.remove(listBomb.get(i));
                listBomb.remove(listBomb.get(i));
                i--;
            }
        }
    }
    /**
     * method này để xoá flame ra khỏi stage + list flame
     * */
    private void removeFlameBurned(){
        for(int i = 0; i < listFlame.size(); i++){
            if(listFlame.get(i).isBurned()){
                stageScreen.removeFlame(listFlame.get(i));
                listFlame.remove(listFlame.get(i));
                i--;
            }
        }
    }

    public boolean isNextLevel() {
        return nextLevel;
    }
    public static void setNextLevel() {
        nextLevel = false;
    }
}


