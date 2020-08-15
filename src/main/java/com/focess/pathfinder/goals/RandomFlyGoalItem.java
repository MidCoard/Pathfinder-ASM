package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class RandomFlyGoalItem extends NMSGoalItem {
    protected RandomFlyGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalRandomFly", true), 2, NMSManager.getNMSClass("EntityCreature", true), double.class);
    }

    public RandomFlyGoalItem writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public RandomFlyGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    @Override
    public RandomFlyGoalItem clear() {
        return this;
    }
}