package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class DoorOpenGoalItem extends NMSGoalItem {
    protected DoorOpenGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalDoorOpen", true), 2, NMSManager.getNMSClass("EntityInsentient", true), boolean.class);
    }

    public DoorOpenGoalItem writeEntityInsentient(com.focess.pathfinder.wrapped.WrappedEntityInsentient arg) {
        this.write(0, arg);
        return this;
    }

    public DoorOpenGoalItem writeBoolean(boolean arg) {
        this.write(1, arg);
        return this;
    }

    @Override
    public DoorOpenGoalItem clear() {
        return this;
    }
}