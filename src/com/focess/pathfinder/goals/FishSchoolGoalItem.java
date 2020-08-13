package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class FishSchoolGoalItem extends NMSGoalItem {
    protected FishSchoolGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalFishSchool", true), 1, NMSManager.getNMSClass("EntityFishSchool", true));
    }

    public FishSchoolGoalItem writeEntityFishSchool(com.focess.pathfinder.wrapped.WrappedEntityFishSchool arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public FishSchoolGoalItem clear() {
        return this;
    }
}