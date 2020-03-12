package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class DoorInteractGoalItem extends NMSGoalItem {
    protected DoorInteractGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalDoorInteract", true), 1, NMSManager.getNMSClass("EntityInsentient", true));
    }

    public DoorInteractGoalItem writeEntityInsentient(com.focess.pathfinder.wrapped.WrappedEntityInsentient arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public DoorInteractGoalItem clear() {
        return this;
    }
}