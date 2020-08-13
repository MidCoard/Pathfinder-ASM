package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class FollowBoatGoalItem extends NMSGoalItem {
    protected FollowBoatGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalFollowBoat", true), 1, NMSManager.getNMSClass("EntityCreature", true));
    }

    public FollowBoatGoalItem writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public FollowBoatGoalItem clear() {
        return this;
    }
}