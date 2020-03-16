package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class OpenDoorGoalItem extends NMSGoalItem {
    protected OpenDoorGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalOpenDoor", true), 2, NMSManager.getNMSClass("EntityInsentient", true), boolean.class);
    }

    public OpenDoorGoalItem writeEntityInsentient(com.focess.pathfinder.wrapped.WrappedEntityInsentient arg) {
        this.write(0, arg);
        return this;
    }

    public OpenDoorGoalItem writeBoolean(boolean arg) {
        this.write(1, arg);
        return this;
    }

    @Override
    public OpenDoorGoalItem clear() {
        return this;
    }
}