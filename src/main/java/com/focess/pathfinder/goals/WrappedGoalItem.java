package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class WrappedGoalItem extends NMSGoalItem {
    protected WrappedGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalWrapped", true), 2, int.class, NMSManager.getNMSClass("PathfinderGoal", true));
    }

    public WrappedGoalItem writeInt(int arg) {
        this.write(0, arg);
        return this;
    }

    public WrappedGoalItem writePathfinderGoal(com.focess.pathfinder.wrapped.WrappedPathfinderGoal arg) {
        this.write(1, arg);
        return this;
    }

    @Override
    public WrappedGoalItem clear() {
        return this;
    }
}