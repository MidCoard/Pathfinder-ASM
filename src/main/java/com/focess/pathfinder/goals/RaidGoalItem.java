package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.wrapped.WrappedEntityRaider;

public class RaidGoalItem extends NMSGoalItem {
    protected RaidGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalRaid", true), 1, NMSManager.getNMSClass("EntityRaider", true));
    }

    public RaidGoalItem writeEntityRaider(WrappedEntityRaider arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public RaidGoalItem clear() {
        return this;
    }
}