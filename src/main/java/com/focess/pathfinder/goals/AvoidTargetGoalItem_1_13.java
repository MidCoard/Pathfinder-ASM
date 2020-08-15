package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.wrapped.WrappedEntityLiving;
import com.focess.pathfinder.wrapped.WrappedNMSPredicate;

import java.util.function.Predicate;

public class AvoidTargetGoalItem_1_13 extends NMSGoalItem {
    public static final WrappedNMSPredicate<WrappedEntityLiving> EXTRA_INCLUSION_SELECTOR = new WrappedNMSPredicate<WrappedEntityLiving>((t)-> true);
    public static final WrappedNMSPredicate<WrappedEntityLiving>  INCLUSION_SELECTOR = new WrappedNMSPredicate<WrappedEntityLiving>(new Predicate<WrappedEntityLiving>() {
        @Override
        public boolean test(WrappedEntityLiving wrappedEntityLiving) {
            try {
                return (boolean) Predicate.class.getDeclaredMethod("test", Object.class).invoke(NMSManager.ExceptCreativeOrSpectator,wrappedEntityLiving.toNMS());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    });
    private final PointerWriter doubleWriter = new PointerWriter(4, 2);

    protected AvoidTargetGoalItem_1_13() {
        super(NMSManager.getNMSClass("PathfinderGoalAvoidTarget", true), 7, NMSManager.getNMSClass("EntityCreature", true), Class.class, Predicate.class, float.class, double.class, double.class, Predicate.class);
    }

    public AvoidTargetGoalItem_1_13 writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public AvoidTargetGoalItem_1_13 writeClass(Class<?> arg) {
        this.write(1, arg);
        return this;
    }

    public AvoidTargetGoalItem_1_13 writePredicate0(WrappedNMSPredicate<WrappedEntityLiving> arg) {
        this.write(2, arg);
        return this;
    }

    public AvoidTargetGoalItem_1_13 writeFloat(float arg) {
        this.write(3, arg);
        return this;
    }

    public AvoidTargetGoalItem_1_13 writeDouble(double arg) {
        doubleWriter.write(arg);
        return this;
    }

    public AvoidTargetGoalItem_1_13 writePredicate1(WrappedNMSPredicate<com.focess.pathfinder.wrapped.WrappedEntityLiving> arg) {
        this.write(6, arg);
        return this;
    }

    @Override
    public AvoidTargetGoalItem_1_13 clear() {
        doubleWriter.clear();
        return this;
    }
}