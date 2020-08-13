package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class GotoTargetGoalItem extends NMSGoalItem {

    protected GotoTargetGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalGotoTarget", true), 3, NMSManager.getNMSClass("EntityCreature", true), double.class, int.class);
    }

    public GotoTargetGoalItem writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public GotoTargetGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public GotoTargetGoalItem writeInt(int arg) {
        this.write(2,arg);
        return this;
    }

    @Override
    public GotoTargetGoalItem clear() {
        return this;
    }
}