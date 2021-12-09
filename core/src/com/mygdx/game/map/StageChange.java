package com.mygdx.game.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.MyInputProcessor;
import com.mygdx.game.gamesys.GameManager;

import java.util.ArrayList;

public class StageChange extends Stage {
  public Sound stageChangeSound = GameManager.pauseSound;
  public boolean[] checkOption = new boolean[3];
  public Group groupMusic = new Group();
  public MyInputProcessor inputProcessor = new MyInputProcessor();
  public boolean checkStageChangedraw = true;
  private final Pixmap pixmap = new Pixmap(992, 550, Pixmap.Format.RGBA8888);
  private final TextureRegion notnhac = new TextureRegion(GameManager.notnhac2);
  private final TextureRegion board = new TextureRegion(new Texture("cartoon/board.png"));
  private final TextureRegion continuE = new TextureRegion(new Texture("cartoon/newconti.png"));
  private final TextureRegion gameOver = new TextureRegion(new Texture("cartoon/game-over.png"));
  private final TextureRegion winner = new TextureRegion(new Texture("cartoon/winner.png"));
  private final TextureRegion exit = new TextureRegion(new Texture("cartoon/newquit.png"));
  private final TextureRegion menu = new TextureRegion(new Texture("cartoon/newmenu.png"));
  private final TextureRegion tryAgain = new TextureRegion(new Texture("cartoon/try.png"));
  private final TextureRegion on = new TextureRegion(GameManager.on);
  private final TextureRegion off = new TextureRegion(GameManager.off);
  private final ArrayList<MyActor> ins = new ArrayList<>();
  private final ArrayList<MyActor> outs = new ArrayList<>();
  private MyActor over, win;
  private final Group groupIn = new Group();
  private final Group groupOut = new Group();
  private boolean checkTouch = true;
  private MyActor myOn, myOff;
  private final float scaleOut = (float) 7;
  private final float scaleIn = (float) 8;
  private String ss = "";

  public StageChange(String s) {
    ss = s;
    pixmap.setColor(new Color(0, 0, 0, (float) 0.5));
    pixmap.fill();
    TextureRegion anhpixmap = new TextureRegion(new Texture(pixmap));
    MyActor myPixmap = new MyActor(anhpixmap);
    myPixmap.setPosition(0, 0);
    myPixmap.setBounds(
        myPixmap.getX(), myPixmap.getY(), anhpixmap.getRegionWidth(), anhpixmap.getRegionHeight());
    addActor(myPixmap);
    pixmap.dispose();
    MyActor myBoard = new MyActor(board);
    myBoard.setPosition(270, 100);
    myBoard.setBounds(
        myBoard.getX(), myBoard.getY(), board.getRegionWidth() / 4, board.getRegionHeight() / 4);
    MyActor exitOut1 = new MyActor(exit);
    exitOut1.setPosition(472, 210);
    exitOut1.setBounds(
        exitOut1.getX(),
        exitOut1.getY(),
        exit.getRegionWidth() / scaleOut,
        exit.getRegionHeight() / scaleOut);
    MyActor exitIn1 = new MyActor(exit);
    exitIn1.setPosition(484, 215);
    exitIn1.setBounds(
        exitIn1.getX(),
        exitIn1.getY(),
        exit.getRegionWidth() / scaleIn,
        exit.getRegionHeight() / scaleIn);
    ins.add(exitIn1);
    outs.add(exitOut1);
    groupIn.addActor(ins.get(0));
    // groupIn.addActor(ins.get(1));
    addActor(myBoard);
    addOption(s);
    // groupOut.addActor(outs.get(0));
    addActor(groupOut);
    addActor(groupIn);
    // addOnOff();
    addActor(groupMusic);
  }

  void addOnOff() {
    MyActor myMusic = new MyActor(notnhac);
    myMusic.setPosition(420, 283);
    myMusic.setBounds(
        myMusic.getX(),
        myMusic.getY(),
        notnhac.getRegionWidth() / 2,
        notnhac.getRegionHeight() / 2);
    myOn = new MyActor(on);
    myOn.setPosition(370, 280);
    myOn.setBounds(
        myOn.getX(),
        myOn.getY(),
        on.getRegionWidth() / (float) 1.5,
        on.getRegionHeight() / (float) 1.5);
    myOff = new MyActor(off);
    myOff.setPosition(370, 280);
    myOff.setBounds(
        myOff.getX(),
        myOff.getY(),
        off.getRegionWidth() / (float) 1.5,
        off.getRegionHeight() / (float) 1.5);
    if (StageMenu.music.isPlaying()) {
      groupMusic.addActor(myOn);
      // System.out.println("yes");
    } else {
      groupMusic.addActor(myOff);
      // System.out.println("no");
    }
    addActor(myMusic);
  }

  public void onOff(MyActor actor1, MyActor actor2, boolean check) {
    System.out.println("w1");
    if (inputProcessor.mouseMovedd(
        Gdx.input.getX(),
        Gdx.input.getY(),
        actor1.getX(),
        actor1.getY(),
        on.getRegionWidth() / (float) 1.5,
        on.getRegionHeight() / (float) 1.5)) {
      System.out.println("w2");
      if (Gdx.input.isTouched() && groupMusic.getChild(0) == actor1 && check == true) {
        groupMusic.removeActor(actor1);
        groupMusic.addActor(actor2);
        StageMenu.music.stop();
      } else if (Gdx.input.isTouched() && groupMusic.getChild(0) == actor2 && check == true) {
        groupMusic.removeActor(actor2);
        groupMusic.addActor(actor1);
        StageMenu.music.play();
        StageMenu.music.setLooping(true);
      }
      check = false;
    }
  }

