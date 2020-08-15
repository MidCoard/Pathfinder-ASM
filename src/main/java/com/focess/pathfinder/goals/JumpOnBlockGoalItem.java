package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class JumpOnBlockGoalItem extends NMSGoalItem {
    protected JumpOnBlockGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalJumpOnBlock", true), 2, NMSManager.getNMSClass("EntityCat", true), double.class);
    }

    public JumpOnBlockGoalItem writeEntityCat(com.focess.pathfinder.wrapped.WrappedEntityCat arg) {
        this.write(0, arg);
        return this;
    }

    public JumpOnBlockGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    @Override
    public JumpOnBlockGoalItem clear() {
        return this;
    }
}