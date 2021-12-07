package com.mygdx.game.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.MyInputProcessor;

import java.util.ArrayList;

public class StageMenu extends Stage {
    private Music music = Gdx.audio.newMusic(Gdx.files.internal("music/soundtrack.wav"));
    private TextureRegion notnhac = new TextureRegion(new Texture("cartoon/notnhac.jpg"));
    private TextureRegion board = new TextureRegion(new Texture("cartoon/board.png"));
    private TextureRegion start = new TextureRegion(new Texture("cartoon/start.gif"));
    private TextureRegion on = new TextureRegion(new Texture("cartoon/on.png"));
    private TextureRegion off = new TextureRegion(new Texture("cartoon/off.png"));
    private TextureRegion  background = new TextureRegion(new Texture("cartoon/background.jpg"));
    //private TextureRegion anhchuyen = new TextureRegion(new Texture("cartoon/start.gif"));
    //private MyActor  manHinh = new MyActor(anhchuyen);
    private ArrayList<MyActor> ins = new ArrayList<>();
    private ArrayList<MyActor> outs = new ArrayList<>();
    private boolean checkTouch =true;
    public Group groupIn = new Group();
    public Group groupOut = new Group();
    public Group groupMusic = new Group();
    public MyActor myOn;
    public MyActor myOff;
    public MyInputProcessor inputProcessor = new MyInputProcessor();
    private float scaleOut = (float) 2.1;
    private float scaleIn = (float) 2.5;
    public StageMenu() {
        /*MyActor  myBoard = new MyActor(board);
        myBoard.setPosition(270,140);
        myBoard.setBounds(myBoard.getX(), myBoard.getY(), board.getRegionWidth()/4, board.getRegionHeight()/4);*/
        MyActor  myBoard = new MyActor(background);
        myBoard.setPosition(0,0);
        myBoard.setBounds(myBoard.getX(), myBoard.getY(), background.getRegionWidth()/(float)0.776, background.getRegionHeight()/(float)0.766);
        MyActor  startOut1 = new MyActor(start);
        startOut1.setPosition(480,315);
        startOut1.setBounds(startOut1.getX(), startOut1.getY(), start.getRegionWidth()/scaleOut, start.getRegionHeight()/scaleOut);
        MyActor  startIn1 = new MyActor(start);
        startIn1.setPosition(488,320);
        startIn1.setBounds(startIn1.getX(), startIn1.getY(), start.getRegionWidth()/scaleIn, start.getRegionHeight()/scaleIn);
        ins.add(startIn1);
        outs.add(startOut1);
        MyActor  startOut2 = new MyActor(start);
        startOut2.setPosition(480,265);
        startOut2.setBounds(startOut2.getX(), startOut2.getY(), start.getRegionWidth()/scaleOut, start.getRegionHeight()/scaleOut);
        MyActor  startIn2 = new MyActor(start);
        startIn2.setPosition(488,270);
        startIn2.setBounds(startIn2.getX(), startIn2.getY(), start.getRegionWidth()/scaleIn, start.getRegionHeight()/scaleIn);
        ins.add(startIn2);
        outs.add(startOut2);
        MyActor  startOut3 = new MyActor(start);
        startOut3.setPosition(480,215);
        startOut3.setBounds(startOut3.getX(), startOut3.getY(), start.getRegionWidth()/scaleOut, start.getRegionHeight()/scaleOut);
        MyActor  startIn3 = new MyActor(start);
        startIn3.setPosition(488,220);
        startIn3.setBounds(startIn3.getX(), startIn3.getY(), start.getRegionWidth()/scaleIn, start.getRegionHeight()/scaleIn);
        ins.add(startIn3);
        outs.add(startOut3);
        MyActor  myMusic = new MyActor(notnhac);
        myMusic.setPosition(760,50);
        myMusic.setBounds(myMusic.getX(), myMusic.getY(), notnhac.getRegionWidth()/27, notnhac.getRegionHeight()/27);
        myOn = new MyActor(on);
        myOn.setPosition(650,50);
        myOn.setBounds(myOn.getX(), myOn.getY(), on.getRegionWidth()/2, on.getRegionHeight()/2);
        myOff = new MyActor(off);
        myOff.setPosition(650,50);
        myOff.setBounds(myOff.getX(), myOff.getY(), off.getRegionWidth()/2, off.getRegionHeight()/2);
        groupMusic.addActor(myOn);

        groupIn.addActor(ins.get(0));
        groupIn.addActor(ins.get(1));
        groupIn.addActor(ins.get(2));
        //groupIn
        //groupOut.addActor(outs.get(0));
        addActor(myBoard);
        addActor(groupMusic);
        addActor(myMusic);
        addActor(groupOut);
        addActor(groupIn);

    }

    public boolean convert(float x, float y) {
        if (inputProcessor.mouseMoved((int)x,(int)y)) {
            for (int i = 0; i < 3; i++) {
                if (inputProcessor.mouseMovedd(Gdx.input.getX(), Gdx.input.getY(),ins.get(i).getX(),ins.get(i).getY(),start.getRegionWidth()/scaleIn, start.getRegionHeight()/scaleIn)) {
                    groupIn.removeActor(ins.get(i));
                    groupOut.addActor(outs.get(i));
                    if (Gdx.input.isTouched() && i == 0) {
                        return true;
                    }
                }
                if (!inputProcessor.mouseMovedd(Gdx.input.getX(), Gdx.input.getY(),outs.get(i).getX(),outs.get(i).getY(),start.getRegionWidth()/scaleOut, start.getRegionHeight()/scaleOut)) {
                    groupOut.removeActor(outs.get(i));
                    groupIn.addActor(ins.get(i));
                    /*if (Gdx.input.isTouched() && i == 1) {
                        return true;
                    }*/
                }

            }
        }
        return false;
    }

    public void onOff(MyActor actor1,MyActor actor2,boolean check) {
        if (inputProcessor.mouseMovedd(Gdx.input.getX(), Gdx.input.getY(), actor1.getX(), actor1.getY(),on.getRegionWidth()/2,on.getRegionHeight()/2)) {
            if (Gdx.input.isTouched() && groupMusic.getChild(0) == actor1 && check == true) {
                groupMusic.removeActor(actor1);
                groupMusic.addActor(actor2);
                music.stop();
            } else if (Gdx.input.isTouched() && groupMusic.getChild(0) == actor2 && check == true) {
                groupMusic.removeActor(actor2);
                groupMusic.addActor(actor1);
                music.play();
            }
            check = false;

        }

    }

    @Override
    public void draw() {
        super.draw();
        onOff(myOn,myOff,checkTouch);
        if(!Gdx.input.isTouched()) {
            checkTouch= true;
        } else {
            checkTouch =false;
        }
        //convert(Gdx.input.getX(),Gdx.input.getY());
    }
}