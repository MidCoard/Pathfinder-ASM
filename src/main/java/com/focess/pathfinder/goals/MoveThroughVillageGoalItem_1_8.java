package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class MoveThroughVillageGoalItem_1_8 extends NMSGoalItem {
    protected MoveThroughVillageGoalItem_1_8() {
        super(NMSManager.getNMSClass("PathfinderGoalMoveThroughVillage", true), 3, NMSManager.getNMSClass("EntityCreature", true), double.class, boolean.class);
    }

    public MoveThroughVillageGoalItem_1_8 writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public MoveThroughVillageGoalItem_1_8 writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public MoveThroughVillageGoalItem_1_8 writeBoolean(boolean arg) {
        this.write(2, arg);
        return this;
    }

    @Override
    public MoveThroughVillageGoalItem_1_8 clear() {
        return this;
    }
}