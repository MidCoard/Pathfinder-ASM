package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class HurtByTargetGoalItem_1_8 extends NMSGoalItem {
    protected HurtByTargetGoalItem_1_8() {
        super(NMSManager.getNMSClass("PathfinderGoalHurtByTarget", true), 3, NMSManager.getNMSClass("EntityCreature", true),boolean.class, Class[].class);
    }

    public HurtByTargetGoalItem_1_8 writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public HurtByTargetGoalItem_1_8 writeBoolean(boolean arg) {
        this.write(1,arg);
        return this;
    }

    public HurtByTargetGoalItem_1_8 writeClasses(Class<?>... arg) {
        this.write(2, arg);
        return this;
    }

    @Override
    public HurtByTargetGoalItem_1_8 clear() {
        return this;
    }
}