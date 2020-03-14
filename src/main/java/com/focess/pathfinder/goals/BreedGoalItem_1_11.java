package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class BreedGoalItem_1_11 extends NMSGoalItem {
    protected BreedGoalItem_1_11() {
        super(NMSManager.getNMSClass("PathfinderGoalBreed", true), 3, NMSManager.getNMSClass("EntityAnimal", true), double.class, Class.class);
    }

    public BreedGoalItem_1_11 writeEntityAnimal(com.focess.pathfinder.wrapped.WrappedEntityAnimal arg) {
        this.write(0, arg);
        return this;
    }

    public BreedGoalItem_1_11 writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public BreedGoalItem_1_11 writeClass(Class<?> arg) {
        this.write(2, arg);
        return this;
    }

    @Override
    public BreedGoalItem_1_11 clear() {
        return this;
    }
}