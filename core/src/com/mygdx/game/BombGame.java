package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.entities.DynamicEntity.Bomber;
import com.mygdx.game.entities.DynamicEntity.enemy.Balloon;
import com.mygdx.game.entities.StaticEntity.Bomb.Bomb;
import com.mygdx.game.entities.StaticEntity.Bomb.Flame;
import com.mygdx.game.entities.StaticEntity.Item.BombItem;
import com.mygdx.game.entities.StaticEntity.Item.SpeedItem;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;
import com.mygdx.game.entities.StaticEntity.Tile.Grass;
import com.mygdx.game.entities.StaticEntity.Tile.Wall;


public class BombGame implements ApplicationListener {

	private Stage stage;
	
	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);

		Actor bomber = new Bomber(50, 50);
		Actor balloon = new Balloon(120, 120);
		Actor balloon1 = new Balloon(150, 150);
		Actor balloon2 = new Balloon(140, 120);
		Actor brick = new Brick(10, 20);
		Actor grass = new Grass(50, 50);
		Actor wall = new Wall(100, 100);
		stage.addActor(bomber);
		stage.addActor(wall);
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
