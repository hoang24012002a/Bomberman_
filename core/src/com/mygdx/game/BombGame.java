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

import java.util.ArrayList;


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
		stageScreen = new StageScreen(2);
		stageScreens.add(stageScreen);
		stageScreen = new StageScreen(3);
		stageScreens.add(stageScreen);
		stageChange = new StageChange();
		//Bomber bomber = new Bomber(0, 0);
		//Balloon balloon = new Balloon(200,200);
		//Balloon balloon1 = new Balloon(250,200);
		Wall wall = new Wall(30,30);
		Brick brick = new Brick(0, 0);
		Grass grass = new Grass(80, 80);
//		SpeedItem speedItem = new SpeedItem(brick); // checked
		Bomb bomb = new Bomb(40, 40); // checked
		//Array<Flame> flames = new Flame(90,90).getFlameHorizon();
		//stage.addActor(balloon);
		//stage.addActor(balloon1);
		//stage.addActor(wall);
		stage.addActor(bomb);
		stage.addActor(grass);

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//stageChange.act(Gdx.graphics.getDeltaTime());
		if(check == false) {
			stageMenu.draw();
			stageMenu.onOff(stageMenu.myOn,stageMenu.myOff,checkTouch);
			if(!Gdx.input.isTouched()) {
				checkTouch= true;
			} else {
				checkTouch =false;
			}
			if (stageMenu.convert(Gdx.input.getX(), Gdx.input.getY())) {
				//check = true;
				//stageMenu.dispose();
				dispose();
				dem++;
				if (dem == 3) dem = 0;
			}

		}
		if(check) {
			stageScreens.get(dem).act(Gdx.graphics.getDeltaTime());
			stageScreens.get(dem).draw();
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
		//stageScreens.get(2).dispose();
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