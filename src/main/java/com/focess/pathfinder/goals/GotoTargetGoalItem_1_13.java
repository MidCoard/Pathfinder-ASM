package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class GotoTargetGoalItem_1_13 extends NMSGoalItem {
    public static final int MAX_Y_DIFFERENCE = 1;
    private final PointerWriter intWriter = new PointerWriter(2, 2);

    protected GotoTargetGoalItem_1_13() {
        super(NMSManager.getNMSClass("PathfinderGoalGotoTarget", true), 4, NMSManager.getNMSClass("EntityCreature", true), double.class, int.class, int.class);
    }

    public GotoTargetGoalItem_1_13 writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public GotoTargetGoalItem_1_13 writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public GotoTargetGoalItem_1_13 writeInt(int arg) {
        intWriter.write(arg);
        return this;
    }

    @Override
    public GotoTargetGoalItem_1_13 clear() {
        intWriter.clear();
        return this;
    }
}