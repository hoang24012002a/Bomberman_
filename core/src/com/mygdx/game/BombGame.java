package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.bullet.collision.GdxCollisionObjectBridge;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.entities.StaticEntity.Bomb.Bomb;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;
import com.mygdx.game.entities.StaticEntity.Tile.Grass;
import com.mygdx.game.entities.StaticEntity.Tile.Wall;
import com.mygdx.game.map.*;

import java.util.*;

public class BombGame implements ApplicationListener {
  // private int dem1 = 1;
  // private int dem2 = 1;
  StagePlay stagePlay;
  private int dem = 0;
  private Stage stage;
  // private StageChange stageChange;
  // private StageScreen stageScreen;
  private StageMenu stageMenu;
  private StageInfomation stageInfomation;
  // private ArrayList<StageScreen> stageScreens = new ArrayList<>();
  private SpriteBatch batch;
  private BitmapFont font;
  private boolean check = true;
  private boolean checkTouch = true;
  private MyInputProcessor myInputProcessor;

  @Override
  public void create() {
    myInputProcessor = new MyInputProcessor();
    // stage = new Stage(new ScreenViewport());
    batch = new SpriteBatch();
    font = new BitmapFont();
    stagePlay = new StagePlay();
  }

  @Override
  public void resize(int width, int height) {}

  @Override
  public void render() {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    // stageInfomation.draw();
    stagePlay.draw();
    stagePlay.act(Gdx.graphics.getDeltaTime());
    if (stagePlay.exit) {
      System.out.println("exit in BombGame");
      dispose();
    }
    // stageScreens.get(dem).dispose();
    // stageChange.act(Gdx.graphics.getDeltaTime());
  }

  @Override
  public void pause() {}

  @Override
  public void resume() {}

  @Override
  public void dispose() {
    // stage.dispose();
    // stageScreen.dispose();
    // stageScreens.get(0).dispose();
    // stageScreens.get(1).dispose();
    // stageScreens.get(2).dispose();
    // stageChange.dispose();
    // stageMenu.dispose();
    // stageInfomation.dispose();
    stagePlay.dispose();
  }
}