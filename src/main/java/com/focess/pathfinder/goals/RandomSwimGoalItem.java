package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class RandomSwimGoalItem extends NMSGoalItem {
    protected RandomSwimGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalRandomSwim", true), 3, NMSManager.getNMSClass("EntityCreature", true), double.class, int.class);
    }

    public RandomSwimGoalItem writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public RandomSwimGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public RandomSwimGoalItem writeInt(int arg) {
        this.write(2, arg);
        return this;
    }

    @Override
    public RandomSwimGoalItem clear() {
        return this;
    }
}