package com.mygdx.game.entities.DynamicEntity.enemy;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.entities.DynamicEntity.enemy.AI.AI_Low;
import com.mygdx.game.gamesys.GameManager;

public class Doll extends Enemy {
  private int timeKill = 0;
  private int timeChangeDirection = 0;
  public Doll(float x, float y) {
    super(x, y);
    ai = new AI_Low(this);
    speed = 1.5f;
    textureAtlas = GameManager.dollLeftDynamic.getKey();
    animation = GameManager.dollLeftDynamic.getValue();
  }

  @Override
  public void act(float delta) {
    timeChangeDirection++;
    if (timeChangeDirection == 40) {
      direction = calculateDir();
      timeChangeDirection = 0;
    }
    if (!alive) {
      textureAtlas = GameManager.dollDeadDynamic.getKey();
      animation = GameManager.dollDeadDynamic.getValue();
      timeKill++;
      if (timeKill == 10) {
        GameManager.dollDeadSound.play();
      }
      if (timeKill == 100) {
        setPositionInMatrix(getX(), getY(), 'n');
        stageScreen.dolls.remove(this);
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
    textureAtlas = GameManager.dollRightDynamic.getKey();
    animation = GameManager.dollRightDynamic.getValue();
    if (canMoveRight()) {
      Actor actor = stageScreen.getAt(positionX + 33, positionY + 16);
      positionY += (Math.round(positionY / 32) * 32 - positionY);
      positionX += speed;
      handle(actor);
    }
    setPositionInMatrix(positionX, positionY, '3');
  }

  @Override
  protected void moveLeft() {
    textureAtlas = GameManager.dollLeftDynamic.getKey();
    animation = GameManager.dollLeftDynamic.getValue();
    if (canMoveLeft()) {
      Actor actor = stageScreen.getAt(positionX - 1, positionY + 16);
      positionY += (Math.round(positionY / 32) * 32 - positionY);
      positionX -= speed;
      handle(actor);
    }
    setPositionInMatrix(positionX, positionY, '3');
  }

  @Override
  protected void moveTop() {
    textureAtlas = GameManager.dollRightDynamic.getKey();
    animation = GameManager.dollRightDynamic.getValue();
    if (canMoveTop()) {
      Actor actor = stageScreen.getAt(positionX + 16, positionY + 33);
      positionX += (Math.round(positionX / 32) * 32 - positionX);
      positionY += speed;
      handle(actor);
    }
    setPositionInMatrix(positionX, positionY, '3');
  }

  @Override
  protected void moveBottom() {
    textureAtlas = GameManager.dollLeftDynamic.getKey();
    animation = GameManager.dollLeftDynamic.getValue();
    if (canMoveBottom()) {
      Actor actor = stageScreen.getAt(positionX + 16, positionY - 1);
      positionX += (Math.round(positionX / 32) * 32 - positionX);
      positionY -= speed;
      handle(actor);
    }
    setPositionInMatrix(positionX, positionY, '3');
  }

  @Override
  protected int calculateDir() {
    return ai.calDir();
  }

  @Override
  public boolean canMoveBottom() {
    return getY() >= 32;
  }

  @Override
  public boolean canMoveLeft() {
    return getX() >= 32;
  }

  @Override
  public boolean canMoveRight() {
    return getX() <= 32 * 29;
  }

  @Override
  public boolean canMoveTop() {
    return getY() <= 32 * 11;
  }
}
