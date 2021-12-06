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
    private TextureRegion board = new TextureRegion(new Texture("cartoon/board.png"));
    private TextureRegion continuE = new TextureRegion(new Texture("cartoon/CONTINUE.png"));
    private TextureRegion gameOver = new TextureRegion(new Texture("cartoon/game-over.png"));
    private TextureRegion winner = new TextureRegion(new Texture("cartoon/winner.png"));
    private TextureRegion exit = new TextureRegion(new Texture("cartoon/QUIT.png"));
    private TextureRegion menu = new TextureRegion(new Texture("cartoon/MENU.png"));
    public boolean []checkOption = new boolean[2];
    private ArrayList<MyActor> ins = new ArrayList<>();
    private ArrayList<MyActor> outs = new ArrayList<>();
    private MyActor over,win;
    public Group groupIn = new Group();
    public Group groupOut = new Group();
    public MyInputProcessor  inputProcessor = new MyInputProcessor();
    private float scaleOut = (float) 2.1;
    private float scaleIn = (float) 2.5;
    public boolean checkStageChangedraw = true;
    public StageChange(String s) {
        MyActor  myBoard = new MyActor(board);
        myBoard.setPosition(270,140);
        myBoard.setBounds(myBoard.getX(), myBoard.getY(), board.getRegionWidth()/4, board.getRegionHeight()/4);
        MyActor  exitOut1 = new MyActor(exit);
        exitOut1.setPosition(480,315);
        exitOut1.setBounds(exitOut1.getX(), exitOut1.getY(), exit.getRegionWidth()/scaleOut, exit.getRegionHeight()/scaleOut);
        MyActor exitIn1 = new MyActor(exit);
        exitIn1.setPosition(488,320);
        exitIn1.setBounds(exitIn1.getX(), exitIn1.getY(), exit.getRegionWidth()/scaleIn, exit.getRegionHeight()/scaleIn);
        ins.add(exitIn1);
        outs.add(exitOut1);
        addOption(s);
        //groupOut.addActor(outs.get(0));
        groupIn.addActor(ins.get(0));
        groupIn.addActor(ins.get(1));
        addActor(myBoard);
        addActor(groupOut);
        addActor(groupIn);
    }

    public boolean[] convert(float x, float y) {
        checkOption[0] = false;
        checkOption[1] = false;
        if (inputProcessor.mouseMoved((int)x,(int)y)) {
            for (int i = 0; i < 2; i++) {
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
            checkStageChangedraw = false;
        }
        convert(Gdx.input.getX(),Gdx.input.getY());

    }

    public void addPictureGameOver() {
        over = new MyActor(gameOver);
        over.setPosition(310,270);
        over.setBounds(over.getX(), over.getY(), gameOver.getRegionWidth()/(float)0.8, gameOver.getRegionHeight()/(float)0.8);
        addActor(over);
    }

    public void addPictureVictory() {
        win = new MyActor(winner);
        win.setPosition(330,300);
        win.setBounds( win.getX(),  win.getY(), winner.getRegionWidth(), winner.getRegionHeight());
        addActor(win);
    }

    public void addOption(String s) {
        if(s.equals("pause")) {
            stageChangeSound = GameManager.pauseSound;
            MyActor  continueOut2 = new MyActor(continuE);
            continueOut2.setPosition(480,265);
            continueOut2.setBounds(continueOut2.getX(), continueOut2.getY(), exit.getRegionWidth()/scaleOut, exit.getRegionHeight()/scaleOut);
            MyActor  continueIn2 = new MyActor(continuE);
            continueIn2.setPosition(488,270);
            continueIn2.setBounds(continueIn2.getX(), continueIn2.getY(), exit.getRegionWidth()/scaleIn, exit.getRegionHeight()/scaleIn);
            ins.add(continueIn2);
            outs.add(continueOut2);
        }
        if(s.equals("win") || s.equals("lose")) {
            MyActor  menuOut2 = new MyActor(menu);
            menuOut2.setPosition(480,265);
            menuOut2.setBounds(menuOut2.getX(), menuOut2.getY(), exit.getRegionWidth()/scaleOut, exit.getRegionHeight()/scaleOut);
            MyActor  menuIn2 = new MyActor(menu);
            menuIn2.setPosition(488,270);
            menuIn2.setBounds(menuIn2.getX(), menuIn2.getY(), exit.getRegionWidth()/scaleIn, exit.getRegionHeight()/scaleIn);
            ins.add(menuIn2);
            outs.add(menuOut2);
            if (s.equals("win")) {
                stageChangeSound = GameManager.victorySound;
                winLose(true);
            } else {
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
