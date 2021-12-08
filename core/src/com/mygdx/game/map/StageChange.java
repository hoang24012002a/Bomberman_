package com.mygdx.game.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyInputProcessor;
import com.mygdx.game.gamesys.GameManager;

import java.util.ArrayList;

public class StageChange extends Stage {
    public  Sound stageChangeSound = GameManager.pauseSound;
    private TextureRegion board = new TextureRegion(GameManager.board);
    private TextureRegion continuE = new TextureRegion(GameManager.conti);
    private TextureRegion gameOver = new TextureRegion(GameManager.over);
    private TextureRegion winner = new TextureRegion(GameManager.winner);
    private TextureRegion exit = new TextureRegion(GameManager.quit);
    private TextureRegion menu = new TextureRegion(GameManager.menu);
    private TextureRegion tryAgain = new TextureRegion(GameManager.tryAg);
    public boolean []checkOption = new boolean[3];
    private ArrayList<MyActor> ins = new ArrayList<>();
    private ArrayList<MyActor> outs = new ArrayList<>();
    private MyActor over,win;
    private Group groupIn = new Group();
    private Group groupOut = new Group();
    public MyInputProcessor  inputProcessor = new MyInputProcessor();
    private float scaleOut = (float) 7;
    private float scaleIn = (float) 8;
    public boolean checkStageChangedraw = true;
    public StageChange(String s) {
        MyActor  myBoard = new MyActor(board);
        myBoard.setPosition(270,100);
        myBoard.setBounds(myBoard.getX(), myBoard.getY(), board.getRegionWidth()/4, board.getRegionHeight()/4);
        MyActor  exitOut1 = new MyActor(exit);
        exitOut1.setPosition(472,210);
        exitOut1.setBounds(exitOut1.getX(), exitOut1.getY(), exit.getRegionWidth()/scaleOut, exit.getRegionHeight()/scaleOut);
        MyActor exitIn1 = new MyActor(exit);
        exitIn1.setPosition(484,215);
        exitIn1.setBounds(exitIn1.getX(), exitIn1.getY(), exit.getRegionWidth()/scaleIn, exit.getRegionHeight()/scaleIn);
        ins.add(exitIn1);
        outs.add(exitOut1);
        groupIn.addActor(ins.get(0));
        //groupIn.addActor(ins.get(1));
        addActor(myBoard);
        addOption(s);
        //groupOut.addActor(outs.get(0));

        addActor(groupOut);
        addActor(groupIn);
    }

    public boolean[] convert(float x, float y) {
        checkOption[0] = false;
        checkOption[1] = false;
        checkOption[2] = false;
        if (inputProcessor.mouseMoved((int)x,(int)y)) {
            for (int i = 0; i < ins.size(); i++) {
                if (inputProcessor.mouseMovedd(Gdx.input.getX(), Gdx.input.getY(),ins.get(i).getX(),ins.get(i).getY(),exit.getRegionWidth()/scaleIn, exit.getRegionHeight()/scaleIn)) {
                    groupIn.removeActor(ins.get(i));
                    groupOut.addActor(outs.get(i));
                    if (Gdx.input.isTouched()) {
                        checkOption[i] =true;
                        stageChangeSound.stop();
                    }
                }
                if (!inputProcessor.mouseMovedd(Gdx.input.getX(), Gdx.input.getY(),outs.get(i).getX(),outs.get(i).getY(),exit.getRegionWidth()/scaleOut, exit.getRegionHeight()/scaleOut)) {
                    groupOut.removeActor(outs.get(i));
                    groupIn.addActor(ins.get(i));
                }

            }
        }
        return checkOption;
    }
    //int dem = 0;
    @Override
    public void draw() {
        //dem++;
        //System.out.println(dem);
        super.draw();
        if(checkStageChangedraw) {
            stageChangeSound.play();
            StageMenu.music.stop();
            checkStageChangedraw = false;
        }
        convert(Gdx.input.getX(),Gdx.input.getY());

    }

    public void addPictureGameOver() {
        over = new MyActor(gameOver);
        over.setPosition(315,275);
        over.setBounds(over.getX(), over.getY(), gameOver.getRegionWidth()/(float)0.8, gameOver.getRegionHeight()/(float)0.8);
        addActor(over);
    }

    public void addPictureVictory() {
        win = new MyActor(winner);
        win.setPosition(350,300);
        win.setBounds( win.getX(),  win.getY(), winner.getRegionWidth(), winner.getRegionHeight());
        addActor(win);
    }

    public void addOption(String s) {
        if(s.equals("pause")) {
            stageChangeSound = GameManager.pauseSound;
            MyActor  continueOut2 = new MyActor(continuE);
            continueOut2.setPosition(474,275);
            continueOut2.setBounds(continueOut2.getX(), continueOut2.getY(), exit.getRegionWidth()/scaleOut, exit.getRegionHeight()/scaleOut);
            MyActor  continueIn2 = new MyActor(continuE);
            continueIn2.setPosition(484,280);
            continueIn2.setBounds(continueIn2.getX(), continueIn2.getY(), exit.getRegionWidth()/scaleIn, exit.getRegionHeight()/scaleIn);
            ins.add(continueIn2);
            outs.add(continueOut2);
            groupIn.addActor(ins.get(1));
        }
        if(s.equals("win") || s.equals("lose")) {
            MyActor  menuOut2 = new MyActor(menu);
            menuOut2.setPosition(474,270);
            menuOut2.setBounds(menuOut2.getX(), menuOut2.getY(), exit.getRegionWidth()/scaleOut, exit.getRegionHeight()/scaleOut);
            MyActor  menuIn2 = new MyActor(menu);
            menuIn2.setPosition(484,275);
            menuIn2.setBounds(menuIn2.getX(), menuIn2.getY(), exit.getRegionWidth()/scaleIn, exit.getRegionHeight()/scaleIn);
            ins.add(menuIn2);
            outs.add(menuOut2);
            groupIn.addActor(ins.get(1));
            if (s.equals("win")) {
                stageChangeSound = GameManager.victorySound;
                winLose(true);
            } else {
                MyActor  continueIn2 = new MyActor(tryAgain);
                continueIn2.setPosition(484,155);
                continueIn2.setBounds(continueIn2.getX(), continueIn2.getY(), exit.getRegionWidth()/scaleIn, exit.getRegionHeight()/scaleIn);
                MyActor  continueOut2 = new MyActor(tryAgain);
                continueOut2.setPosition(470,150);
                continueOut2.setBounds(continueOut2.getX(), continueOut2.getY(), exit.getRegionWidth()/scaleOut, exit.getRegionHeight()/scaleOut);
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
