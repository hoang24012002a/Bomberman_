package com.mygdx.game.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

import java.util.ArrayList;

public class StagePlay extends Stage {
    private BitmapFont font = new BitmapFont();
    private Window pauseWindow;
    private Sound music = Gdx.audio.newSound(Gdx.files.internal("music/Bomno.wav"));
    public ArrayList<StageScreen> stageScreens = new ArrayList<>();
    //public Group groupStageScreen = new Group();
    private StageScreen stageScreen;
    private StageMenu stageMenu;
    private StageChange stageChange;
    private int lv = 1;

    public StagePlay() {
        setListStageScreens();
        stageMenu = new StageMenu();
        this.stageScreen = stageScreens.get(lv-1);

    }
    public void setListStageScreens() {
        stageScreens.add(new StageScreen(1));
        stageScreens.add(new StageScreen(2));
        stageScreens.add(new StageScreen(3));
    }
    public void levelUp() {
        lv++;
        if(lv < 4)  {
            this.stageScreen =  stageScreens.get(lv - 1);
        }
    }

    /* public void playAgain() {
        if(lv == 4 && playAgain() == true) {
            lv = 1 ;
            stageScreens.clear();
            setListStageScreens();
        }
    }*/

    boolean chuyenman =false;
    public void draw() {
        //stageScreens.get(lv - 1).draw();

        if (chuyenman == false) {
            this.stageMenu.draw();
            if (this.stageMenu.convert(Gdx.input.getX(), Gdx.input.getY()) == true) {
                chuyenman = true;
            }
        } else {
            this.stageScreen.draw();
            //Bang();
            Pause();
            if (kt == false) {
                stageChange = new StageChange();
                this.stageChange.draw();
            }

        }
        /*if(stageScreens.get(lv - 1).bomber.getX() == 150) {
            levelUp();
        }*/
        //
    }
    public void act(float delta) {
        //stageScreens.get(lv - 1).act();
        //stageScreens.get(lv - 1).act(Gdx.graphics.getDeltaTime());
        //Pause();
        if (kt == true) {
            stageScreens.get(lv - 1).act();
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
            kt = !kt;
            kt2 = false;
        }
        if (!Gdx.input.isKeyPressed(Input.Keys.P)) {
            kt2 = true;
        }

    }



}