package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class LeapAtTargetGoalItem extends NMSGoalItem {
    protected LeapAtTargetGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalLeapAtTarget", true), 2, NMSManager.getNMSClass("EntityInsentient", true), float.class);
    }

    public LeapAtTargetGoalItem writeEntityInsentient(com.focess.pathfinder.wrapped.WrappedEntityInsentient arg) {
        this.write(0, arg);
        return this;
    }

    public LeapAtTargetGoalItem writeFloat(float arg) {
        this.write(1, arg);
        return this;
    }

    @Override
    public LeapAtTargetGoalItem clear() {
        return this;
    }
}