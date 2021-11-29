package com.mygdx.game.entities.DynamicEntity.enemy.AI;

import com.mygdx.game.entities.DynamicEntity.enemy.Enemy;

import java.util.ArrayList;
import java.util.List;

public class AI_Low extends AI {
    private Enemy enemy;

    public AI_Low(Enemy enemy) {
        super();
        this.enemy = enemy;
    }

    @Override
    public int calDir() {
        List<Integer> listDir = new ArrayList<>();
        if (enemy.canMoveLeft()) listDir.add(0);
        if (enemy.canMoveTop()) listDir.add(1);
        if (enemy.canMoveRight()) listDir.add(2);
        if (enemy.canMoveBottom()) listDir.add(3);
        int index = (int) (Math.random() * listDir.size());
        return listDir.get(index);
    }
}
