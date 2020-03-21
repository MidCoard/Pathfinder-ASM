package com.focess.pathfinder.example;

import com.focess.pathfinder.goal.Goal;
import org.bukkit.entity.Sheep;

public class SpiderNetGoal extends Goal {

    private final Sheep sheep;

    public SpiderNetGoal(Sheep sheep) {
        this.sheep = sheep;
        this.addControl(Control.MOVE);
        this.addControl(Control.JUMP);
        this.addControl(Control.LOOK);
    }

    @Override
    public boolean canStart() {
        return sheep.isOnGround();
    }

    @Override
    public void start() {
        throw new NullPointerException();
    }
}
