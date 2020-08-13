package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class SitGoalItem extends NMSGoalItem {
    protected SitGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalSit", true), 1, NMSManager.getNMSClass("EntityTameableAnimal", true));
    }

    public SitGoalItem writeEntityTameableAnimal(com.focess.pathfinder.wrapped.WrappedEntityTameableAnimal arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public SitGoalItem clear() {
        return this;
    }
}