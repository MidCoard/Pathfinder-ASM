package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class TradeWithPlayerGoalItem_1_8 extends NMSGoalItem {
    protected TradeWithPlayerGoalItem_1_8() {
        super(NMSManager.getNMSClass("PathfinderGoalTradeWithPlayer", true), 1, NMSManager.getNMSClass("EntityVillagerAbstract", true));
    }

    public TradeWithPlayerGoalItem_1_8 writeEntityVillager(com.focess.pathfinder.wrapped.WrappedEntityVillager arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public TradeWithPlayerGoalItem_1_8 clear() {
        return this;
    }
}