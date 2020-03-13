package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class GotoTargetGoalItem extends NMSGoalItem {
    private final PointerWriter intWriter = new PointerWriter(2, 2);

    protected GotoTargetGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalGotoTarget", true), 4, NMSManager.getNMSClass("EntityCreature", true), double.class, int.class, int.class);
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
        intWriter.write(arg);
        return this;
    }

    @Override
    public GotoTargetGoalItem clear() {
        intWriter.clear();
        return this;
    }
}