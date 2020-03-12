package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class MoveThroughVillageGoalItem extends NMSGoalItem {
    protected MoveThroughVillageGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalMoveThroughVillage", true), 5, NMSManager.getNMSClass("EntityCreature", true), double.class, boolean.class, int.class, java.util.function.BooleanSupplier.class);
    }

    public MoveThroughVillageGoalItem writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public MoveThroughVillageGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public MoveThroughVillageGoalItem writeBoolean(boolean arg) {
        this.write(2, arg);
        return this;
    }

    public MoveThroughVillageGoalItem writeInt(int arg) {
        this.write(3, arg);
        return this;
    }

    public MoveThroughVillageGoalItem writeBooleanSupplier(java.util.function.BooleanSupplier arg) {
        this.write(4, arg);
        return this;
    }

    @Override
    public MoveThroughVillageGoalItem clear() {
        return this;
    }
}