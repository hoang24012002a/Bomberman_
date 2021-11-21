package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.map.StageScreen;


public class Bomb implements ApplicationListener {

	private Stage stage;
	private Stage stage1;
	private StageScreen stageScreen;
	private Group group;
	@Override
	public void create () {

		stage = new Stage();
		//new ScreenViewport()
		stage1 = new Stage();
		stageScreen = new StageScreen();
		//Gdx.input.setInputProcessor(stage);

		/*Bomber bomber = new Bomber(35, 335);
        Balloon balloon = new Balloon(0, 300);*/
		group = new Group();
		group.addActor(stageScreen.bomber);
		for(int i = 0; i < stageScreen.balloons.size(); i++) {
			group.addActor(stageScreen.balloons.get(i));
		}
		stage.addActor(group);

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stageScreen.draw();
		stage.draw();
		stage.act(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose () {
		stageScreen.dispose();
		//stage.dispose();
	}

}
