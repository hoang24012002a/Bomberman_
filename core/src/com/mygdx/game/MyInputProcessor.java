package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class MyInputProcessor implements InputProcessor {
  public boolean keyDown(int keycode) {
    return false;
  }

  public boolean keyUp(int keycode) {
    return false;
  }

  public boolean keyTyped(char character) {
    return false;
  }

  public boolean touchDown(int x, int y, int pointer, int button) {

    return false;
  }

  public boolean touchUp(int x, int y, int pointer, int button) {

    return false;
  }

  public boolean touchDragged(int x, int y, int pointer) {
    return false;
  }

  public boolean mouseMoved(int x, int y) {
      return 550 - y > 100 && 550 - y < 450 && x > 280 && x < 700;
  }

  public boolean mouseMovedd(float x, float y, float GetX, float GetY, float width, float height) {
      return x >= GetX && x < GetX + width && 550 - y >= GetY && 550 - y < GetY + height;
  }

  public boolean scrolled(float amountX, float amountY) {
    return false;
  }

  public boolean touchAt(float amountX, float amountY) {
    if (Gdx.input.isTouched()) {
        return amountX >= 472 && amountY >= 180 && amountX < 600 && amountY < 250;
    }
    return false;
  }

  public boolean isTouched() {
      return Gdx.input.isTouched();
  }
}
