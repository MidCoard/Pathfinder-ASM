package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class FollowParentGoalItem extends NMSGoalItem {
    protected FollowParentGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalFollowParent", true), 2, NMSManager.getNMSClass("EntityAnimal", true), double.class);
    }

    public FollowParentGoalItem writeEntityAnimal(com.focess.pathfinder.wrapped.WrappedEntityAnimal arg) {
        this.write(0, arg);
        return this;
    }

    public FollowParentGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    @Override
    public FollowParentGoalItem clear() {
        return this;
    }
}