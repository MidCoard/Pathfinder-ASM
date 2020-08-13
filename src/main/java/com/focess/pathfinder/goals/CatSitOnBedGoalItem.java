package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class CatSitOnBedGoalItem extends NMSGoalItem {
    protected CatSitOnBedGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalCatSitOnBed", true), 3, NMSManager.getNMSClass("EntityCat", true), double.class, int.class);
    }

    public CatSitOnBedGoalItem writeEntityCat(com.focess.pathfinder.wrapped.WrappedEntityCat arg) {
        this.write(0, arg);
        return this;
    }

    public CatSitOnBedGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public CatSitOnBedGoalItem writeInt(int arg) {
        this.write(2, arg);
        return this;
    }

    @Override
    public CatSitOnBedGoalItem clear() {
        return this;
    }
}