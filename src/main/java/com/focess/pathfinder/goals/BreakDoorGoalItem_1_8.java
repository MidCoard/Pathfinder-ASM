package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class BreakDoorGoalItem_1_8 extends NMSGoalItem {
    protected BreakDoorGoalItem_1_8() {
        super(NMSManager.getNMSClass("PathfinderGoalBreakDoor", true), 1, NMSManager.getNMSClass("EntityInsentient", true));
    }

    public BreakDoorGoalItem_1_8 writeEntityInsentient(com.focess.pathfinder.wrapped.WrappedEntityInsentient arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public BreakDoorGoalItem_1_8 clear() {
        return this;
    }
}