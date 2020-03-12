package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class MoveTowardsRestrictionGoalItem extends NMSGoalItem {
    protected MoveTowardsRestrictionGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalMoveTowardsRestriction", true), 2, NMSManager.getNMSClass("EntityCreature", true), double.class);
    }

    public MoveTowardsRestrictionGoalItem writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public MoveTowardsRestrictionGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    @Override
    public MoveTowardsRestrictionGoalItem clear() {
        return this;
    }
}