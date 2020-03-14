package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class TameGoalItem extends NMSGoalItem {
    protected TameGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalTame", true), 2, NMSManager.getNMSClass("EntityHorseAbstract", true), double.class);
    }

    public TameGoalItem writeEntityHorseAbstract(com.focess.pathfinder.wrapped.WrappedEntityHorseAbstract arg) {
        this.write(0, arg);
        return this;
    }

    public TameGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    @Override
    public TameGoalItem clear() {
        return this;
    }
}