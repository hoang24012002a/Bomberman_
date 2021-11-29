package com.mygdx.game.entities.DynamicEntity;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.entities.AnimatedEntity;
import com.mygdx.game.entities.StaticEntity.Bomb.Bomb;
import com.mygdx.game.entities.StaticEntity.Item.Item;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;
import com.mygdx.game.entities.StaticEntity.Tile.Wall;
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

    public boolean canMoveRight() {
        Actor actor = stageScreen.getAt(getX() + 32 + 1, getY() + 32 * 0.5f);
        if (actor instanceof Brick) {
            return false;
        } else if (actor instanceof Wall) {
            return false;
        } else if (actor instanceof Item) {
            return ((Item) actor).isBroken();
        } else if (actor instanceof Bomb) {
            return false;
        }
        return true;
    }

    public boolean canMoveLeft() {
        Actor actor = stageScreen.getAt(getX() - 1, getY() + 32 * 0.5f);
        if (actor instanceof Brick) {
            return false;
        } else if (actor instanceof Wall) {
            return false;
        } else if (actor instanceof Item) {
            return ((Item) actor).isBroken();
        } else if (actor instanceof Bomb) {
            return false;
        }
        return true;
    }

    public boolean canMoveTop() {
        Actor actor = stageScreen.getAt(getX() + 32 * 0.5f, getY() + 32 + 1);
        if (actor instanceof Brick) {
            return false;
        } else if (actor instanceof Wall) {
            return false;
        } else if (actor instanceof Item) {
            return ((Item) actor).isBroken();
        } else if (actor instanceof Bomb) {
            return false;
        }
        return true;
    }

    public boolean canMoveBottom() {
        Actor actor = stageScreen.getAt(getX() + 32 * 0.5f, getY() - 1);
        if (actor instanceof Brick) {
            return false;
        } else if (actor instanceof Wall) {
            return false;
        } else if (actor instanceof Item) {
            return ((Item) actor).isBroken();
        } else if (actor instanceof Bomb) {
            return false;
        }
        return true;
    }

    protected void setPositionInMatrix(float x, float y, char symbol) {
        int x_matrix = Math.round(x / 32);
        int y_matrix = Math.round(y / 32);
        stageScreen.mapMatrix[y_matrix][x_matrix] = symbol;
        if (stageScreen.mapMatrix[y_matrix - 1][x_matrix] == symbol) {
            stageScreen.mapMatrix[y_matrix - 1][x_matrix] = 'n';
        } else if (stageScreen.mapMatrix[y_matrix + 1][x_matrix] == symbol) {
            stageScreen.mapMatrix[y_matrix + 1][x_matrix] = 'n';
        } else if (stageScreen.mapMatrix[y_matrix][x_matrix - 1] == symbol) {
            stageScreen.mapMatrix[y_matrix][x_matrix - 1] = 'n';
        } else if (stageScreen.mapMatrix[y_matrix][x_matrix + 1] == symbol) {
            stageScreen.mapMatrix[y_matrix][x_matrix + 1] = 'n';
        }
    }

    public abstract boolean isAlive(Actor actor);

    public void killed() {
        alive = false;
    }


    protected abstract void moveRight();

    protected abstract void moveLeft();

    protected abstract void moveTop();

    protected abstract void moveBottom();
}
