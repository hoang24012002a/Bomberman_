package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.entities.DynamicEntity.enemy.Balloon;
import com.mygdx.game.entities.StaticEntity.Bomb.Bomb;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;
import com.mygdx.game.entities.StaticEntity.Tile.Grass;
import com.mygdx.game.entities.StaticEntity.Tile.Wall;
import com.mygdx.game.map.StageScreen;


public class BombGame implements ApplicationListener {

	private Stage stage;
	private StageScreen stageScreen;
	private SpriteBatch batch;
	private BitmapFont font;
	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
        batch = new SpriteBatch();
		font = new BitmapFont();
		stageScreen = new StageScreen(2);
		//Bomber bomber = new Bomber(0, 0);
		Balloon balloon = new Balloon(200,200);
		Balloon balloon1 = new Balloon(250,200);
		Wall wall = new Wall(30,30);
		Brick brick = new Brick(0, 0);
		Grass grass = new Grass(80, 80);
//		SpeedItem speedItem = new SpeedItem(brick); // checked
		Bomb bomb = new Bomb(40, 40); // checked

//		flame.update();
		//group.addActor(bomb);
		//group.addActor(flame);
//		group.addActor(flameHorizontal);
//		stage.addActor(bomber);

//		stage.addActor(speedItem);
		//stage.addActor(brick);

		//stage.addActor(bomber);
		stage.addActor(balloon);
		stage.addActor(balloon1);
		stage.addActor(wall);
		stage.addActor(bomb);
		stage.addActor(grass);
		//stage.addActor(group);
//		stage.addActor(flame);
		// tại sao chỉ có 2 actor đc lên stage???

//		Bomber bomber = new Bomber(0, 0);
//		Balloon balloon = new Balloon(100, 200);
//		Bomber bomber1 = new Bomber(50, 50);
//		stage.addActor(balloon);
//		stage.addActor(bomber);
//		stage.addActor(bomber1);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stageScreen.draw();
		stage.act(Gdx.graphics.getDeltaTime());
		stageScreen.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		// 4 dòng dưới đây render chữ lên màn hình để test 1 số thứ chứ k có tác dụng gì
		batch.begin();
		font.draw(batch,String.valueOf(stageScreen.rows),100,300);
		font.draw(batch,String.valueOf(stageScreen.columns),200,300);
		batch.end();

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
	}
}
