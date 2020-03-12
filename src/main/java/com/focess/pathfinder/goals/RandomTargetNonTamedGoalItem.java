package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class RandomTargetNonTamedGoalItem extends NMSGoalItem {
    protected RandomTargetNonTamedGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalRandomTargetNonTamed", true), 4, NMSManager.getNMSClass("EntityTameableAnimal", true), Class.class, boolean.class, java.util.function.Predicate.class);
    }

    public RandomTargetNonTamedGoalItem writeEntityTameableAnimal(com.focess.pathfinder.wrapped.WrappedEntityTameableAnimal arg) {
        this.write(0, arg);
        return this;
    }

    public RandomTargetNonTamedGoalItem writeClass(Class<T> arg) {
        this.write(1, arg);
        return this;
    }

    public RandomTargetNonTamedGoalItem writeBoolean(boolean arg) {
        this.write(2, arg);
        return this;
    }

    public RandomTargetNonTamedGoalItem writePredicate(java.util.function.Predicate<com.focess.pathfinder.wrapped.WrappedEntityLiving> arg) {
        this.write(3, arg);
        return this;
    }

    @Override
    public RandomTargetNonTamedGoalItem clear() {
        return this;
    }
}