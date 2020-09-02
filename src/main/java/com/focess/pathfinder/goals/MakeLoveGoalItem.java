package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.wrapped.WrappedEntityVillager;

public class MakeLoveGoalItem extends NMSGoalItem {
    protected MakeLoveGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalMakeLove", true), 1, NMSManager.getNMSClass("EntityVillager", true));
    }

    public MakeLoveGoalItem writeEntityVillager(WrappedEntityVillager arg) {
        this.write(0, arg);
        return this;
    }

    @Override
    public MakeLoveGoalItem clear() {
        return this;
    }
}
