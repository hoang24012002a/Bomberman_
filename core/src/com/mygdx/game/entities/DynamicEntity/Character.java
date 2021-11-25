package com.mygdx.game.entities.DynamicEntity;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.entities.AnimatedEntity;
import com.mygdx.game.entities.StaticEntity.Item.Item;
import com.mygdx.game.entities.StaticEntity.Tile.Grass;
import com.mygdx.game.map.StageScreen;

public abstract class Character extends AnimatedEntity {
    protected float speed;
    protected boolean alive = true;
    protected StageScreen stageScreen;
    private char[][] map;

    protected Character(float x, float y) {
        super(x, y);
        speed = 1;
        stageScreen = StageScreen.me;
        map = stageScreen.mapMatrix;
    }

    public abstract boolean isAlive();

    protected boolean canMoveRight() {
        Actor actor = stageScreen.getAt(getX() + 32 + 1, getY() + 32 * 0.3f);
        Actor actor1 = stageScreen.getAt(getX() + 32 + 1, getY() + 32 * 0.7f);
        if (actor instanceof Grass && actor1 instanceof  Grass) {
            return true;
        } else if (actor instanceof Item && actor1 instanceof Item){
            return ((Item) actor).isBroken();
        }
        return false;
    }

    protected boolean canMoveLeft() {
        Actor actor = stageScreen.getAt(getX() - 1, getY() + 32 * 0.3f);
        Actor actor1 = stageScreen.getAt(getX() - 1, getY() + 32 * 0.7f);
        if (actor instanceof Grass && actor1 instanceof  Grass) {
            return true;
        } else if (actor instanceof Item && actor1 instanceof Item){
            return ((Item) actor).isBroken();
        }
        return false;
    }

    protected boolean canMoveTop() {
        Actor actor = stageScreen.getAt(getX() + 32 * 0.3f, getY() + 32 + 1);
        Actor actor1 = stageScreen.getAt(getX() + 32 * 0.7f, getY() + 32 + 1);
        if (actor instanceof Grass && actor1 instanceof  Grass) {
            return true;
        } else if (actor instanceof Item && actor1 instanceof Item){
            return ((Item) actor).isBroken();
        }
        return false;
    }

    protected boolean canMoveBottom() {
        Actor actor = stageScreen.getAt(getX() + 32 * 0.3f, getY() - 1);
        Actor actor1 = stageScreen.getAt(getX() + 32 * 0.7f, getY() - 1);
        if (actor instanceof Grass && actor1 instanceof  Grass) {
            return true;
        } else if (actor instanceof Item && actor1 instanceof Item){
            return ((Item) actor).isBroken();
        }
        return false;
    }

    protected abstract void moveRight();

    protected abstract void moveLeft();

    protected abstract void moveTop();

    protected abstract void moveBottom();
}
