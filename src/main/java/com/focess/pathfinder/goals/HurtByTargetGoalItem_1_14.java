package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class HurtByTargetGoalItem_1_14 extends NMSGoalItem {
    protected HurtByTargetGoalItem_1_14() {
        super(NMSManager.getNMSClass("PathfinderGoalHurtByTarget", true), 2, NMSManager.getNMSClass("EntityCreature", true), Class[].class);
    }

    public HurtByTargetGoalItem_1_14 writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public HurtByTargetGoalItem_1_14 writeClasses(Class<?>... arg) {
        this.write(1, arg);
        return this;
    }

    @Override
    public HurtByTargetGoalItem_1_14 clear() {
        return this;
    }
}