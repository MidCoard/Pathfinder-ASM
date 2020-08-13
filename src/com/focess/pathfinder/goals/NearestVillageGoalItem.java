package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class NearestVillageGoalItem extends NMSGoalItem {
    protected NearestVillageGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalNearestVillage", true), 2, NMSManager.getNMSClass("EntityCreature", true), int.class);
    }

    public NearestVillageGoalItem writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public NearestVillageGoalItem writeInt(int arg) {
        this.write(1, arg);
        return this;
    }

    @Override
    public NearestVillageGoalItem clear() {
        return this;
    }
}