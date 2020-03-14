package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class LookAtTradingPlayerGoalItem extends NMSGoalItem {
    protected LookAtTradingPlayerGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalLookAtTradingPlayer", true), 1, NMSManager.getNMSClass("EntityVillagerAbstract", true));
    }

    public LookAtTradingPlayerGoalItem writeEntityVillagerAbstract(com.focess.pathfinder.wrapped.WrappedEntityVillagerAbstract arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public LookAtTradingPlayerGoalItem clear() {
        return this;
    }
}