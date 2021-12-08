package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.map.*;

public class BombGame implements ApplicationListener {
	private StagePlay stagePlay;

	private boolean check = true;
	private boolean checkTouch =true;
	private MyInputProcessor myInputProcessor;
	@Override
	public void create () {
		myInputProcessor = new MyInputProcessor();
		stagePlay = new StagePlay();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//stageInfomation.draw();
		stagePlay.draw();
		stagePlay.act(Gdx.graphics.getDeltaTime());
		if (stagePlay.exit) {
			System.out.println("exit in BombGame");
			dispose();
		}


	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose () {

		stagePlay.dispose();
	}

}