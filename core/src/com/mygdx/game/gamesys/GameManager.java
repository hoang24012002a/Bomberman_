package com.mygdx.game.gamesys;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import javafx.util.Pair;

public class GameManager extends AssetManager {

    // player.
    /*
    private static final TextureAtlas playerUp = new TextureAtlas(Gdx.files.internal("player/up/up.atlas"));
    public static final Pair<TextureAtlas, Animation> playerUpDynamic = new Pair<TextureAtlas, Animation>(playerUp,
            new Animation(1/3.f, playerUp.getRegions()));
    public static final Pair<TextureAtlas, Animation> playerUpStatic = new Pair<TextureAtlas, Animation>(playerUp,
            new Animation(1/3.f, playerUp.getRegions().get(0)));

    private static final TextureAtlas playerDown = new TextureAtlas(Gdx.files.internal("player/down/down.atlas"));
    public static final Pair<TextureAtlas, Animation> playerDownDynamic = new Pair<TextureAtlas, Animation>(playerDown,
            new Animation(1/3.f, playerDown.getRegions()));
    public static final Pair<TextureAtlas, Animation> playerDownStatic = new Pair<TextureAtlas, Animation>(playerDown,
            new Animation(1/3.f, playerDown.getRegions().get(0)));

    private static final TextureAtlas playerRight = new TextureAtlas(Gdx.files.internal("player/right/right.atlas"));
    public static final Pair<TextureAtlas, Animation> playerRightDynamic = new Pair<TextureAtlas, Animation>(playerRight,
            new Animation(1/3.f, playerRight.getRegions()));
    public static final Pair<TextureAtlas, Animation> playerRightStatic = new Pair<TextureAtlas, Animation>(playerRight,
            new Animation(1/3.f, playerRight.getRegions().get(0)));

    private static final TextureAtlas playerLeft = new TextureAtlas(Gdx.files.internal("player/left/left.atlas"));
    public static final Pair<TextureAtlas, Animation> playerLeftDynamic = new Pair<TextureAtlas, Animation>(playerLeft,
            new Animation(1/3.f, playerLeft.getRegions()));
    public static final Pair<TextureAtlas, Animation> playerLeftStatic = new Pair<TextureAtlas, Animation>(playerLeft,
            new Animation(1/3.f, playerLeft.getRegions().get(0)));
     */

    // wall
    public static final Texture wall = new Texture(Gdx.files.internal("wall/wall.png"));
    public static final Texture wallPassGame = new Texture(Gdx.files.internal("wall/powerup_wallpass.png"));

    //brick
    public static final  Texture brick = new Texture(Gdx.files.internal("brick/brick.png"));
    public static final TextureAtlas brickExploded = new TextureAtlas(Gdx.files.internal("brick/brickexploded.atlas"));
    public static final Animation brickExp = new Animation(1/3.f, brickExploded.getRegions());

    //grass
    public static final Texture grass = new Texture(Gdx.files.internal("grass/grass.png"));

    // bombItem
    public static final Texture bombItem = new Texture(Gdx.files.internal("item/powerup_bombs.png"));
    // speedItem
    public static final Texture speedItem = new Texture(Gdx.files.internal("item/powerup_speed.png"));
    // flameItem
    public static final Texture flameItem = new Texture(Gdx.files.internal("item/powerup_flames.png"));
    // portalItem
    public static final Texture portalItem = new Texture(Gdx.files.internal("item/portal.png"));

    // bombFlick
    public static final TextureAtlas bombFLick = new TextureAtlas(Gdx.files.internal("bomb/bombflick/bomb.atlas"));
    public static final Animation bombFlicker = new Animation(1/3.f, bombFLick.getRegions().get(0));

    // bombExplode
    private static final TextureAtlas bombExploded = new TextureAtlas(Gdx.files.internal("bomb/bombexploded/bombexp.atlas"));
    public static final Animation bombExp= new Animation(1/3.f, bombExploded.getRegions());

