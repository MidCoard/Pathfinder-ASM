package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class BegGoalItem extends NMSGoalItem {
    protected BegGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalBeg", true), 2, NMSManager.getNMSClass("EntityWolf", true), float.class);
    }


    public BegGoalItem writeEntityWolf(com.focess.pathfinder.wrapped.WrappedEntityWolf arg) {
        this.write(0, arg);
        return this;
    }

    public BegGoalItem writeFloat(float arg) {
        this.write(1, arg);
        return this;
    }

    @Override
    public BegGoalItem clear() {
        return this;
    }
}