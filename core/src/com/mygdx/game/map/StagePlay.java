package com.mygdx.game.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.mygdx.game.gamesys.GameManager;

import java.util.ArrayList;

public class StagePlay extends Stage {
    private SpriteBatch batch = new SpriteBatch();
    private BitmapFont font = new BitmapFont();
    //private Window pauseWindow;
    private Sound music = Gdx.audio.newSound(Gdx.files.internal("music/Bomno.wav"));
    public ArrayList<StageScreen> stageScreens = new ArrayList<>();
//    public Group groupStageScreen = new Group();
    private StageScreen stageScreen;
    private StageMenu stageMenu;
    private StageChange stageChange;
    private StageChange stageChangeLose;
    private StageChange stageChangeWin;
    private StageInfomation stageInfomation;
    private int lv = 1;
    public boolean exit = false;
    private boolean checkWin = false;
    public StagePlay() {
        setListStageScreens();
        stageMenu = new StageMenu();
        stageChange = new StageChange("pause");
        stageChangeLose = new StageChange("lose");
        stageChangeWin = new StageChange("win");
        //this.stageScreen = new StageScreen(1);
        this.stageScreen = stageScreens.get(lv-1);
        stageInfomation = new StageInfomation(this.stageScreen);
    }
    public void setListStageScreens() {
        //stageScreens.add(new StageScreen(1));
       // stageScreens.add(new StageScreen(2));
        //stageScreens.add(new StageScreen(3));
        stageScreens.add(new StageScreen(1));
    }
    public void levelUp() {
        lv++;
        if(lv < 4)  {
            //this.stageScreen =  new StageScreen(lv);
            stageScreens.add(new StageScreen(lv));
            this.stageScreen = stageScreens.get(lv-1);
            this.stageInfomation = new StageInfomation(this.stageScreen);
            //this.stageScreen =  stageScreens.get(lv - 1);
        }
    }

     public void playAgain() {

            lv = 1;
            checkWin = false;
            //stageScreen.clear();
            stageScreens.clear();
            setListStageScreens();
            this.stageChange = new StageChange("pause");
            //stageScreens.add(new StageScreen(lv));
            //this.stageScreen =  new StageScreen(lv);
            this.stageScreen = stageScreens.get(lv-1);
            this.stageInfomation = new StageInfomation(this.stageScreen);
            stageChangeLose.checkStageChangedraw = true;
            stageChangeWin.checkStageChangedraw = true;
    }

