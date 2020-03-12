package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class HurtByTargetGoalItem extends NMSGoalItem {
    protected HurtByTargetGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalHurtByTarget", true), 2, NMSManager.getNMSClass("EntityCreature", true), Class[].class);
    }

    public HurtByTargetGoalItem writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public HurtByTargetGoalItem writeClasss(Class<?>[] arg) {
        this.write(1, arg);
        return this;
    }

    @Override
    public HurtByTargetGoalItem clear() {
        return this;
    }
}