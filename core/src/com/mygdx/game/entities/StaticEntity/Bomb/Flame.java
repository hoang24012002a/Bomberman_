package com.mygdx.game.entities.StaticEntity.Bomb;

import com.mygdx.game.entities.AnimatedEntity;
import com.mygdx.game.gamesys.GameManager;

public class Flame extends AnimatedEntity {
    public Flame(float x, float y){
        super(x, y);
        this.animation= GameManager.flameHorLeftLast;
    }
    // đang tìm cách để tạo hình cho flame
    // kéo dài flame dựa vào FlameItem
}
