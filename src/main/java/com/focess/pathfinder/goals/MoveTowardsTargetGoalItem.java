package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class MoveTowardsTargetGoalItem extends NMSGoalItem {
    protected MoveTowardsTargetGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalMoveTowardsTarget", true), 3, NMSManager.getNMSClass("EntityCreature", true), double.class, float.class);
    }

    public MoveTowardsTargetGoalItem writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public MoveTowardsTargetGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public MoveTowardsTargetGoalItem writeFloat(float arg) {
        this.write(2, arg);
        return this;
    }

    @Override
    public MoveTowardsTargetGoalItem clear() {
        return this;
    }
}