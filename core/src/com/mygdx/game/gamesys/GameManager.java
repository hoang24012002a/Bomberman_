package com.mygdx.game.gamesys;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import javafx.util.Pair;

public class GameManager extends AssetManager {

    // wall
    public static final Texture wall = new Texture(Gdx.files.internal("img/wall/wall.png"));
//    public static final Texture wallPassGame = new Texture(Gdx.files.internal("img/wall/powerup_wallpass.png"));

    //brick
    public static final  Texture brick = new Texture(Gdx.files.internal("img/brick/brick.png"));
    public static final TextureAtlas brickExploded = new TextureAtlas(Gdx.files.internal("img/brick/brickexploded.atlas"));
    public static final Animation brickExp = new Animation(1/3.f, brickExploded.getRegions());

    //grass
    public static final Texture grass = new Texture(Gdx.files.internal("img/grass/grass.png"));

    // bombItem
    public static final Texture bombItem = new Texture(Gdx.files.internal("img/item/powerup_bombs.png"));
    // speedItem
    public static final Texture speedItem = new Texture(Gdx.files.internal("img/item/powerup_speed.png"));
    // flameItem
    public static final Texture flameItem = new Texture(Gdx.files.internal("img/item/powerup_flames.png"));
    // portalItem
    public static final Texture portalItem = new Texture(Gdx.files.internal("img/item/portal.png"));

    // bombFlick
    private static final TextureAtlas bombFLick = new TextureAtlas(Gdx.files.internal("img/bomb/bombflick/bombflick.atlas"));
    //    public static final Animation bombFlicker = new Animation(1/3.f, bombFLick.getRegions());
    public static final Pair<TextureAtlas, Animation> bombFlick = new Pair<>(bombFLick, new Animation(1/3.f, bombFLick.getRegions()));


    // bombExplode
    public static final TextureAtlas bombExploded = new TextureAtlas(Gdx.files.internal("img/bomb/bombexploded/bombexp.atlas"));
    public static final Animation bombExp= new Animation(1/3.f, bombExploded.getRegions());

    //flame1
    public static final TextureAtlas flameEpxloded1 = new TextureAtlas(Gdx.files.internal("img/flame/flame1/flame1.atlas"));
    // flame2
    public static final TextureAtlas flameExploded2 = new TextureAtlas(Gdx.files.internal("img/flame/flame2/flame2.atlas"));
    // flame3
    public static final TextureAtlas flameExploded3 = new TextureAtlas(Gdx.files.internal("img/flame/flame3/flame3.atlas"));
    // flame horizontal
    public static final Animation flameHorizontal = new Animation(1/3.f, flameEpxloded1.findRegion("explosion_horizontal"), flameExploded2.findRegion("explosion_horizontal1"), flameExploded3.findRegion("explosion_horizontal2"));
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
    private static final TextureAtlas playerDead = new TextureAtlas(Gdx.files.internal("img/player/dead/dead.atlas"));
    public static final Pair<TextureAtlas, Animation> playerDeadDynamic = new Pair<TextureAtlas, Animation>(playerDead,
            new Animation(1/1.0f, playerDead.getRegions()));

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
    private static final TextureAtlas balloonDead = new TextureAtlas(Gdx.files.internal("img/enemy/balloon/dead/dead.atlas"));
    public static final Pair<TextureAtlas, Animation> balloonDeadDynamic = new Pair<TextureAtlas, Animation>(balloonDead,
            new Animation(1/1.25f, balloonDead.getRegions()));

    private static final TextureAtlas balloonLeft = new TextureAtlas(Gdx.files.internal("img/enemy/balloon/left/left.atlas"));
    public static final Pair<TextureAtlas, Animation> balloonLeftDynamic = new Pair<TextureAtlas, Animation>(balloonLeft,
            new Animation(1/6.f, balloonLeft.getRegions()));

    private static final TextureAtlas balloonRight = new TextureAtlas(Gdx.files.internal("img/enemy/balloon/right/right.atlas"));
    public static final Pair<TextureAtlas, Animation> balloonRightDynamic = new Pair<TextureAtlas, Animation>(balloonRight,
            new Animation(1/6.f, balloonRight.getRegions()));

    //doll.
    private static final TextureAtlas dollDead = new TextureAtlas(Gdx.files.internal("img/enemy/doll/dead/dead.atlas"));
    public static final Pair<TextureAtlas, Animation> dollDeadDynamic = new Pair<TextureAtlas, Animation>(dollDead,
            new Animation(1/1.25f, dollDead.getRegions()));

    private static final TextureAtlas dollLeft = new TextureAtlas(Gdx.files.internal("img/enemy/doll/left/left.atlas"));
    public static final Pair<TextureAtlas, Animation> dollLeftDynamic = new Pair<TextureAtlas, Animation>(dollLeft,
            new Animation(1/6.f, dollLeft.getRegions()));

    private static final TextureAtlas dollRight = new TextureAtlas(Gdx.files.internal("img/enemy/doll/right/right.atlas"));
    public static final Pair<TextureAtlas, Animation> dollRightDynamic = new Pair<TextureAtlas, Animation>(dollRight,
            new Animation(1/6.f, dollRight.getRegions()));

    //kondoria.
    private static final TextureAtlas kondoriaDead = new TextureAtlas(Gdx.files.internal("img/enemy/kondoria/dead/dead.atlas"));
    public static final Pair<TextureAtlas, Animation> kondoriaDeadDynamic = new Pair<TextureAtlas, Animation>(kondoriaDead,
            new Animation(1/1.25f, kondoriaDead.getRegions()));

