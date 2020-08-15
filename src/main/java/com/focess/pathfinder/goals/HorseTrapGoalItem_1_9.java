package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class HorseTrapGoalItem_1_9 extends NMSGoalItem {
    protected HorseTrapGoalItem_1_9() {
        super(NMSManager.getNMSClass("PathfinderGoalHorseTrap", true), 1, NMSManager.getNMSClass("EntityHorse", true));
    }

    public HorseTrapGoalItem_1_9 writeEntityHorseSkeleton(com.focess.pathfinder.wrapped.WrappedEntityHorse arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public HorseTrapGoalItem_1_9 clear() {
        return this;
    }
}