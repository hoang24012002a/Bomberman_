package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.entities.DynamicEntity.Bomber;
import com.mygdx.game.entities.StaticEntity.Item.SpeedItem;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;
import com.mygdx.game.entities.StaticEntity.Tile.Grass;
import com.mygdx.game.entities.StaticEntity.Tile.Wall;


public class Bomb implements ApplicationListener {

	private Stage stage;
	
	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);

		Bomber bomber = new Bomber(0, 0);
		Wall wall = new Wall(30,30);
		Brick brick = new Brick(60, 60);
		Grass grass = new Grass(100, 100);
		SpeedItem speedItem = new SpeedItem(brick); // checked
		Bomb bomb = new Bomb(40, 40);
		stage.addActor(bomber);
		stage.addActor(wall);
		stage.addActor(speedItem);
		stage.addActor(brick);
		stage.addActor(grass);
		stage.addActor(bomb);
		// tại sao chỉ có 2 actor đc lên stage???
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
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
	}
}
