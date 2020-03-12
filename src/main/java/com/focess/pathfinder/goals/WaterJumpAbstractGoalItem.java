package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class WaterJumpAbstractGoalItem extends NMSGoalItem {
    protected WaterJumpAbstractGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalWaterJumpAbstract", true), 0);
    }

    @Override
    public WaterJumpAbstractGoalItem clear() {
        return this;
    }
}