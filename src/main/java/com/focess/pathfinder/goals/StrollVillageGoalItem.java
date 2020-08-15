package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class StrollVillageGoalItem extends NMSGoalItem {
    protected StrollVillageGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalStrollVillage", true), 2, NMSManager.getNMSClass("EntityCreature", true), double.class);
    }

    public StrollVillageGoalItem writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public StrollVillageGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    @Override
    public StrollVillageGoalItem clear() {
        return this;
    }
}