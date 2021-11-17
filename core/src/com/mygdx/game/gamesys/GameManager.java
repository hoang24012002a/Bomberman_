package com.mygdx.game.entities.gamesys;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import javafx.util.Pair;

public class GameManager {
    // player.
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

}



