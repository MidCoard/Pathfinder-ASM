package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class FloatGoalItem extends NMSGoalItem {
    protected FloatGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalFloat", true), 1, NMSManager.getNMSClass("EntityInsentient", true));
    }

    public FloatGoalItem writeEntityInsentient(com.focess.pathfinder.wrapped.WrappedEntityInsentient arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public FloatGoalItem clear() {
        return this;
    }
}