package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class PerchGoalItem extends NMSGoalItem {
    protected PerchGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalPerch", true), 1, NMSManager.getNMSClass("EntityPerchable", true));
    }

    public PerchGoalItem writeEntityPerchable(com.focess.pathfinder.wrapped.WrappedEntityPerchable arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public PerchGoalItem clear() {
        return this;
    }
}