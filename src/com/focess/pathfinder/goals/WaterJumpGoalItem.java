package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class WaterJumpGoalItem extends NMSGoalItem {
    protected WaterJumpGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalWaterJump", true), 2, NMSManager.getNMSClass("EntityDolphin", true), int.class);
    }

    public WaterJumpGoalItem writeEntityDolphin(com.focess.pathfinder.wrapped.WrappedEntityDolphin arg) {
        this.write(0, arg);
        return this;
    }

    public WaterJumpGoalItem writeInt(int arg) {
        this.write(1, arg);
        return this;
    }

    @Override
    public WaterJumpGoalItem clear() {
        return this;
    }
}