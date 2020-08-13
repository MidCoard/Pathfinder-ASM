package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class RestrictSunGoalItem extends NMSGoalItem {
    protected RestrictSunGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalRestrictSun", true), 1, NMSManager.getNMSClass("EntityCreature", true));
    }

    public RestrictSunGoalItem writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public RestrictSunGoalItem clear() {
        return this;
    }
}