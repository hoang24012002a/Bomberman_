package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.entities.DynamicEntity.Bomber;
import com.mygdx.game.entities.DynamicEntity.enemy.Balloon;
import com.mygdx.game.entities.StaticEntity.Bomb.Bomb;
import com.mygdx.game.entities.StaticEntity.Bomb.Flame;
import com.mygdx.game.entities.StaticEntity.Bomb.FlameManager;
import com.mygdx.game.entities.StaticEntity.Item.BombItem;
import com.mygdx.game.entities.StaticEntity.Tile.Brick;


public class BombGame implements ApplicationListener {

	private Stage stage;
	
	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);
		Group group = new Group();
		Actor bom = new Bomber(10, 10);
		Actor bomb = new Bomb(200, 200);
		BombItem bomItem = new BombItem(90, 90);
		Actor brick = new Brick(150, 150, true);
		Actor bl = new Balloon(90, 90);
    	Actor flame = new Flame(stage.getWidth()-50, stage.getHeight()-50);
//		 no group is ok
//		FlameManager flames = new FlameManager((Flame) flame);
		FlameManager flameManager = new FlameManager(stage.getWidth()/2-16, stage.getHeight()/2-16);
		System.out.println(flameManager.sizeFla());
		for (int i = 0; i < flameManager.sizeFla(); i++){
			stage.addActor(flameManager.getFlames().get(i));
		}
		stage.addActor(bomItem);
		bomItem.eatItem((Bomber) bom);
		stage.addActor(brick);
		stage.addActor(bom);
		stage.addActor(bomb);
//		stage.addActor(new Grass(50, 50));
//		stage.addActor(flameManager.getFlames().get(0));
//		stage.addActor(flameManager.getFlames().get(4));
//		stage.addActor(flame);
//			stage.addActor(group);
//		stage.getActors().removeValue(flameManager.getFlames().get(0), true);
//		stage.addActor(bl);
		System.out.println(stage.getActors().size);
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
