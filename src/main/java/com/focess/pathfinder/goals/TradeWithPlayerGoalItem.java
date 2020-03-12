package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class TradeWithPlayerGoalItem extends NMSGoalItem {
    protected TradeWithPlayerGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalTradeWithPlayer", true), 1, NMSManager.getNMSClass("EntityVillagerAbstract", true));
    }

    public TradeWithPlayerGoalItem writeEntityVillagerAbstract(com.focess.pathfinder.wrapped.WrappedEntityVillagerAbstract arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public TradeWithPlayerGoalItem clear() {
        return this;
    }
}