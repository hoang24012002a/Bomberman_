package com.mygdx.game.entities.DynamicEntity.enemy;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.entities.DynamicEntity.enemy.AI.AI_Low;
import com.mygdx.game.gamesys.GameManager;

public class Balloon extends Enemy {
  private int timeKill = 0;
  private int timeChangeDirection = 0;
  public Balloon(float x, float y) {
    super(x, y);
    ai = new AI_Low(this);
    speed = 0.5f;
    textureAtlas = GameManager.balloonLeftDynamic.getKey();
    animation = GameManager.balloonLeftDynamic.getValue();
  }

  @Override
  public void act(float delta) {
    timeChangeDirection++;
    if (timeChangeDirection == 40) {
      direction = calculateDir();
      timeChangeDirection = 0;
    }
    if (!alive) {
      textureAtlas = GameManager.balloonDeadDynamic.getKey();
      animation = GameManager.balloonDeadDynamic.getValue();
      timeKill++;
      if (timeKill == 10) {
        GameManager.balloonDeadSound.play();
      }
      if (timeKill == 100) {
        setPositionInMatrix(getX(), getY(), 'n');
        stageScreen.balloons.remove(this);
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
    textureAtlas = GameManager.balloonRightDynamic.getKey();
    animation = GameManager.balloonRightDynamic.getValue();
    if (canMoveRight()) {
      Actor actor = stageScreen.getAt(positionX + 33, positionY + 16);
      positionY += (Math.round(positionY / 32) * 32 - positionY);
      positionX += speed;
      handle(actor);
    }
    setPositionInMatrix(positionX, positionY, '1');
  }

  @Override
  protected void moveLeft() {
    textureAtlas = GameManager.balloonLeftDynamic.getKey();
    animation = GameManager.balloonLeftDynamic.getValue();
    if (canMoveLeft()) {
      Actor actor = stageScreen.getAt(positionX - 1, positionY + 16);
      positionY += (Math.round(positionY / 32) * 32 - positionY);
      positionX -= speed;
      handle(actor);
    }
    setPositionInMatrix(positionX, positionY, '1');
  }

  @Override
  protected void moveTop() {
    textureAtlas = GameManager.balloonRightDynamic.getKey();
    animation = GameManager.balloonRightDynamic.getValue();
    if (canMoveTop()) {
      Actor actor = stageScreen.getAt(positionX + 16, positionY + 33);
      positionX += (Math.round(positionX / 32) * 32 - positionX);
      positionY += speed;
      handle(actor);
    }
    setPositionInMatrix(positionX, positionY, '1');
  }

  @Override
  protected void moveBottom() {
    textureAtlas = GameManager.balloonLeftDynamic.getKey();
    animation = GameManager.balloonLeftDynamic.getValue();
    if (canMoveBottom()) {
      Actor actor = stageScreen.getAt(positionX + 16, positionY - 1);
      positionX += (Math.round(positionX / 32) * 32 - positionX);
      positionY -= speed;
      handle(actor);
    }
    setPositionInMatrix(positionX, positionY, '1');
  }

  @Override
  protected int calculateDir() {
    return ai.calDir();
  }
}
