package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class WaterGoalItem extends NMSGoalItem {
    protected WaterGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalWater", true), 1, NMSManager.getNMSClass("EntityCreature", true));
    }

    public WaterGoalItem writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public WaterGoalItem clear() {
        return this;
    }
}