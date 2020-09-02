package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class RandomStrollGoalItem extends NMSGoalItem {

    public static final int CHANCE = 120;

    protected RandomStrollGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalRandomStroll", true), 3, NMSManager.getNMSClass("EntityCreature", true), double.class, int.class);
    }

    public RandomStrollGoalItem writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public RandomStrollGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public RandomStrollGoalItem writeInt(int arg) {
        this.write(2, arg);
        return this;
    }

    @Override
    public RandomStrollGoalItem clear() {
        return this;
    }
}