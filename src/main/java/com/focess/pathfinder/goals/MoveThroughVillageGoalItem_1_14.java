package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

import java.util.function.BooleanSupplier;

public class MoveThroughVillageGoalItem_1_14 extends NMSGoalItem {
    protected MoveThroughVillageGoalItem_1_14() {
        super(NMSManager.getNMSClass("PathfinderGoalMoveThroughVillage", true), 5, NMSManager.getNMSClass("EntityCreature", true), double.class, boolean.class, int.class, BooleanSupplier.class);
    }

    public MoveThroughVillageGoalItem_1_14 writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public MoveThroughVillageGoalItem_1_14 writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public MoveThroughVillageGoalItem_1_14 writeBoolean(boolean arg) {
        this.write(2, arg);
        return this;
    }

    public MoveThroughVillageGoalItem_1_14 writeInt(int arg) {
        this.write(3, arg);
        return this;
    }

    public MoveThroughVillageGoalItem_1_14 writeBooleanSupplier(BooleanSupplier arg) {
        this.write(4, arg);
        return this;
    }

    @Override
    public MoveThroughVillageGoalItem_1_14 clear() {
        return this;
    }
}