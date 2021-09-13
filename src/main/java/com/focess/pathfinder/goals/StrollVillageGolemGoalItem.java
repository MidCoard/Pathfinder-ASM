package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.wrapped.WrappedEntityCreature;

public class StrollVillageGolemGoalItem extends NMSGoalItem {
    protected StrollVillageGolemGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalStrollVillageGolem", true), 2, NMSManager.getNMSClass("EntityCreature", true),double.class);
    }

    public StrollVillageGolemGoalItem writeEntityCreature(WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public StrollVillageGolemGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    @Override
    public NMSGoalItem clear() {
        return this;
    }
}
