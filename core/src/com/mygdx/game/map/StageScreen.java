package com.mygdx.game.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.entities.DynamicEntity.Bomber;
import com.mygdx.game.entities.DynamicEntity.enemy.Balloon;

import java.io.*;
import java.util.ArrayList;

public class StageScreen extends Stage {
    private final static String FILE = "Lv1.txt";
    private Group groupNoActnoBang;
    private Group groupNoActs;
    private Group groupActs;
    //public Portal portal;
    public Bomber bomber;
    public ArrayList<Balloon> balloons = new ArrayList<>();
    //public ArrayList<Oneal> Oneals;
    //public MyActor xxx;
    ArrayList<MyActor> noActNoBangs = new ArrayList<>();
    ArrayList<MyActor> noActs = new ArrayList<>();
    ArrayList<MyActor> acts = new ArrayList<>();

    public StageScreen() {
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
        addActor(groupNoActnoBang);
        addActor(groupNoActs);
        addActor(groupActs);
    }
    public void insertFromFile() throws IOException {
        TextureRegion wall = new TextureRegion(new Texture("wall.png"));
        TextureRegion brick = new TextureRegion(new Texture("brick.png"));
        //TextureRegion bomber = new TextureRegion(new Texture("player_down.png"));
        TextureRegion portal = new TextureRegion(new Texture("portal.png"));
        TextureRegion oneal = new TextureRegion(new Texture("oneal_left1.png"));
        TextureRegion balloom = new TextureRegion(new Texture("balloom_right1.png"));
        TextureRegion flame = new TextureRegion(new Texture("powerup_flames.png"));
        TextureRegion grass = new TextureRegion(new Texture("grass.png"));

        File file = new File(FILE);
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        int c, x = 0, y = 0;
        while ((c = inputStreamReader.read()) != -1) {
            if (Character.toString((char) c).equals("\n")) {
                x = -1;
                y++;
            } else if (Character.toString((char) c).equals("#")) {
                MyActor myActor = new MyActor(wall);
                myActor.setPosition(x * 32, 384 - y * 32);
                myActor.setBounds(myActor.getX(), myActor.getY(), wall.getRegionWidth() * 2, wall.getRegionHeight() * 2);
                noActNoBangs.add(myActor);
            } else if (Character.toString((char) c).equals("p")) {
                bomber = new Bomber(x * 32, 384 - y * 32);
            } else if (Character.toString((char) c).equals("*")) {
                MyActor myActor = new MyActor(brick);
                myActor.setPosition(x * 32, 384 - y * 32);
                myActor.setBounds(myActor.getX(), myActor.getY(), brick.getRegionWidth() * 2, brick.getRegionHeight() * 2);
                noActs.add(myActor);
            } else if (Character.toString((char) c).equals("f")) {
                MyActor myActor = new MyActor(flame);
                myActor.setPosition(x * 32, 384 - y * 32);
                myActor.setBounds(myActor.getX(), myActor.getY(), flame.getRegionWidth() * 2, flame.getRegionHeight() * 2);
                noActs.add(myActor);
            } else if (Character.toString((char) c).equals("x")) {
                MyActor myActor = new MyActor(portal);
                myActor.setPosition(x * 32, 384 - y * 32);
                myActor.setBounds(myActor.getX(), myActor.getY(), portal.getRegionWidth() * 2, portal.getRegionHeight() * 2);
                noActNoBangs.add(myActor);
                MyActor myActor1 = new MyActor(brick);
                myActor1.setPosition(x * 32, 384 - y * 32);
                myActor1.setBounds(myActor1.getX(), myActor1.getY(), brick.getRegionWidth() * 2, brick.getRegionHeight() * 2);
                noActs.add(myActor1);
            } else if (Character.toString((char) c).equals("1")) {
                Balloon balloon = new Balloon(x * 32, 384 - y * 32);
                balloons.add(balloon);
            } else if (Character.toString((char) c).equals("2")) {
                MyActor myActor = new MyActor(oneal);
                myActor.setPosition(x * 32, 384 - y * 32);
                myActor.setBounds(myActor.getX(), myActor.getY(), oneal.getRegionWidth() * 2, oneal.getRegionHeight() * 2);
                acts.add(myActor);
            }
            if (Character.toString((char) c).equals(" ") || (!Character.toString((char) c).equals("#")
                    && !Character.toString((char) c).equals("x"))) {
                MyActor myActor = new MyActor(grass);
                myActor.setPosition(x * 32, 384 - y * 32);
                myActor.setBounds(myActor.getX(), myActor.getY(), grass.getRegionWidth() * 2, grass.getRegionHeight() * 2);
                noActNoBangs.add(myActor);
            }
            x++;
        }
        /*xxx = new MyActor(brick);
        xxx.setPosition(300,300);
        xxx.setBounds(xxx.getX(), xxx.getY(), brick.getRegionWidth()*3, brick.getRegionHeight()*3);*/
    }

        public void remove ( int x, int y){
            for (int i = 0; i < noActs.size(); i++) {
                if (x >= noActs.get(i).getX() && x < noActs.get(i).getX() + 32) {
                    if (y >= noActs.get(i).getY() && y < noActs.get(i).getY() + 32) {
                        groupNoActs.removeActor(noActs.get(i));
                        noActs.remove(noActs.get(i));
                    }
                }

            }

        }

        public MyActor getAt ( int x, int y){
            for (int i = 0; i < acts.size(); i++) {
                if (x >= acts.get(i).getX() && x < acts.get(i).getX() + 32) {
                    if (y >= acts.get(i).getY() && y < acts.get(i).getY() + 32) {
                        return acts.get(i);
                    }
                }
            }
            for (int i = 0; i < noActs.size(); i++) {
                if (x >= noActs.get(i).getX() && x < noActs.get(i).getX() + 32) {
                    if (y >= noActs.get(i).getY() && y < noActs.get(i).getY() + 32) {
                        return noActs.get(i);
                    }
                }
            }
            for (int i = 0; i < noActNoBangs.size(); i++) {
                if (x >= noActNoBangs.get(i).getX() && x < noActNoBangs.get(i).getX() + 32) {
                    if (y >= noActNoBangs.get(i).getY() && y < noActNoBangs.get(i).getY() + 32) {
                        return noActNoBangs.get(i);
                    }
                }
            }
            return null;
    }



}
