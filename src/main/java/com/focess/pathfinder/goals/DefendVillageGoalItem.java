package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class DefendVillageGoalItem extends NMSGoalItem {
    protected DefendVillageGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalDefendVillage", true), 1, NMSManager.getNMSClass("EntityIronGolem", true));
    }

    public DefendVillageGoalItem writeEntityIronGolem(com.focess.pathfinder.wrapped.WrappedEntityIronGolem arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public DefendVillageGoalItem clear() {
        return this;
    }
}