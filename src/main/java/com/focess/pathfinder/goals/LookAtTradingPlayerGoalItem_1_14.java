package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class LookAtTradingPlayerGoalItem_1_14 extends NMSGoalItem {
    protected LookAtTradingPlayerGoalItem_1_14() {
        super(NMSManager.getNMSClass("PathfinderGoalLookAtTradingPlayer", true), 1, NMSManager.getNMSClass("EntityVillagerAbstract", true));
    }

    public LookAtTradingPlayerGoalItem_1_14 writeEntityVillagerAbstract(com.focess.pathfinder.wrapped.WrappedEntityVillagerAbstract arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public LookAtTradingPlayerGoalItem_1_14 clear() {
        return this;
    }
}