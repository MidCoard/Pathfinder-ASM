package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class TargetGoalItem extends NMSGoalItem {
    public static final boolean CHECK_NAVIGABLE = false;
    private final PointerWriter booleanWriter = new PointerWriter(1, 2);

    protected TargetGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalTarget", true), 3, NMSManager.getNMSClass("EntityInsentient", true), boolean.class, boolean.class);
    }

    public TargetGoalItem writeEntityInsentient(com.focess.pathfinder.wrapped.WrappedEntityInsentient arg) {
        this.write(0, arg);
        return this;
    }

    public TargetGoalItem writeBoolean(boolean arg) {
        booleanWriter.write(arg);
        return this;
    }

    @Override
    public TargetGoalItem clear() {
        booleanWriter.clear();
        return this;
    }
}