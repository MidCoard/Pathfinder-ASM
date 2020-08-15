package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class BreathGoalItem extends NMSGoalItem {
    protected BreathGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalBreath", true), 1, NMSManager.getNMSClass("EntityCreature", true));
    }

    public BreathGoalItem writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public BreathGoalItem clear() {
        return this;
    }
}