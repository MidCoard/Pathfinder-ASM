package com.focess.pathfinder.core.goal;

import com.focess.pathfinder.goal.Goal;
import net.minecraft.server.v1_13_R1.PathfinderGoal;

public class NMSGoal extends PathfinderGoal {

    private final Goal goal;

    public  NMSGoal(Goal goal) {
        this.goal = goal;
    }
    @Override
    public boolean a() {
        return goal.canStart();
    }
}
