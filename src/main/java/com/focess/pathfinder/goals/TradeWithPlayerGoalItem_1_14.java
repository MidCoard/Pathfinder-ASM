package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class TradeWithPlayerGoalItem_1_14 extends NMSGoalItem {
    protected TradeWithPlayerGoalItem_1_14() {
        super(NMSManager.getNMSClass("PathfinderGoalTradeWithPlayer", true), 1, NMSManager.getNMSClass("EntityVillagerAbstract", true));
    }

    public TradeWithPlayerGoalItem_1_14 writeEntityVillagerAbstract(com.focess.pathfinder.wrapped.WrappedEntityVillagerAbstract arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public TradeWithPlayerGoalItem_1_14 clear() {
        return this;
    }
}