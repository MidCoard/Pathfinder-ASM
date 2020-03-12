package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class NearestAttackableTargetWitchGoalItem extends NMSGoalItem {
    private PointerWriter booleanWriter = new PointerWriter(3, 2);

    protected NearestAttackableTargetWitchGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalNearestAttackableTargetWitch", true), 6, NMSManager.getNMSClass("EntityRaider", true), Class.class, int.class, boolean.class, boolean.class, java.util.function.Predicate.class);
    }

    public NearestAttackableTargetWitchGoalItem writeEntityRaider(com.focess.pathfinder.wrapped.WrappedEntityRaider arg) {
        this.write(0, arg);
        return this;
    }

    public NearestAttackableTargetWitchGoalItem writeClass(Class<T> arg) {
        this.write(1, arg);
        return this;
    }

    public NearestAttackableTargetWitchGoalItem writeInt(int arg) {
        this.write(2, arg);
        return this;
    }

    public NearestAttackableTargetWitchGoalItem writeBoolean(boolean arg) {
        booleanWriter.write(arg);
        return this;
    }

    public NearestAttackableTargetWitchGoalItem writePredicate(java.util.function.Predicate<com.focess.pathfinder.wrapped.WrappedEntityLiving> arg) {
        this.write(5, arg);
        return this;
    }

    @Override
    public NearestAttackableTargetWitchGoalItem clear() {
        booleanWriter.clear();
        return this;
    }
}