package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class FleeSunGoalItem extends NMSGoalItem {
    protected FleeSunGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalFleeSun", true), 2, NMSManager.getNMSClass("EntityCreature", true), double.class);
    }

    public FleeSunGoalItem writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public FleeSunGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    @Override
    public FleeSunGoalItem clear() {
        return this;
    }
}