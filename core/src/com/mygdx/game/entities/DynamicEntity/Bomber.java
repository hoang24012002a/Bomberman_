package com.mygdx.game.entities.DynamicEntity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.entities.DynamicEntity.enemy.Enemy;
import com.mygdx.game.entities.StaticEntity.Bomb.Bomb;
import com.mygdx.game.entities.StaticEntity.Bomb.Flame;
import com.mygdx.game.entities.StaticEntity.Item.*;
import com.mygdx.game.gamesys.GameManager;

import java.util.ArrayList;

public class Bomber extends Character {
    private int code = 0; //Mã phím vừa bấm.
    private int maxBomb = 2;
    private ArrayList<Bomb> listBomb;
    public static Bomber bomber;

    public Bomber(float x, float y) {
        super(x, y);
        bomber = this;
        listBomb = new ArrayList<>();
        textureAtlas = GameManager.playerDownStatic.getKey();
        animation = GameManager.playerDownStatic.getValue();
        code = Input.Keys.S;
        speed = 1.5f;
    }

    private int timeKill = 0;
    @Override
    public void act(float delta) {
        removeBombExplored();
        if (!isAlive()) {
            timeKill++;
            textureAtlas = GameManager.playerDeadDynamic.getKey();
            animation = GameManager.playerDeadDynamic.getValue();
            if (timeKill == 10) {
                GameManager.playerDeadSound.play();
            }
            if (timeKill == 92) {
                remove();
                stageScreen.remove(this);
            }
            return;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            moveRight();
            return;
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            moveLeft();
            return;
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            moveBottom();
            return;
        } else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            moveTop();
            return;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            if (canPlaceBomb()) {
                placeBomb();
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
    protected void moveRight() {
        textureAtlas = GameManager.playerRightDynamic.getKey();
        animation = GameManager.playerRightDynamic.getValue();
        if (canMoveRight()) {
            eadItem(stageScreen.getAt(positionX + 33, positionY + 16));
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
            eadItem(stageScreen.getAt(positionX - 1, positionY + 16));
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
            eadItem(stageScreen.getAt(positionX + 16, positionY + 33));
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
            eadItem(stageScreen.getAt(positionX + 16, positionY - 1));
            positionX += (Math.round(positionX / 32) * 32 - positionX);
            positionY -= speed;
        }
        setPositionInMatrix(positionX, positionY, 'p');
        code = Input.Keys.S;
    }

    @Override
    public boolean isAlive() {
        if (!alive) {
            return false;
        }
        Actor actor = stageScreen.getAt(getX() - 1, getY() + 16);
        Actor actor1 = stageScreen.getAt(getX() + 16, getY() + 33);
        Actor actor2 = stageScreen.getAt(getX() + 33, getY() + 16);
        Actor actor3 = stageScreen.getAt(getX() + 16, getY() - 1);
        if (actor instanceof Enemy || actor1 instanceof Enemy || actor2 instanceof Enemy || actor3 instanceof Enemy) {
            alive = false;
            return false;
        } else if (actor instanceof Flame || actor1 instanceof Flame || actor2 instanceof Flame || actor3 instanceof Flame) {
            alive = false;
            return false;
        }
        return true;
    }

    private void eadItem(Actor item) {
        if (!(item instanceof Item) || !((Item) item).isBroken()) {
            return;
        }
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
            item.remove();
            stageScreen.remove(item);
        } else if (item instanceof Portal) {
            if (Enemy.numberEnemy == 0) {
                //TODO: next Level.
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
        listBomb.add(newBomb);
        stageScreen.addBomb(newBomb);
        GameManager.placeBombSound.play();
    }

    private void removeBombExplored() {
        for (int i = 0; i < listBomb.size(); i++) {
            if (listBomb.get(i).isExplored()) {
                listBomb.remove(listBomb.get(i));
                i--;
            }
        }
    }
}
