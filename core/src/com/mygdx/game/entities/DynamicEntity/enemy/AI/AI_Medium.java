package com.mygdx.game.entities.DynamicEntity.enemy.AI;

import com.mygdx.game.entities.DynamicEntity.Bomber;
import com.mygdx.game.entities.DynamicEntity.enemy.Enemy;

import java.util.ArrayList;

public class AI_Medium extends AI {
    private Bomber bomber;
    private Enemy enemy;

    public AI_Medium(Enemy enemy) {
        this.enemy = enemy;
        bomber = Bomber.bomber;
    }

    @Override
    public int calDir() {
        ArrayList<Integer> dir = new ArrayList<>();
        if (enemy.canMoveBottom()) dir.add(3);
        if (enemy.canMoveLeft()) dir.add(0);
        if (enemy.canMoveRight()) dir.add(2);
        if (enemy.canMoveTop()) dir.add(1);
        double distance = Float.MAX_VALUE;
        int min = 0;
        for (int i = 0; i < dir.size(); i++) {
            if (dir.get(i) == 0) {
                double temp = Math.sqrt((enemy.getX() - 32 - bomber.getX()) * (enemy.getX() - 32 - bomber.getX())
                        + (enemy.getY() - bomber.getY()) * (enemy.getY() - bomber.getY()));
                if (temp < distance) {
                    distance = temp;
                    min = i;
                }
            } else if (dir.get(i) == 2) {
                double temp = Math.sqrt((enemy.getX() + 32 - bomber.getX()) * (enemy.getX() + 32 - bomber.getX())
                        + (enemy.getY() - bomber.getY()) * (enemy.getY() - bomber.getY()));
                if (temp < distance) {
                    distance = temp;
                    min = i;
                }
            } else if (dir.get(i) == 1) {
                double temp = Math.sqrt((enemy.getX() - bomber.getX()) * (enemy.getX() - bomber.getX())
                        + (enemy.getY() + 32 - bomber.getY()) * (enemy.getY() + 32 - bomber.getY()));
                if (temp < distance) {
                    distance = temp;
                    min = i;
                }
            } else {
                double temp = Math.sqrt((enemy.getX() - bomber.getX()) * (enemy.getX() - bomber.getX())
                        + (enemy.getY() - 32 - bomber.getY()) * (enemy.getY() - 32 - bomber.getY()));
                if (temp < distance) {
                    distance = temp;
                    min = i;
                }
            }
        }
        return dir.get(min);
    }
}
