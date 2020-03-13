package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

import java.util.function.Predicate;

public class NearestHealableRaiderGoalItem extends NMSGoalItem {
    protected NearestHealableRaiderGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalNearestHealableRaider", true), 4, NMSManager.getNMSClass("EntityRaider", true), Class.class, boolean.class, Predicate.class);
    }

    public NearestHealableRaiderGoalItem writeEntityRaider(com.focess.pathfinder.wrapped.WrappedEntityRaider arg) {
        this.write(0, arg);
        return this;
    }

    public NearestHealableRaiderGoalItem writeClass(Class<T> arg) {
        this.write(1, arg);
        return this;
    }

    public NearestHealableRaiderGoalItem writeBoolean(boolean arg) {
        this.write(2, arg);
        return this;
    }

    public NearestHealableRaiderGoalItem writePredicate(Predicate<com.focess.pathfinder.wrapped.WrappedEntityLiving> arg) {
        this.write(3, arg);
        return this;
    }

    @Override
    public NearestHealableRaiderGoalItem clear() {
        return this;
    }
}