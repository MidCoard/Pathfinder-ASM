package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

import java.util.function.Predicate;

public class BreakDoorGoalItem_1_14 extends NMSGoalItem {

    public static final int MAX_PROGRESS = -1;
    protected BreakDoorGoalItem_1_14() {
        super(NMSManager.getNMSClass("PathfinderGoalBreakDoor", true), 3, NMSManager.getNMSClass("EntityInsentient", true), int.class, Predicate.class);
    }

    public BreakDoorGoalItem_1_14 writeEntityInsentient(com.focess.pathfinder.wrapped.WrappedEntityInsentient arg) {
        this.write(0, arg);
        return this;
    }

    public BreakDoorGoalItem_1_14 writeInt(int arg) {
        this.write(1, arg);
        return this;
    }

    public BreakDoorGoalItem_1_14 writePredicate(Predicate<com.focess.pathfinder.wrapped.WrappedEnumDifficulty> arg) {
        this.write(2, arg);
        return this;
    }

    @Override
    public BreakDoorGoalItem_1_14 clear() {
        return this;
    }
}