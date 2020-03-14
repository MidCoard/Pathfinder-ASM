package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class BreedGoalItem extends NMSGoalItem {
    protected BreedGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalBreed", true), 2, NMSManager.getNMSClass("EntityAnimal", true), double.class);
    }

    public BreedGoalItem writeEntityAnimal(com.focess.pathfinder.wrapped.WrappedEntityAnimal arg) {
        this.write(0, arg);
        return this;
    }

    public BreedGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    @Override
    public BreedGoalItem clear() {
        return this;
    }
}