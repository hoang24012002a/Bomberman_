package com.mygdx.game.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.entities.DynamicEntity.Bomber;
import com.mygdx.game.entities.DynamicEntity.enemy.Balloon;
import com.mygdx.game.entities.DynamicEntity.enemy.Doll;
import com.mygdx.game.entities.DynamicEntity.enemy.Oneal;
import com.mygdx.game.entities.StaticEntity.Bomb.FlameManager;
import com.mygdx.game.entities.StaticEntity.Item.FlameItem;
import com.mygdx.game.entities.StaticEntity.Item.Portal;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;
import com.mygdx.game.entities.StaticEntity.Tile.Grass;
import com.mygdx.game.entities.StaticEntity.Tile.Wall;

import java.io.*;
import java.util.ArrayList;

public class StageScreen extends Stage {
//<<<<<<< HEAD
    private final static String LV1 = "D:\\Object Oriented Programing\\bomberman\\Bomberman_\\core\\assets\\level\\Lv1.txt";
  // =======
  //    private final static String LV1 =".\\core\\assets\\level\\Lv1.txt";
  // >>>>>>> 1abe639d5dfb9ff33ad2ff197d06b2375ba3a438
  private final static String LV2 =
      "D:\\Object Oriented Programing\\bomberman\\Bomberman_\\core\\assets\\level\\Lv2.txt";
  private final static String LV3 =
      "D:\\Object Oriented Programing\\bomberman\\Bomberman_\\core\\assets\\level\\Lv3.txt";
    private final static int textureSize = 32;
    private Group groupNoActnoBang;
    private Group groupNoActs;
    private Group groupActs;
    //private ArrayList<Actor> bombAround = new ArrayList<>();
    public int rows;
    public int columns;
    public int dem = 0;
    //public Portal portal;
    public Bomber bomber;
    public static ArrayList<Balloon> balloons = new ArrayList<>();
    //mang 2 chieu ki tu.
    // 0 là ko đi đc , p là bomber , 1 ,2 , 3 là balloon, oneal,vv.
    // n là đi đc.
    public char mapMatrix[][] ;
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
        for(int i = 0 ; i < acts.size(); i++) {
            groupActs.addActor(acts.get(i));
        }

