package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class HorseTrapGoalItem_1_11 extends NMSGoalItem {
    protected HorseTrapGoalItem_1_11() {
        super(NMSManager.getNMSClass("PathfinderGoalHorseTrap", true), 1, NMSManager.getNMSClass("EntityHorseSkeleton", true));
    }

    public HorseTrapGoalItem_1_11 writeEntityHorseSkeleton(com.focess.pathfinder.wrapped.WrappedEntityHorseSkeleton arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public HorseTrapGoalItem_1_11 clear() {
        return this;
    }
}