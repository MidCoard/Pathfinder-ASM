package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class RandomStrollLandGoalItem extends NMSGoalItem {
    public static final float PROBABILIITY = 0.001f;
    protected RandomStrollLandGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalRandomStrollLand", true), 3, NMSManager.getNMSClass("EntityCreature", true), double.class, float.class);
    }

    public RandomStrollLandGoalItem writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public RandomStrollLandGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public RandomStrollLandGoalItem writeFloat(float arg) {
        this.write(2, arg);
        return this;
    }

    @Override
    public RandomStrollLandGoalItem clear() {
        return this;
    }
}