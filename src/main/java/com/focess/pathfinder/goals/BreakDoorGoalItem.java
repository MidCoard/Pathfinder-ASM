package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class BreakDoorGoalItem extends NMSGoalItem {
    protected BreakDoorGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalBreakDoor", true), 3, NMSManager.getNMSClass("EntityInsentient", true), int.class, java.util.function.Predicate.class);
    }

    public BreakDoorGoalItem writeEntityInsentient(com.focess.pathfinder.wrapped.WrappedEntityInsentient arg) {
        this.write(0, arg);
        return this;
    }

    public BreakDoorGoalItem writeInt(int arg) {
        this.write(1, arg);
        return this;
    }

    public BreakDoorGoalItem writePredicate(java.util.function.Predicate<com.focess.pathfinder.wrapped.WrappedEnumDifficulty> arg) {
        this.write(2, arg);
        return this;
    }

    @Override
    public BreakDoorGoalItem clear() {
        return this;
    }
}