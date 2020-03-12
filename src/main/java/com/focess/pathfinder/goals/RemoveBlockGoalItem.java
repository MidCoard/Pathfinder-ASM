package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class RemoveBlockGoalItem extends NMSGoalItem {
    protected RemoveBlockGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalRemoveBlock", true), 4, NMSManager.getNMSClass("Block", true), NMSManager.getNMSClass("EntityCreature", true), double.class, int.class);
    }

    public RemoveBlockGoalItem writeBlock(com.focess.pathfinder.wrapped.WrappedBlock arg) {
        this.write(0, arg);
        return this;
    }

    public RemoveBlockGoalItem writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(1, arg);
        return this;
    }

    public RemoveBlockGoalItem writeDouble(double arg) {
        this.write(2, arg);
        return this;
    }

    public RemoveBlockGoalItem writeInt(int arg) {
        this.write(3, arg);
        return this;
    }

    @Override
    public RemoveBlockGoalItem clear() {
        return this;
    }
}