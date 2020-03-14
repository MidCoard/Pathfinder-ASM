package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class OwnerHurtByTargetGoalItem extends NMSGoalItem {
    protected OwnerHurtByTargetGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalOwnerHurtByTarget", true), 1, NMSManager.getNMSClass("EntityTameableAnimal", true));
    }

    public OwnerHurtByTargetGoalItem writeEntityTameableAnimal(com.focess.pathfinder.wrapped.WrappedEntityTameableAnimal arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public OwnerHurtByTargetGoalItem clear() {
        return this;
    }
}