    private static final TextureAtlas kondoriaLeft = new TextureAtlas(Gdx.files.internal("img/enemy/kondoria/left/left.atlas"));
    public static final Pair<TextureAtlas, Animation> kondoriaLeftDynamic = new Pair<TextureAtlas, Animation>(kondoriaLeft,
            new Animation(1/6.f, kondoriaLeft.getRegions()));

    private static final TextureAtlas kondoriaRight = new TextureAtlas(Gdx.files.internal("img/enemy/kondoria/right/right.atlas"));
    public static final Pair<TextureAtlas, Animation> kondoriaRightDynamic = new Pair<TextureAtlas, Animation>(kondoriaRight,
            new Animation(1/6.f, kondoriaRight.getRegions()));

    //minvo.
    private static final TextureAtlas minvoDead = new TextureAtlas(Gdx.files.internal("img/enemy/minvo/dead/dead.atlas"));
    public static final Pair<TextureAtlas, Animation> minvoDeadDynamic = new Pair<TextureAtlas, Animation>(minvoDead,
            new Animation(1/1.25f, minvoDead.getRegions()));

    private static final TextureAtlas minvoLeft = new TextureAtlas(Gdx.files.internal("img/enemy/minvo/left/left.atlas"));
    public static final Pair<TextureAtlas, Animation> minvoLeftDynamic = new Pair<TextureAtlas, Animation>(minvoLeft,
            new Animation(1/6.f, minvoLeft.getRegions()));

    private static final TextureAtlas minvoRight = new TextureAtlas(Gdx.files.internal("img/enemy/minvo/right/right.atlas"));
    public static final Pair<TextureAtlas, Animation> minvoRightDynamic = new Pair<TextureAtlas, Animation>(minvoRight,
            new Animation(1/6.f, minvoRight.getRegions()));

    //oneal.
    private static final TextureAtlas onealDead = new TextureAtlas(Gdx.files.internal("img/enemy/oneal/dead/dead.atlas"));
    public static final Pair<TextureAtlas, Animation> onealDeadDynamic = new Pair<TextureAtlas, Animation>(onealDead,
            new Animation(1/1.25f, onealDead.getRegions()));

    private static final TextureAtlas onealLeft = new TextureAtlas(Gdx.files.internal("img/enemy/oneal/left/left.atlas"));
    public static final Pair<TextureAtlas, Animation> onealLeftDynamic = new Pair<TextureAtlas, Animation>(onealLeft,
            new Animation(1/6.f, onealLeft.getRegions()));

    private static final TextureAtlas onealRight = new TextureAtlas(Gdx.files.internal("img/enemy/oneal/right/right.atlas"));
    public static final Pair<TextureAtlas, Animation> onealRightDynamic = new Pair<TextureAtlas, Animation>(onealRight,
            new Animation(1/6.f, onealRight.getRegions()));
    // sound
    public static final Sound playerDeadSound = Gdx.audio.newSound(Gdx.files.internal("sounds/Die.ogg"));

    public static final Sound dollDeadSound = Gdx.audio.newSound(Gdx.files.internal("sounds/EnemyDie.ogg"));

    public static final Sound balloonDeadSound = Gdx.audio.newSound(Gdx.files.internal("sounds/EnemyDie1.ogg"));

    public static final Sound onealDeadSound = Gdx.audio.newSound(Gdx.files.internal("sounds/EnemyDie2.ogg"));

    public static final Sound placeBombSound = Gdx.audio.newSound(Gdx.files.internal("sounds/PlaceBomb.ogg"));

    public static final Sound eatItemSound = Gdx.audio.newSound(Gdx.files.internal("sounds/Powerup.ogg"));

    public static final Sound bombExplodedSound = Gdx.audio.newSound(Gdx.files.internal("sounds/Explosion.ogg"));

    public static final Sound portalAppearSound = Gdx.audio.newSound(Gdx.files.internal("sounds/PortalAppears.ogg"));

    public static final Sound telePortSound = Gdx.audio.newSound(Gdx.files.internal("sounds/Teleport.ogg"));

    public static final Sound kickBombSound = Gdx.audio.newSound(Gdx.files.internal("sounds/KickBomb.ogg"));

    public static final Sound oopsSound = Gdx.audio.newSound(Gdx.files.internal("music/Oops.ogg"));

    public static final Sound gameOverSound = Gdx.audio.newSound(Gdx.files.internal("music/GameOver.ogg"));

    public static final Sound victorySound = Gdx.audio.newSound(Gdx.files.internal("music/Victory.ogg"));

    public static final Sound stageClearSound = Gdx.audio.newSound(Gdx.files.internal("music/StageCleared.ogg"));

    public static final Sound backGroundMap1Sound = Gdx.audio.newSound(Gdx.files.internal("music/SuperBomberman-Area1.ogg"));

    public static final Sound backGroundMap2Sound = Gdx.audio.newSound(Gdx.files.internal("music/SuperBomberman-Area2.ogg"));

    public static final Sound backGroundMap3Sound = Gdx.audio.newSound(Gdx.files.internal("music/SuperBomberman-Boss.ogg"));

    public static final Sound pauseSound = Gdx.audio.newSound(Gdx.files.internal("sounds/Pause.ogg"));

    public static final Sound powerUpSound = Gdx.audio.newSound(Gdx.files.internal("sounds/Powerup.ogg"));

    // Lever Cartoon
    public static final Texture Lv1 = new Texture(Gdx.files.internal("cartoon/lv1.png"));
    public static final Texture Lv2 = new Texture(Gdx.files.internal("cartoon/lv2.png"));
    public static final Texture Lv3 = new Texture(Gdx.files.internal("cartoon/lv3.png"));
}

