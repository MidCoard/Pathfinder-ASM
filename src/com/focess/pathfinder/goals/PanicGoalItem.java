package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class PanicGoalItem extends NMSGoalItem {
    protected PanicGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalPanic", true), 2, NMSManager.getNMSClass("EntityCreature", true), double.class);
    }

    public PanicGoalItem writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public PanicGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    @Override
    public PanicGoalItem clear() {
        return this;
    }
}