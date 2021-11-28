package com.mygdx.game.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.MyInputProcessor;

import java.util.ArrayList;

public class StageChange extends Stage {

    private TextureRegion board = new TextureRegion(new Texture("cartoon/board.png"));
    private TextureRegion start = new TextureRegion(new Texture("cartoon/start.gif"));
    //private TextureRegion anhchuyen = new TextureRegion(new Texture("cartoon/start.gif"));
    //private MyActor  manHinh = new MyActor(anhchuyen);
    private ArrayList<MyActor> ins = new ArrayList<>();
    private ArrayList<MyActor> outs = new ArrayList<>();
    public Group groupIn = new Group();
    public Group groupOut = new Group();
    public MyInputProcessor  inputProcessor = new MyInputProcessor();
    private float scaleOut = (float) 2.1;
    private float scaleIn = (float) 2.5;
    public StageChange() {
        MyActor  myBoard = new MyActor(board);
        myBoard.setPosition(270,140);
        myBoard.setBounds(myBoard.getX(), myBoard.getY(), board.getRegionWidth()/4, board.getRegionHeight()/4);
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
        groupIn.addActor(ins.get(0));
        groupIn.addActor(ins.get(1));
        //groupOut.addActor(outs.get(0));

        addActor(myBoard);
        addActor(groupOut);
        addActor(groupIn);
    }

    public void convert(float x, float y) {
        if (inputProcessor.mouseMoved((int)x,(int)y)) {
            for (int i = 0; i < 2; i++) {
                if (inputProcessor.mouseMovedd(Gdx.input.getX(), Gdx.input.getY(),ins.get(i).getX(),ins.get(i).getY(),start.getRegionWidth()/scaleIn, start.getRegionHeight()/scaleIn)) {
                    groupIn.removeActor(ins.get(i));
                    groupOut.addActor(outs.get(i));
                }
                if (!inputProcessor.mouseMovedd(Gdx.input.getX(), Gdx.input.getY(),outs.get(i).getX(),outs.get(i).getY(),start.getRegionWidth()/scaleOut, start.getRegionHeight()/scaleOut)) {
                    groupOut.removeActor(outs.get(i));
                    groupIn.addActor(ins.get(i));
                }

            }
        }
    }

}