        addActor(groupNoActnoBang);
        addActor(groupNoActs);
        addActor(groupActs);

    }

    public void insertFromFile(String fileName) throws IOException {

        File file = new File(fileName);
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        rows = Integer.parseInt(reader.readLine());
        columns = Integer.parseInt(reader.readLine());
        mapMatrix = new char[rows][columns];
        int c, x = 0, y = 0;
        while ((c = reader.read()) != -1) {
            if (Character.toString((char) c).equals("\n")) {
                x = -1;
                y++;
            } else if ((char) c == '#') {
                Wall wall = new Wall(x * textureSize, textureSize * (rows-1) - y * textureSize);
                noActNoBangs.add(wall);
            } else if (Character.toString((char) c).equals("p")) {
                bomber = new Bomber(x * textureSize, textureSize * (rows-1) - y * textureSize);
                acts.add(bomber);
            } else if (Character.toString((char) c).equals("*")) {
                Brick brick = new Brick(x * textureSize, textureSize * (rows-1) - y * textureSize);
                noActs.add(brick);
            } else if (Character.toString((char) c).equals("f")) {
                Brick brick = new Brick(x * textureSize, textureSize * (rows-1) - y * textureSize);
                FlameItem flameItem= new FlameItem(brick);
                noActs.add(flameItem);
                noActs.add(brick);
            } else if (Character.toString((char) c).equals("x")) {
                Brick brick = new Brick(x * textureSize, textureSize * (rows-1) - y * textureSize);
                Portal portal = new Portal(brick);
                noActNoBangs.add(portal);
                noActs.add(brick);
            } else if (Character.toString((char) c).equals("1")) {
                Balloon balloon = new Balloon(x * textureSize, textureSize * (rows-1) - y * textureSize);
                balloons.add(balloon);
                acts.add(balloon);
            } else if (Character.toString((char) c).equals("2")) {
                Actor oneal = new Oneal(x * 32, 384 - y * 32);
                acts.add(oneal);
            } else if (Character.toString((char) c).equals("3")) {
                Actor doll = new Doll(x * 32, 384 - y * 32);
                acts.add(doll);
            }
            if (Character.toString((char) c).equals(" ") || (!Character.toString((char) c).equals("#")
                    && !Character.toString((char) c).equals("x") && !Character.toString((char) c).equals("\r"))) {
                Grass grass = new Grass(x * textureSize, textureSize * (rows-1) - y * 32);
                noActNoBangs.add(grass);
            }
            if (x < columns && x != -1) {
                if((char)c == '*' || (char)c == '#' || (char)c == 'f' || (char)c == 'b' || (char)c == 's') {
                    mapMatrix[rows-1-y][x] = '0';
                } else if ((char)c != 'p' && (char)c != '1' && (char)c != '2' && (char)c != '3' ) {
                    mapMatrix[rows-1-y][x] = 'n';
                } else {
                    mapMatrix[rows-1-y][x] = (char)c;
                }
            }
            x++;
            dem++;
        }
    }

    public String Stringmap() {
        String  s = "";
        for(int i = 12; i >= 0; i--) {
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
    public void remove (Actor myActor) {
        for (int i = 0; i < acts.size(); i++) {
            if (acts.get(i) == myActor) {
                groupActs.removeActor(acts.get(i));
                acts.remove(acts.get(i));
            }
        }
        for (int i = 0; i < noActs.size(); i++) {
            if (noActs.get(i) == myActor) {
                groupNoActs.removeActor(noActs.get(i));
                noActs.remove(noActs.get(i));
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
            if (x >= acts.get(i).getX() && x < acts.get(i).getX() + textureSize) {
                if (y >= acts.get(i).getY() && y < acts.get(i).getY() + textureSize) {
                    return acts.get(i);
                }
            }
        }
        for (int i = 0; i < noActs.size(); i++) {
            if (x >= noActs.get(i).getX() && x < noActs.get(i).getX() + textureSize) {
                if (y >= noActs.get(i).getY() && y < noActs.get(i).getY() + textureSize) {
                    return noActs.get(i);
                }
            }
        }
        for (int i = 0; i < noActNoBangs.size(); i++) {
            if (x >= noActNoBangs.get(i).getX() && x < noActNoBangs.get(i).getX() + textureSize) {
                if (y >= noActNoBangs.get(i).getY() && y < noActNoBangs.get(i).getY() + textureSize) {
                    return noActNoBangs.get(i);
                }
            }
        }
        return null;
    }

    public boolean CheckInPortal(float x,float y) {
        /*if (bomber.getX() + 32 < portal.getX() || bomber.getX() > portal.getX() + 32
                || bomber.getY() + 32 < portal.getY() || bomber.getY() > portal.getY() +32) {
            return true;
        }*/
        if (getAt(x,y) instanceof Portal) {
            return true;
        }
        return false;
    }

    public boolean CheckAllEnemyDeath(){
        if (balloons.size() == 0) {
            //&& stageScreen.oneals == 0)
            return true;
        }
        return false;
    }

    public boolean changeOfLevelUp(float x, float y) {
        /*if (CheckInPortal(x,y)) {
            return true;
        }*/
        if (bomber.getX() == 200) {
            return true;
        }
        return false;
    }

   /* public void pauseReal() {
        for (int i =0; i < balloons.size(); i++) {
            balloons.get(i).;
        }
    }*/

    // Function addBombg
    public void addBomb(Actor actor){
        noActs.add(0, actor);
        groupNoActs.addActor(actor);
    }

    public void addFlames(FlameManager flameManager){
        System.out.println("work");
        for(int i = 0; i < flameManager.sizeFlame(); i++){
            noActs.add(flameManager.getFlames().get(i));
            groupNoActs.addActor(flameManager.getFlames().get(i));
        }
    }

    /**
     * mảng 4 phần tử gạch, tường xung quanh quả bom.
     * [0]:up,[1]:down,[2]:right,[3]:left;
     * @param x, y.
     * @return ArrayList<Actor>
     */
    public ArrayList<Actor> bombArounds(float x, float y) {
//        System.out.println("ok");
        ArrayList<Actor> bombAround = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            if (getAt(x + 1, textureSize * (i + 1) + y) instanceof Wall
                    || getAt(x + 1, textureSize * (i + 1) + y) instanceof Brick) {
                bombAround.add(getAt(x + 1, textureSize * (i + 1) + y));
                break;
            }
        }
        for (int i = 0; i < 11; i++) {
            if (getAt(x + 1, textureSize * (-i - 1) + y +2) instanceof Wall
                    || getAt(x + 1, textureSize * (-i - 1) + y +2) instanceof Brick) {
                bombAround.add(getAt(x + 1, textureSize * (-i - 1) + y+2));
                break;
            }
        }
        for (int i = 0; i < 29; i++) {
            if (getAt(textureSize * (i + 1) + x, y + 1) instanceof Wall
                    || getAt(textureSize * (i + 1) + x, y + 1) instanceof Brick) {
                bombAround.add(getAt(textureSize * (i + 1) + x, y + 1));
                break;
            }
        }
        for (int i = 0; i < 29; i++) {
            if (getAt(textureSize * (-i - 1) + x, y + 1) instanceof Wall
                    || getAt(textureSize * (-i - 1) + x, y + 1) instanceof Brick) {
                bombAround.add(getAt(textureSize * (-i - 1) + x, y + 1));
                break;
            }
        }
        return bombAround;
    }
}
