package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class AvoidTargetGoalItem extends NMSGoalItem {
    private PointerWriter doubleWriter = new PointerWriter(4, 2);

    protected AvoidTargetGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalAvoidTarget", true), 7, NMSManager.getNMSClass("EntityCreature", true), Class.class, java.util.function.Predicate.class, float.class, double.class, double.class, java.util.function.Predicate.class);
    }

    public AvoidTargetGoalItem writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public AvoidTargetGoalItem writeClass(Class<T> arg) {
        this.write(1, arg);
        return this;
    }

    public AvoidTargetGoalItem writePredicate0(java.util.function.Predicate<com.focess.pathfinder.wrapped.WrappedEntityLiving> arg) {
        this.write(2, arg);
        return this;
    }

    public AvoidTargetGoalItem writeFloat(float arg) {
        this.write(3, arg);
        return this;
    }

    public AvoidTargetGoalItem writeDouble(double arg) {
        doubleWriter.write(arg);
        return this;
    }

    public AvoidTargetGoalItem writePredicate1(java.util.function.Predicate<com.focess.pathfinder.wrapped.WrappedEntityLiving> arg) {
        this.write(6, arg);
        return this;
    }

    @Override
    public AvoidTargetGoalItem clear() {
        doubleWriter.clear();
        return this;
    }
}