package com.mygdx.game.entities.FreezeEntity.Item;

import com.mygdx.game.entities.FreezeEntity.Tile.Brick;
import com.mygdx.game.gamesys.GameManager;
import com.mygdx.game.map.StageScreen;

public class Portal extends Item {

  protected boolean allEnemyDie = StageScreen.me.CheckAllEnemyDeath();
  protected StageScreen stageScreen;

  public Portal(float positionX, float positionY) {
    super(positionX, positionY);
    this.allEnemyDie = false;
    this.texture = GameManager.portalItem;
  }

  public Portal(Brick brick) {
    super(brick);
    this.allEnemyDie = false;
    this.texture = GameManager.portalItem;
    this.broken = false;
  }

  @Override
  public void eatItem(float x, float y) {
    if (positionX == x && positionY == y && allEnemyDie) {
      this.broken = true;
      remove();
      stageScreen.remove(this);
    } else {
      this.broken = false;
    }
  }

  @Override
  public boolean isBroken() {
    return true;
  }

  @Override
  public void showItem(Brick brickBroken) {
    if (brickBroken.isBrokenDown()) {
      this.texture = GameManager.portalItem;
    } else {
      return;
    }
  }

  //    qua man mới
  //    @Override
  //    public void act(float delta){
  ////        float currentBomberX = stageScreen.bomber.getPositionX();
  ////        float currentBomberY = stageScreen.bomber.getPositionY();
  ////        eatItem(currentBomberX, currentBomberY);
  //    }
}
