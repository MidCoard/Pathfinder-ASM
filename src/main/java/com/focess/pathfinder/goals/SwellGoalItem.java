package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class SwellGoalItem extends NMSGoalItem {
    protected SwellGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalSwell", true), 1, NMSManager.getNMSClass("EntityCreeper", true));
    }

    public SwellGoalItem writeEntityCreeper(com.focess.pathfinder.wrapped.WrappedEntityCreeper arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public SwellGoalItem clear() {
        return this;
    }
}