    boolean chuyenman =false;
    public void draw() {
        //stageScreens.get(lv - 1).draw();

        if (chuyenman == false) {
            //System.out.println("love");
            kt = true;

            this.stageMenu.draw();
            if (this.stageMenu.convert(Gdx.input.getX(), Gdx.input.getY())[0] == true) {
                chuyenman = true;
                playAgain();
            } if (this.stageMenu.convert(Gdx.input.getX(), Gdx.input.getY())[1] == true){
                System.out.println("thoat");
                exit = true;
            }

        } else {
            this.stageScreen.draw();
            this.stageInfomation.draw();
            this.stageScreen.comeBack();


            //System.out.println(stageScreens.get(lv - 1).getAt(Gdx.input.getX(),550-Gdx.input.getY()));
            if (lv <4) {
                //stageScreens.get(lv - 1).bomber.getX() >= 100
                // cheat qua man
            if((stageScreens.get(lv - 1).CheckAllEnemyDeath() && stageScreens.get(lv - 1).CheckInPortal()) || Gdx.input.isKeyJustPressed(Input.Keys.C)) {
                    levelUp();
                    if (lv >= 4) checkWin = true;

            }}
            Pause();
            if(lv >= 4 || this.stageScreen.numberlives == 0) { kt =false;}
            if (kt == false) {

                 if (lv >=4 || this.stageScreen.numberlives == 0) {
                     //this.stageChangeLose = new StageChange("lose");
                     if (checkWin == false) {

                         this.stageChangeLose.draw();
                         if (this.stageChangeLose.convert(Gdx.input.getX(), Gdx.input.getY())[0] == true) {
                             System.out.println("exit1");
                             exit = true;
                         }
                         if (this.stageChangeLose.convert(Gdx.input.getX(), Gdx.input.getY())[1] == true) {
                             System.out.println("menu");
                             chuyenman = false;
                             stageMenu = new StageMenu();
                         }
                         if (this.stageChangeLose.convert(Gdx.input.getX(), Gdx.input.getY())[2] == true) {
                             stageScreens.remove(stageScreens.get(lv-1));
                             stageScreens.add(new StageScreen(lv));
                             this.stageChange = new StageChange("pause");
                             this.stageScreen = stageScreens.get(lv-1);
                             this.stageInfomation = new StageInfomation(this.stageScreen);
                             stageChangeLose.checkStageChangedraw = true;
                             kt = true;
                         }
                     } else {
                         this.stageChangeWin.draw();
                         if (this.stageChangeWin.convert(Gdx.input.getX(), Gdx.input.getY())[0] == true) {
                             System.out.println("exit1");
                             exit = true;
                         }
                         if (this.stageChangeWin.convert(Gdx.input.getX(), Gdx.input.getY())[1] == true) {
                             System.out.println("menu");
                             chuyenman = false;
                             stageMenu = new StageMenu();
                         }
                     }
                 } else {
                     this.stageChange.draw();
                     if (this.stageChange.convert(Gdx.input.getX(), Gdx.input.getY())[0] == true) {
                         System.out.println("exit2");
                         exit = true;
                     }
                     if (this.stageChange.convert(Gdx.input.getX(), Gdx.input.getY())[1] == true) {
                         System.out.println("menu2");
                         kt = true;
//                         chuyenman = false;
//                         stageMenu = new StageMenu();
                     }
                 }
            }
        }
    }
    public void act(float delta) {
        //stageScreens.get(lv - 1).act();
        //stageScreens.get(lv - 1).act(Gdx.graphics.getDeltaTime());
        //Pause();
        if (kt == true && chuyenman == true) {
            //this.stageScreen.act();
            if(lv >3) lv =3;
            this.stageScreen.act();
            //this.stageInfomation.act();
        }

    }

    public void Bang() {
        if(stageScreens.get(lv-1).bomber.getX() == 50) {
            //music.play();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (stageScreens.get(lv-1).bomber.getX() == 50) {
                        try {
                             Thread.sleep(3000);
                             music.play();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

          }
    }

    /*public void PauseScreen() {
        if (Gdx.input.isKeyPressed(Input.Keys.P)) {
            this.stageScreen.;
        }
    }*/
    boolean kt = true;
    boolean kt2 = true;
    public void Pause() {
        if (Gdx.input.isKeyPressed(Input.Keys.P) && kt2 == true) {
            stageChange.checkStageChangedraw = true;
            kt = !kt;
            kt2 = false;
        }
        if (!Gdx.input.isKeyPressed(Input.Keys.P)) {
            kt2 = true;
        }
    }

}

  /*batch.begin();
			font.draw(batch,"0",this.stageScreen.bombArounds(32*6, 32*11).get(0).getX(), this.stageScreen.bombArounds(32*4, 32*11).get(0).getY()+20);
			font.draw(batch,"1",this.stageScreen.bombArounds(32*6, 32*11).get(1).getX(), this.stageScreen.bombArounds(32*4, 32*11).get(1).getY()+20);
			font.draw(batch,"2",this.stageScreen.bombArounds(32*6, 32*11).get(2).getX(), this.stageScreen.bombArounds(32*4, 32*11).get(2).getY()+20);
			font.draw(batch,"3",this.stageScreen.bombArounds(32*6, 32*11).get(3).getX(), this.stageScreen.bombArounds(32*4, 32*11).get(3).getY()+20);

            batch.end();*/