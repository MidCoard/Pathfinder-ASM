package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class RandomLookaroundGoalItem extends NMSGoalItem {
    protected RandomLookaroundGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalRandomLookaround", true), 1, NMSManager.getNMSClass("EntityInsentient", true));
    }

    public RandomLookaroundGoalItem writeEntityInsentient(com.focess.pathfinder.wrapped.WrappedEntityInsentient arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public RandomLookaroundGoalItem clear() {
        return this;
    }
}