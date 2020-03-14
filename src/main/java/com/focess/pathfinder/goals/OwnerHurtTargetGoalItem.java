package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class OwnerHurtTargetGoalItem extends NMSGoalItem {
    protected OwnerHurtTargetGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalOwnerHurtTarget", true), 1, NMSManager.getNMSClass("EntityTameableAnimal", true));
    }

    public OwnerHurtTargetGoalItem writeEntityTameableAnimal(com.focess.pathfinder.wrapped.WrappedEntityTameableAnimal arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public OwnerHurtTargetGoalItem clear() {
        return this;
    }
}