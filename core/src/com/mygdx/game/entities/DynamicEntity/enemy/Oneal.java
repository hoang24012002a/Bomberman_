package com.mygdx.game.entities.DynamicEntity.enemy;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.entities.DynamicEntity.enemy.AI.AI_Medium;
import com.mygdx.game.gamesys.GameManager;

public class Oneal extends Enemy {
  private int timeKill = 0;
  private int timeChangeDirection = 0;
  public Oneal(float x, float y) {
    super(x, y);
    ai = new AI_Medium(this);
    textureAtlas = GameManager.onealLeftDynamic.getKey();
    animation = GameManager.onealLeftDynamic.getValue();
    speed = 0.5f;
  }

  @Override
  public void act(float delta) {
    timeChangeDirection++;
    if (timeChangeDirection == 20) {
      speed = (float) Math.random() + 0.5f;
      direction = calculateDir();
      timeChangeDirection = 0;
    }
    if (!alive) {
      textureAtlas = GameManager.onealDeadDynamic.getKey();
      animation = GameManager.onealDeadDynamic.getValue();
      timeKill++;
      if (timeKill == 10) {
        GameManager.onealDeadSound.play();
      }
      if (timeKill == 100) {
        setPositionInMatrix(getX(), getY(), 'n');
        stageScreen.oneals.remove(this);
        stageScreen.remove(this);
        numberEnemy--;
        remove();
      }
      return;
    }
    if (direction == 0) {
      moveLeft();
    } else if (direction == 2) {
      moveRight();
    } else if (direction == 1) {
      moveTop();
    } else if (direction == 3) {
      moveBottom();
    }
  }

  @Override
  protected void moveRight() {
    textureAtlas = GameManager.onealRightDynamic.getKey();
    animation = GameManager.onealRightDynamic.getValue();
    if (canMoveRight()) {
      Actor actor = stageScreen.getAt(positionX + 33, positionY + 16);
      positionY += (Math.round(positionY / 32) * 32 - positionY);
      positionX += speed;
      handle(actor);
    }
    setPositionInMatrix(positionX, positionY, '2');
  }

  @Override
  protected void moveLeft() {
    textureAtlas = GameManager.onealLeftDynamic.getKey();
    animation = GameManager.onealLeftDynamic.getValue();
    if (canMoveLeft()) {
      Actor actor = stageScreen.getAt(positionX - 1, positionY + 16);
      positionY += (Math.round(positionY / 32) * 32 - positionY);
      positionX -= speed;
      handle(actor);
    }
    setPositionInMatrix(positionX, positionY, '2');
  }

  @Override
  protected void moveTop() {
    textureAtlas = GameManager.onealRightDynamic.getKey();
    animation = GameManager.onealRightDynamic.getValue();
    if (canMoveTop()) {
      Actor actor = stageScreen.getAt(positionX + 16, positionY + 33);
      positionX += (Math.round(positionX / 32) * 32 - positionX);
      positionY += speed;
      handle(actor);
    }
    setPositionInMatrix(positionX, positionY, '2');
  }

  @Override
  protected void moveBottom() {
    textureAtlas = GameManager.onealLeftDynamic.getKey();
    animation = GameManager.onealLeftDynamic.getValue();
    if (canMoveBottom()) {
      Actor actor = stageScreen.getAt(positionX + 16, positionY - 1);
      positionX += (Math.round(positionX / 32) * 32 - positionX);
      positionY -= speed;
      handle(actor);
    }
    setPositionInMatrix(positionX, positionY, '2');
  }

  @Override
  protected int calculateDir() {
    return ai.calDir();
  }
}
