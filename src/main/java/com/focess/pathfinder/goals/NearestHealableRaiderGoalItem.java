package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.wrapped.WrappedEntityLiving;
import com.focess.pathfinder.wrapped.WrappedNMSPredicate;
import org.bukkit.entity.EntityType;

import java.util.function.Predicate;

public class NearestHealableRaiderGoalItem extends NMSGoalItem {
    protected NearestHealableRaiderGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalNearestHealableRaider", true), 4, NMSManager.getNMSClass("EntityRaider", true), Class.class, boolean.class, Predicate.class);
    }

    public NearestHealableRaiderGoalItem writeEntityRaider(com.focess.pathfinder.wrapped.WrappedEntityRaider arg) {
        this.write(0, arg);
        return this;
    }

    public NearestHealableRaiderGoalItem writeClass(Class<?> arg) {
        this.write(1, arg);
        return this;
    }

    public NearestHealableRaiderGoalItem writeBoolean(boolean arg) {
        this.write(2, arg);
        return this;
    }

    public NearestHealableRaiderGoalItem writePredicate(WrappedNMSPredicate<WrappedEntityLiving> arg) {
        this.write(3, arg);
        return this;
    }

    @Override
    public NearestHealableRaiderGoalItem clear() {
        return this;
    }
    public static class EntityClasses {
        public static Class<?> getEntityClass(EntityType type){
            return NMSManager.getNMSClass("Entity" + type.getEntityClass().getSimpleName());
        }
    }
}