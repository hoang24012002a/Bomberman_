package com.mygdx.game;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.io.*;
import java.util.ArrayList;

public class Bomb implements ApplicationListener {
    private final static String FILE = "text.txt";
    private Stage stage;
    private Group groupNoActnoBang;
    private Group groupNoActs;
    private Group groupActs;
    private MyActor bomberrr;
    private boolean kt = true;
    class MyActor extends Actor  {
        public TextureRegion text;
        public MyActor(TextureRegion text) {
            this.text = text;
        }
        public void draw(Batch batch, float alpha){
            batch.draw(text, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(),
                    getScaleX(), getScaleY(), getRotation());
        }
    };
    ArrayList<MyActor> noActNoBangs = new ArrayList<>();
    ArrayList<MyActor> noActs = new ArrayList<>();
    ArrayList<MyActor> acts = new ArrayList<>();

    public void insertFromFile() throws IOException {
       // Sprite sprite = new Sprite(100,100,Sprite..getFxImage());
        TextureRegion wall = new TextureRegion(new Texture("wall.png"));
        TextureRegion brick = new TextureRegion(new Texture("brick.png"));
        TextureRegion bomber = new TextureRegion(new Texture("player_down.png"));
        TextureRegion portal = new TextureRegion(new Texture("portal.png"));
        TextureRegion bomb = new TextureRegion(new Texture("bomb.png"));
        TextureRegion oneal = new TextureRegion(new Texture("oneal_left1.png"));
        TextureRegion balloom = new TextureRegion(new Texture("balloom_right1.png"));
        //TextureRegion balloom = new Entity("ballom",15,"balloom_right1.png");
        TextureRegion flame = new TextureRegion(new Texture("powerup_flames.png"));
        TextureRegion grass = new TextureRegion(new Texture("grass.png"));

        File file = new File(FILE);
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        int c, x = 0, y = 0;
        while ((c = inputStreamReader.read()) != -1) {
            if (Character.toString((char)c).equals("\n")) {
                x = -1;
                y++;
            } else if (Character.toString((char)c).equals("#"))  {
                MyActor myActor = new MyActor(wall);
                myActor.setPosition(x*48,576-y*48);
                myActor.setBounds(myActor.getX(), myActor.getY(), wall.getRegionWidth()*3, wall.getRegionHeight()*3);
                noActNoBangs.add(myActor);
            } else if (Character.toString((char)c).equals("p")) {
                bomberrr = new MyActor(bomber);
                bomberrr.setPosition(x*48,576-y*48);
                bomberrr.setBounds(bomberrr.getX(), bomberrr.getY(), bomber.getRegionWidth()*3, bomber.getRegionHeight()*3);
            } else if (Character.toString((char)c).equals("*")) {
                MyActor myActor = new MyActor(brick);
                Entity entity = new Entity();
                myActor.setPosition(x*48,576-y*48);
                myActor.setBounds(myActor.getX(), myActor.getY(), brick.getRegionWidth()*3, brick.getRegionHeight()*3);
                noActs.add(myActor);
            } else if (Character.toString((char)c).equals("f")) {
                MyActor myActor = new MyActor(flame);
                myActor.setPosition(x*48,576-y*48);
                myActor.setBounds(myActor.getX(), myActor.getY(), flame.getRegionWidth()*3, flame.getRegionHeight()*3);
                noActs.add(myActor);
            } else if (Character.toString((char)c).equals("x")) {
                MyActor myActor = new MyActor(portal);
                myActor.setPosition(x*48,576-y*48);
                myActor.setBounds(myActor.getX(), myActor.getY(), portal.getRegionWidth()*3, portal.getRegionHeight()*3);
                noActNoBangs.add(myActor);
            } else if (Character.toString((char)c).equals("1")) {
                MyActor myActor = new MyActor(balloom);
                myActor.setPosition(x*48,576-y*48);
                myActor.setBounds(myActor.getX(), myActor.getY(), balloom.getRegionWidth()*3, balloom.getRegionHeight()*3);
                acts.add(myActor);
            } else if (Character.toString((char)c).equals("2")) {
                MyActor myActor = new MyActor(oneal);
                myActor.setPosition(x*48,576-y*48);
                myActor.setBounds(myActor.getX(), myActor.getY(), oneal.getRegionWidth()*3, oneal.getRegionHeight()*3);
                acts.add(myActor);

            }
            if (Character.toString((char)c).equals(" ") || !Character.toString((char)c).equals("#")) {
                MyActor myActor = new MyActor(grass);
                myActor.setPosition(x*48,576-y*48);
                myActor.setBounds(myActor.getX(), myActor.getY(), grass.getRegionWidth()*3, grass.getRegionHeight()*3);
                noActNoBangs.add(myActor);
            }
            x++;
        }
    }

