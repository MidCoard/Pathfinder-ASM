package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class HorseTrapGoalItem extends NMSGoalItem {
    protected HorseTrapGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalHorseTrap", true), 1, NMSManager.getNMSClass("EntityHorseSkeleton", true));
    }

    public HorseTrapGoalItem writeEntityHorseSkeleton(com.focess.pathfinder.wrapped.WrappedEntityHorseSkeleton arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public HorseTrapGoalItem clear() {
        return this;
    }
}