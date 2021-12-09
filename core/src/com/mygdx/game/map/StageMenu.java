package com.mygdx.game.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.MyInputProcessor;
import com.mygdx.game.gamesys.GameManager;

import java.util.ArrayList;

public class StageMenu extends Stage {
  public static Music music =
      Gdx.audio.newMusic(Gdx.files.internal("music/SuperBomberman-Area1.ogg"));
  public boolean[] checkOptionMenu = new boolean[2];
  public Group groupIn = new Group();
  public Group groupOut = new Group();
  public Group groupMusic = new Group();
  public MyActor myOn, myOff;
  public MyInputProcessor inputProcessor = new MyInputProcessor();
  private final TextureRegion notnhac = new TextureRegion(GameManager.notnhac);
  private final TextureRegion board = new TextureRegion(GameManager.board);
  private final TextureRegion start = new TextureRegion(GameManager.play);
  private final TextureRegion on = new TextureRegion(GameManager.on);
  private final TextureRegion off = new TextureRegion(GameManager.off);
  private final TextureRegion background = new TextureRegion(GameManager.background);
  private final TextureRegion exit = new TextureRegion(GameManager.quit);
  private final TextureRegion pause = new TextureRegion(GameManager.pause);
  // private MyActor  manHinh = new MyActor(anhchuyen);
  private final ArrayList<MyActor> ins = new ArrayList<>();
  private final ArrayList<MyActor> outs = new ArrayList<>();
  private boolean checkTouch = true;
  private final float scaleOut = (float) 7.4;
  private final float scaleIn = (float) 8.2;

  public StageMenu() {
    MyActor myBoard = new MyActor(background);
    myBoard.setPosition(0, 0);
    myBoard.setBounds(
        myBoard.getX(),
        myBoard.getY(),
        background.getRegionWidth() / (float) 0.776,
        background.getRegionHeight() / (float) 0.766);
    MyActor startOut1 = new MyActor(start);
    startOut1.setPosition(330, 295);
    startOut1.setBounds(
        startOut1.getX(),
        startOut1.getY(),
        start.getRegionWidth() / scaleOut,
        start.getRegionHeight() / scaleOut);
    MyActor startIn1 = new MyActor(start);
    startIn1.setPosition(342, 300);
    startIn1.setBounds(
        startIn1.getX(),
        startIn1.getY(),
        start.getRegionWidth() / scaleIn,
        start.getRegionHeight() / scaleIn);
    ins.add(startIn1);
    outs.add(startOut1);
    MyActor exittOut2 = new MyActor(exit);
    exittOut2.setPosition(330, 215);
    exittOut2.setBounds(
        exittOut2.getX(),
        exittOut2.getY(),
        start.getRegionWidth() / scaleOut,
        start.getRegionHeight() / scaleOut);
    MyActor exitIn2 = new MyActor(exit);
    exitIn2.setPosition(342, 220);
    exitIn2.setBounds(
        exitIn2.getX(),
        exitIn2.getY(),
        start.getRegionWidth() / scaleIn,
        start.getRegionHeight() / scaleIn);
    ins.add(exitIn2);
    outs.add(exittOut2);
    MyActor myMusic = new MyActor(notnhac);
    myMusic.setPosition(760, 35);
    myMusic.setBounds(
        myMusic.getX(),
        myMusic.getY(),
        notnhac.getRegionWidth() / 8,
        notnhac.getRegionHeight() / 8);
    myOn = new MyActor(on);
    myOn.setPosition(700, 45);
    myOn.setBounds(
        myOn.getX(),
        myOn.getY(),
        on.getRegionWidth() / (float) 1.5,
        on.getRegionHeight() / (float) 1.5);
    myOff = new MyActor(off);
    myOff.setPosition(700, 45);
    myOff.setBounds(
        myOff.getX(),
        myOff.getY(),
        off.getRegionWidth() / (float) 1.5,
        off.getRegionHeight() / (float) 1.5);
    groupMusic.addActor(myOff);

    groupIn.addActor(ins.get(0));
    groupIn.addActor(ins.get(1));
    MyActor myPause = new MyActor(pause);
    myPause.setPosition(340, 175);
    myPause.setBounds(
        myPause.getX(),
        myPause.getY(),
        pause.getRegionWidth() / (float) 3,
        pause.getRegionHeight() / (float) 3);

    // groupIn
    // groupOut.addActor(outs.get(0));
    addActor(myBoard);
    addActor(myPause);
    addActor(groupMusic);
    addActor(myMusic);
    addActor(groupOut);
    addActor(groupIn);
    music.stop();
  }

  public boolean[] convert(float x, float y) {
    checkOptionMenu[0] = false;
    checkOptionMenu[1] = false;
    if (inputProcessor.mouseMoved((int) x, (int) y)) {
      for (int i = 0; i < 2; i++) {
        if (inputProcessor.mouseMovedd(
            Gdx.input.getX(),
            Gdx.input.getY(),
            ins.get(i).getX(),
            ins.get(i).getY(),
            start.getRegionWidth() / scaleIn,
            start.getRegionHeight() / scaleIn)) {
          groupIn.removeActor(ins.get(i));
          groupOut.addActor(outs.get(i));
          if (Gdx.input.isTouched()) {
            checkOptionMenu[i] = true;
          }
        }
        if (!inputProcessor.mouseMovedd(
            Gdx.input.getX(),
            Gdx.input.getY(),
            outs.get(i).getX(),
            outs.get(i).getY(),
            start.getRegionWidth() / scaleOut,
            start.getRegionHeight() / scaleOut)) {
          groupOut.removeActor(outs.get(i));
          groupIn.addActor(ins.get(i));
        }
      }
    }
    return checkOptionMenu;
  }

  public void onOff(MyActor actor1, MyActor actor2, boolean check) {
    if (inputProcessor.mouseMovedd(
        Gdx.input.getX(),
        Gdx.input.getY(),
        actor1.getX(),
        actor1.getY(),
        on.getRegionWidth() / (float) 1.5,
        on.getRegionHeight() / (float) 1.5)) {
      if (Gdx.input.isTouched() && groupMusic.getChild(0) == actor1 && check == true) {
        groupMusic.removeActor(actor1);
        groupMusic.addActor(actor2);
        music.stop();
      } else if (Gdx.input.isTouched() && groupMusic.getChild(0) == actor2 && check == true) {
        groupMusic.removeActor(actor2);
        groupMusic.addActor(actor1);
        music.play();
        music.setLooping(true);
      }
      check = false;
    }
  }

  @Override
  public void draw() {
    super.draw();
    onOff(myOn, myOff, checkTouch);
      checkTouch = !Gdx.input.isTouched();
    // convert(Gdx.input.getX(),Gdx.input.getY());
  }
}