    @Override
    public void create () {
        stage = new Stage();

        try {
            insertFromFile();
        } catch(IOException e) {
            e.printStackTrace();
        }
        groupNoActnoBang = new Group();
        groupNoActs = new Group();
        groupActs = new Group();
        for(int i = 0 ; i < noActNoBangs.size();i++) {
            groupNoActnoBang.addActor(noActNoBangs.get(i));
        }
        for(int i = 0 ; i < noActs.size();i++) {
            groupNoActs.addActor(noActs.get(i));
        }
        for(int i = 0 ; i < acts.size();i++) {
            groupActs.addActor(acts.get(i));
        }
        stage.addActor(groupNoActnoBang);
        stage.addActor(groupNoActs);
        stage.addActor(groupActs);
        stage.addActor(bomberrr);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        /*MoveToAction moveToAction1 = new MoveToAction();
        bomberrr.setPosition(bomberrr.getX() , bomberrr.getY());
        moveToAction1.setDuration(1f);
        bomberrr.setPosition(bomberrr.getX() + 100, bomberrr.getY());
        bomberrr.addAction(moveToAction1);*/
        //bomberrr.setX(bomberrr.getX()+1);
        stage.draw();
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)) {
                bomberrr.setX(bomberrr.getX()+100);
            } else {
                bomberrr.setX(bomberrr.getX()-2);
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)) {
                bomberrr.setX(bomberrr.getX()-100);
            } else {
                bomberrr.setX(bomberrr.getX()+2);
            }

        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)) {
                bomberrr.setY(bomberrr.getY()-100);
            } else {
                bomberrr.setY(bomberrr.getY()+2);
            }

        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)) {
                bomberrr.setY(bomberrr.getY()+100);
            } else {
                bomberrr.setY(bomberrr.getY()-2);
            }

        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
               kt = !kt;
        }
        if (kt == true) {
            bomberrr.setX(bomberrr.getX() + 2);
        }
        remove((int)bomberrr.getX(),(int)bomberrr.getY());

        //Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());

    }

    public void remove(int x, int y) {
        for (int i = 0; i < noActs.size(); i++) {
            if(x>=noActs.get(i).getX() && x<noActs.get(i).getX()+48) {
                if(y>=noActs.get(i).getY() && y<noActs.get(i).getY()+48) {
                    groupNoActs.removeActor(noActs.get(i));
                    noActs.remove(noActs.get(i));
                }
            }

        }

    }

    public Actor getAt(int x, int y) {
        for (int i = 0; i < acts.size() ; i++) {
            if(x>=acts.get(i).getX() && x<acts.get(i).getX()+48) {
                if(y>=acts.get(i).getY() && y<acts.get(i).getY()+48) {
                    return acts.get(i);
                }
            }
        }
        for (int i = 0; i < noActs.size() ; i++) {
            if(x>=noActs.get(i).getX() && x<noActs.get(i).getX()+48) {
                if(y>=noActs.get(i).getY() && y<noActs.get(i).getY()+48) {
                    return noActs.get(i);
                }
            }
        }
        for (int i = 0; i < noActNoBangs.size() ; i++) {
            if(x>=noActNoBangs.get(i).getX() && x<noActNoBangs.get(i).getX()+48) {
                if(y>=noActNoBangs.get(i).getY() && y<noActNoBangs.get(i).getY()+48) {
                    return noActNoBangs.get(i);
                }
            }
        }
        return null;
    }


    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