  public boolean[] convert(float x, float y) {
    checkOption[0] = false;
    checkOption[1] = false;
    checkOption[2] = false;
    if (inputProcessor.mouseMoved((int) x, (int) y)) {
      for (int i = 0; i < ins.size(); i++) {
        if (inputProcessor.mouseMovedd(
            Gdx.input.getX(),
            Gdx.input.getY(),
            ins.get(i).getX(),
            ins.get(i).getY(),
            exit.getRegionWidth() / scaleIn,
            exit.getRegionHeight() / scaleIn)) {
          groupIn.removeActor(ins.get(i));
          groupOut.addActor(outs.get(i));
          if (Gdx.input.isTouched()) {
            checkOption[i] = true;
            stageChangeSound.stop();
          }
        }
        if (!inputProcessor.mouseMovedd(
            Gdx.input.getX(),
            Gdx.input.getY(),
            outs.get(i).getX(),
            outs.get(i).getY(),
            exit.getRegionWidth() / scaleOut,
            exit.getRegionHeight() / scaleOut)) {
          groupOut.removeActor(outs.get(i));
          groupIn.addActor(ins.get(i));
        }
      }
    }
    return checkOption;
  }
  // int dem = 0;
  @Override
  public void draw() {
    // dem++;
    // System.out.println(dem);
    super.draw();
    if (ss.equals("pause")) {
      if (!groupMusic.hasChildren()) {
        addOnOff();
      }
      onOff(myOn, myOff, checkTouch);
    }
      checkTouch = !Gdx.input.isTouched();
    if (checkStageChangedraw) {
      stageChangeSound.play();
      if (ss.equals("win") || ss.equals("lose")) {
        StageMenu.music.stop();
      }
      checkStageChangedraw = false;
    }
    convert(Gdx.input.getX(), Gdx.input.getY());
  }

  public void addPictureGameOver() {
    over = new MyActor(gameOver);
    over.setPosition(315, 275);
    over.setBounds(
        over.getX(),
        over.getY(),
        gameOver.getRegionWidth() / (float) 0.8,
        gameOver.getRegionHeight() / (float) 0.8);
    addActor(over);
  }

  public void addPictureVictory() {
    win = new MyActor(winner);
    win.setPosition(350, 300);
    win.setBounds(win.getX(), win.getY(), winner.getRegionWidth(), winner.getRegionHeight());
    addActor(win);
  }

  public void addOption(String s) {
    if (s.equals("pause")) {
      stageChangeSound = GameManager.pauseSound;
      MyActor continueOut2 = new MyActor(continuE);
      continueOut2.setPosition(474, 275);
      continueOut2.setBounds(
          continueOut2.getX(),
          continueOut2.getY(),
          exit.getRegionWidth() / scaleOut,
          exit.getRegionHeight() / scaleOut);
      MyActor continueIn2 = new MyActor(continuE);
      continueIn2.setPosition(484, 280);
      continueIn2.setBounds(
          continueIn2.getX(),
          continueIn2.getY(),
          exit.getRegionWidth() / scaleIn,
          exit.getRegionHeight() / scaleIn);
      ins.add(continueIn2);
      outs.add(continueOut2);
      groupIn.addActor(ins.get(1));
    }
    if (s.equals("win") || s.equals("lose")) {
      MyActor menuOut2 = new MyActor(menu);
      menuOut2.setPosition(474, 270);
      menuOut2.setBounds(
          menuOut2.getX(),
          menuOut2.getY(),
          exit.getRegionWidth() / scaleOut,
          exit.getRegionHeight() / scaleOut);
      MyActor menuIn2 = new MyActor(menu);
      menuIn2.setPosition(484, 275);
      menuIn2.setBounds(
          menuIn2.getX(),
          menuIn2.getY(),
          exit.getRegionWidth() / scaleIn,
          exit.getRegionHeight() / scaleIn);
      ins.add(menuIn2);
      outs.add(menuOut2);
      groupIn.addActor(ins.get(1));
      if (s.equals("win")) {
        stageChangeSound = GameManager.victorySound;
        winLose(true);
      } else {
        MyActor continueIn2 = new MyActor(tryAgain);
        continueIn2.setPosition(484, 155);
        continueIn2.setBounds(
            continueIn2.getX(),
            continueIn2.getY(),
            exit.getRegionWidth() / scaleIn,
            exit.getRegionHeight() / scaleIn);
        MyActor continueOut2 = new MyActor(tryAgain);
        continueOut2.setPosition(470, 150);
        continueOut2.setBounds(
            continueOut2.getX(),
            continueOut2.getY(),
            exit.getRegionWidth() / scaleOut,
            exit.getRegionHeight() / scaleOut);
        ins.add(continueIn2);
        outs.add(continueOut2);
        groupIn.addActor(ins.get(2));
        stageChangeSound = GameManager.gameOverSound;
        winLose(false);
      }
    }
  }

  public void winLose(boolean ck) {
    if (ck == true) {
      addPictureVictory();
    } else {
      addPictureGameOver();
    }
  }
}
