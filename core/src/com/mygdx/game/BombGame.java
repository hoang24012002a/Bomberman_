package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.entities.StaticEntity.Bomb.Bomb;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;
import com.mygdx.game.entities.StaticEntity.Tile.Grass;
import com.mygdx.game.entities.StaticEntity.Tile.Wall;
import com.mygdx.game.map.StageChange;
import com.mygdx.game.map.StageInfomation;
import com.mygdx.game.map.StageMenu;
import com.mygdx.game.map.StageScreen;

import java.util.*;


public class BombGame implements ApplicationListener {
	//private int dem1 = 1;
	//private int dem2 = 1;
	private int dem = 0;
	private Stage stage;
	private StageChange stageChange;
	private StageScreen stageScreen;
	private StageMenu stageMenu;
	private StageInfomation stageInfomation;
	private ArrayList<StageScreen> stageScreens = new ArrayList<>();
	private SpriteBatch batch;
	private BitmapFont font;
	private boolean check = true;
	private boolean checkTouch =true;
	private MyInputProcessor myInputProcessor;
	@Override
	public void create () {
		myInputProcessor = new MyInputProcessor();
		stage = new Stage(new ScreenViewport());
		batch = new SpriteBatch();
		font = new BitmapFont();
		stageInfomation = new StageInfomation();
		stageMenu = new StageMenu();
		stageScreen = new StageScreen(1);
		stageScreens.add(stageScreen);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//stageChange.act(Gdx.graphics.getDeltaTime());
//		if(check == false) {
//			stageMenu.draw();
//			stageMenu.onOff(stageMenu.myOn,stageMenu.myOff,checkTouch);
//			if(!Gdx.input.isTouched()) {
//				checkTouch= true;
//			} else {
//				checkTouch =false;
//			}
//			if (stageMenu.convert(Gdx.input.getX(), Gdx.input.getY())) {
//				//check = true;
//				//stageMenu.dispose();
//				dispose();
//				dem++;
//				if (dem == 3) dem = 0;
//			}
//
//		}
		/**
		 * I fix here
		 * */
		if(check) {
			stageScreens.get(dem).act(Gdx.graphics.getDeltaTime());
			stageScreens.get(dem).draw();
			batch.begin();
//			font.draw(batch,"0",stageScreens.get(dem).bombArounds(32*3, 32*5).get(0).getX(), stageScreens.get(dem).bombArounds(32*4, 32*5).get(0).getY()+20);
//			font.draw(batch,"1",stageScreens.get(dem).bombArounds(32*3, 32*5).get(1).getX(), stageScreens.get(dem).bombArounds(32*4, 32*5).get(1).getY()+20);
//			font.draw(batch,"2",stageScreens.get(dem).bombArounds(32*3, 32*5).get(2).getX(), stageScreens.get(dem).bombArounds(32*4, 32*5).get(2).getY()+20);
//			font.draw(batch,"3",stageScreens.get(dem).bombArounds(32*3, 32*5).get(3).getX(), stageScreens.get(dem).bombArounds(32*4, 32*5).get(3).getY()+20);
//			font.draw(batch,"Exit",470,250);
//			font.draw(batch,String.valueOf(stageScreen.Stringmap()),300,300);
			batch.end();
//			System.out.println(stageScreens.get(dem).getAt(Gdx.input.getX(),550-Gdx.input.getY()));
			if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
				//check = false;
				//stageScreens.get(dem).dispose();
			}
		}
		//stageInfomation.draw();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose () {
		stage.dispose();
		stageScreen.dispose();
		stageScreens.get(0).dispose();
		stageScreens.get(1).dispose();
		stageScreens.get(2).dispose();
		stageChange.dispose();
		stageMenu.dispose();
		stageInfomation.dispose();
	}

	public void createNewLever(int dem) {
		stageScreens.remove(dem);
		for(int i = stageScreens.size() -1 ; i> dem ; i--) {
			stageScreens.set(i,stageScreens.get(i-1));
		}
		StageScreen stageScreen = new StageScreen(dem +1);
		stageScreens.set(dem,stageScreen);
	}

}

/*
batch.begin();
		font.draw(batch,stageScreens.get(0).Stringmap(),470,300);
		font.draw(batch,"Exit",470,250);
		//font.draw(batch,String.valueOf(stageScreen.Stringmap()),300,300);
		batch.end();
 */