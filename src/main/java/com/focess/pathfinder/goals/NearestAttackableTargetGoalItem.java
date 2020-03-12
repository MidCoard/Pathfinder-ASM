package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class NearestAttackableTargetGoalItem extends NMSGoalItem {
    private PointerWriter booleanWriter = new PointerWriter(3, 2);

    protected NearestAttackableTargetGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalNearestAttackableTarget", true), 6, NMSManager.getNMSClass("EntityInsentient", true), Class.class, int.class, boolean.class, boolean.class, java.util.function.Predicate.class);
    }

    public NearestAttackableTargetGoalItem writeEntityInsentient(com.focess.pathfinder.wrapped.WrappedEntityInsentient arg) {
        this.write(0, arg);
        return this;
    }

    public NearestAttackableTargetGoalItem writeClass(Class<T> arg) {
        this.write(1, arg);
        return this;
    }

    public NearestAttackableTargetGoalItem writeInt(int arg) {
        this.write(2, arg);
        return this;
    }

    public NearestAttackableTargetGoalItem writeBoolean(boolean arg) {
        booleanWriter.write(arg);
        return this;
    }

    public NearestAttackableTargetGoalItem writePredicate(java.util.function.Predicate<com.focess.pathfinder.wrapped.WrappedEntityLiving> arg) {
        this.write(5, arg);
        return this;
    }

    @Override
    public NearestAttackableTargetGoalItem clear() {
        booleanWriter.clear();
        return this;
    }
}