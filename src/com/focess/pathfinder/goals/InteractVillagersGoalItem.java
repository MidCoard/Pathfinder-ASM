package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class InteractVillagersGoalItem extends NMSGoalItem {

    protected InteractVillagersGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalInteract", true), 1, NMSManager.getNMSClass("EntityVillager", true));
    }

    public InteractVillagersGoalItem writeEntityInsentient(com.focess.pathfinder.wrapped.WrappedEntityVillager arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public InteractVillagersGoalItem clear() {
        return this;
    }
}