    //flame1
    public static final TextureAtlas flameEpxloded1 = new TextureAtlas(Gdx.files.internal("flame/flame1/flame1.atlas"));
    // flame2
    public static final TextureAtlas flameExploded2 = new TextureAtlas(Gdx.files.internal("flame/flame2/flame2.atlas"));
    // flame3
    public static final TextureAtlas flameExploded3 = new TextureAtlas(Gdx.files.internal("flame/flame3/flame3.atlas"));
    // flame horizontal
    public static final Animation flameHorizontal = new Animation(1/3.f, flameEpxloded1.findRegion("explosion_horizontal"), flameExploded2.findRegion("explosion_horizontal1"), flameExploded3.findRegion("explosion_horizontal1"));
    // flame vertical
    public static final Animation flameVertical = new Animation(1/3.f, flameEpxloded1.findRegion("explosion_vertical"), flameExploded2.findRegion("explosion_vertical1"), flameExploded3.findRegion("explosion_vertical2"));
    // flame horizon left last
    public static final Animation flameHorLeftLast = new Animation(1/3.f, flameEpxloded1.findRegion("explosion_horizontal_left_last"), flameExploded2.findRegion("explosion_horizontal_left_last1"), flameExploded3.findRegion("explosion_horizontal_left_last2"));
    // flame horizon right last
    public static final Animation flameHorRightLast = new Animation(1/3.f, flameEpxloded1.findRegion("explosion_horizontal_right_last"), flameExploded2.findRegion("explosion_horizontal_right_last1"), flameExploded3.findRegion("explosion_horizontal_right_last2"));
    // flame vertical down last
    public static final Animation flameVerDownLast = new Animation(1/3.f, flameEpxloded1.findRegion("explosion_vertical_down_last"), flameExploded2.findRegion("explosion_vertical_down_last1"), flameExploded3.findRegion("explosion_vertical_down_last2"));
    // flame vertical top last
    public static final Animation flameVerTopLast = new Animation(1/3.f, flameEpxloded1.findRegion("explosion_vertical_top_last"), flameExploded2.findRegion("explosion_vertical_top_last1"), flameExploded3.findRegion("explosion_vertical_top_last2"));

    /**
     * player.
     */
    private static final TextureAtlas playerUp = new TextureAtlas(Gdx.files.internal("img/player/up/up.atlas"));
    public static final Pair<TextureAtlas, Animation> playerUpDynamic = new Pair<TextureAtlas, Animation>(playerUp,
            new Animation(1/6.f, playerUp.getRegions()));
    public static final Pair<TextureAtlas, Animation> playerUpStatic = new Pair<TextureAtlas, Animation>(playerUp,
            new Animation(1/6.f, playerUp.getRegions().get(0)));

    private static final TextureAtlas playerDown = new TextureAtlas(Gdx.files.internal("img/player/down/down.atlas"));
    public static final Pair<TextureAtlas, Animation> playerDownDynamic = new Pair<TextureAtlas, Animation>(playerDown,
            new Animation(1/6.f, playerDown.getRegions()));
    public static final Pair<TextureAtlas, Animation> playerDownStatic = new Pair<TextureAtlas, Animation>(playerDown,
            new Animation(1/6.f, playerDown.getRegions().get(0)));

    private static final TextureAtlas playerRight = new TextureAtlas(Gdx.files.internal("img/player/right/right.atlas"));
    public static final Pair<TextureAtlas, Animation> playerRightDynamic = new Pair<TextureAtlas, Animation>(playerRight,
            new Animation(1/6.f, playerRight.getRegions()));
    public static final Pair<TextureAtlas, Animation> playerRightStatic = new Pair<TextureAtlas, Animation>(playerRight,
            new Animation(1/6.f, playerRight.getRegions().get(0)));

    private static final TextureAtlas playerLeft = new TextureAtlas(Gdx.files.internal("img/player/left/left.atlas"));
    public static final Pair<TextureAtlas, Animation> playerLeftDynamic = new Pair<TextureAtlas, Animation>(playerLeft,
            new Animation(1/6.f, playerLeft.getRegions()));
    public static final Pair<TextureAtlas, Animation> playerLeftStatic = new Pair<TextureAtlas, Animation>(playerLeft,
            new Animation(1/6.f, playerLeft.getRegions().get(0)));

    /**
     * enemy.
     */
    //balloon.
    private static final TextureAtlas balloonLeft = new TextureAtlas(Gdx.files.internal("img/enemy/balloon/left/left.atlas"));
    public static final Pair<TextureAtlas, Animation> balloonLeftDynamic = new Pair<TextureAtlas, Animation>(balloonLeft,
            new Animation(1/6.f, balloonLeft.getRegions()));

    private static final TextureAtlas balloonRight = new TextureAtlas(Gdx.files.internal("img/enemy/balloon/right/right.atlas"));
    public static final Pair<TextureAtlas, Animation> balloonRightDynamic = new Pair<TextureAtlas, Animation>(balloonRight,
            new Animation(1/6.f, balloonRight.getRegions()));

}



