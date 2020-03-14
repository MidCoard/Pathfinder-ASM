package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.wrapped.WrappedEntityLiving;
import com.focess.pathfinder.wrapped.WrappedNMSPredicate;

import java.util.function.Predicate;

public class AvoidTargetGoalItem extends NMSGoalItem {
    public static final WrappedNMSPredicate<WrappedEntityLiving> EXTRA_INCLUSION_SELECTOR = new WrappedNMSPredicate<WrappedEntityLiving>((t)-> true);

    private final PointerWriter doubleWriter = new PointerWriter(4, 2);

    protected AvoidTargetGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalAvoidTarget", true), 6, NMSManager.getNMSClass("EntityCreature", true), Class.class, Predicate.class, float.class, double.class, double.class);
    }

    public AvoidTargetGoalItem writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public AvoidTargetGoalItem writeClass(Class<?> arg) {
        this.write(1, arg);
        return this;
    }

    public AvoidTargetGoalItem writePredicate0(WrappedNMSPredicate<WrappedEntityLiving> arg) {
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

    @Override
    public AvoidTargetGoalItem clear() {
        doubleWriter.clear();
        return this;
    }
}