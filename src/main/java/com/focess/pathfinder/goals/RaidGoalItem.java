package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class RaidGoalItem extends NMSGoalItem {
    protected RaidGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalRaid", true), 1, NMSManager.getNMSClass("EntityRaider", true));
    }

    public RaidGoalItem writeEntityRaider(T arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public RaidGoalItem clear() {
        return this;
    }
}