package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class LookAtTradingPlayerGoalItem_1_8 extends NMSGoalItem {
    protected LookAtTradingPlayerGoalItem_1_8() {
        super(NMSManager.getNMSClass("PathfinderGoalLookAtTradingPlayer", true), 1, NMSManager.getNMSClass("EntityVillager", true));
    }

    public LookAtTradingPlayerGoalItem_1_8 writeEntityVillagerAbstract(com.focess.pathfinder.wrapped.WrappedEntityVillager arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public LookAtTradingPlayerGoalItem_1_8 clear() {
        return this;
    }
}