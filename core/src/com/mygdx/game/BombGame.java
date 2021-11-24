package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.entities.StaticEntity.Bomb.Bomb;


public class BombGame implements ApplicationListener {

	private Stage stage;
	
	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);
		Group group = new Group();
		Actor bom = new Bomb(40, 40);
		stage.addActor(group);
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
