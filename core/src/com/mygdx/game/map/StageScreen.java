package com.mygdx.game.map;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.entities.DynamicEntity.Bomber;
import com.mygdx.game.entities.DynamicEntity.enemy.Balloon;
import com.mygdx.game.entities.StaticEntity.Item.FlameItem;
import com.mygdx.game.entities.StaticEntity.Item.Portal;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;
import com.mygdx.game.entities.StaticEntity.Tile.Grass;
import com.mygdx.game.entities.StaticEntity.Tile.Wall;

import java.io.*;
import java.util.ArrayList;

public class StageScreen extends Stage {
    private final static String LV1 ="core\\assets\\level\\Lv1.txt";
    private final static String LV2 ="core\\assets\\level\\Lv2.txt";
    private final static String LV3 ="core\\assets\\level\\Lv3.txt";
    private Group groupNoActnoBang;
    private Group groupNoActs;
    private Group groupActs;
    public int rows;
    public int columns;
    //public Portal portal;
    public Bomber bomber;
    public ArrayList<Balloon> balloons = new ArrayList<>();
    public char mapMatrix[][] = new char[13][31];
    //public ArrayList<Oneal> Oneals;
    private ArrayList<Actor> noActNoBangs = new ArrayList<>();
    private ArrayList<Actor> noActs = new ArrayList<>();
    private ArrayList<Actor> acts = new ArrayList<>();

    public static StageScreen me;
    public StageScreen(int Lv) {
        me = this;
        String s = "";
        if (Lv == 1) s=LV1;
        if (Lv == 2) s=LV2;
        if (Lv == 3) s=LV3;
        try {
            insertFromFile(s);
        } catch(IOException e) {
            e.printStackTrace();
        }
        groupNoActnoBang = new Group();
        groupNoActs = new Group();
        groupActs = new Group();
        for(int i = 0 ; i < noActNoBangs.size(); i++) {
            groupNoActnoBang.addActor(noActNoBangs.get(i));
        }
        for(int i = 0 ; i < noActs.size(); i++) {
            groupNoActs.addActor(noActs.get(i));
        }
        for(int i = 0 ; i < balloons.size(); i++) {
            groupActs.addActor(balloons.get(i));
        }
        groupActs.addActor(bomber);
        addActor(groupNoActnoBang);
        addActor(groupNoActs);
        addActor(groupActs);

    }
    public void insertFromFile(String fileName) throws IOException {

        File file = new File(fileName);
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        int c, x = 0, y = 0;
        while ((c = inputStreamReader.read()) != -1) {
            if (Character.toString((char) c).equals("\n")) {
                x = -1;
                y++;
            } else if ((char) c == '#') {
                Wall wall = new Wall(x * 32, 384 - y * 32);
                noActNoBangs.add(wall);
            } else if (Character.toString((char) c).equals("p")) {
                bomber = new Bomber(x * 32, 384 - y * 32);
            } else if (Character.toString((char) c).equals("*")) {
                Brick brick = new Brick(x * 32, 384 - y * 32);
                noActs.add(brick);
            } else if (Character.toString((char) c).equals("f")) {
                Brick brick = new Brick(x * 32, 384 - y * 32);
                FlameItem flameItem= new FlameItem(brick);
                noActs.add(flameItem);
            } else if (Character.toString((char) c).equals("x")) {
                Brick brick = new Brick(x * 32, 384 - y * 32);
                Portal portal = new Portal(brick);
                noActNoBangs.add(portal);
            } else if (Character.toString((char) c).equals("1")) {
                Balloon balloon = new Balloon(x * 32, 384 - y * 32);
                balloons.add(balloon);
            } else if (Character.toString((char) c).equals("2")) {
                /*MyActor myActor = new MyActor(oneal);
                myActor.setPosition(x * 32, 384 - y * 32);
                myActor.setBounds(myActor.getX(), myActor.getY(), oneal.getRegionWidth() * 2, oneal.getRegionHeight() * 2);
                acts.add(myActor);*/
            }
            if (Character.toString((char) c).equals(" ") || (!Character.toString((char) c).equals("#")
                    && !Character.toString((char) c).equals("x") && !Character.toString((char) c).equals("\r"))) {
                Grass grass = new Grass(x * 32, 384 - y * 32);
                noActNoBangs.add(grass);
            }
            if (x < 31 && x != -1 && y >= 2) mapMatrix[y-2][x] = (char)c;
            x++;
        }
    }

    public String Stringmap() {
        String  s = "";
        for(int i = 0; i < 13; i++) {
            for(int j = 0;j <31 ;j++) {
                s = s + mapMatrix[i][j];
            }
            s = s + "\n";
        }
        return s;
    }
    /**
     *  Hàm remove dùng để xóa Actor
     * @param myActor .
     */
    public void remove (MyActor myActor) {
        for (int i = 0; i < noActs.size(); i++) {
            if (noActs.get(i) == myActor) {
                groupNoActs.removeActor(noActs.get(i));
                noActs.remove(noActs.get(i));
            }
        }
        for (int i = 0; i < acts.size(); i++) {
            if (acts.get(i) == myActor) {
                groupActs.removeActor(acts.get(i));
                acts.remove(acts.get(i));
            }
        }
    }

    /**
     * Hàm getAt trả về Actor đang ở vị trí đầu vào.
     * @param x
     * @param y
     * @return
     */
    public Actor getAt ( float x, float y) {
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
