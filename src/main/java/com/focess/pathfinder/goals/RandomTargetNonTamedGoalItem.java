package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.wrapped.WrappedEntityLiving;
import com.focess.pathfinder.wrapped.WrappedNMSPredicate;
import org.bukkit.entity.EntityType;

import java.util.function.Predicate;

public class RandomTargetNonTamedGoalItem extends NMSGoalItem {
    protected RandomTargetNonTamedGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalRandomTargetNonTamed", true), 4, NMSManager.getNMSClass("EntityTameableAnimal", true), Class.class, boolean.class, Predicate.class);
    }

    public RandomTargetNonTamedGoalItem writeEntityTameableAnimal(com.focess.pathfinder.wrapped.WrappedEntityTameableAnimal arg) {
        this.write(0, arg);
        return this;
    }

    public RandomTargetNonTamedGoalItem writeClass(Class<?> arg) {
        this.write(1, arg);
        return this;
    }

    public RandomTargetNonTamedGoalItem writeBoolean(boolean arg) {
        this.write(2, arg);
        return this;
    }

    public RandomTargetNonTamedGoalItem writePredicate(WrappedNMSPredicate<WrappedEntityLiving> arg) {
        this.write(3, arg);
        return this;
    }

    @Override
    public RandomTargetNonTamedGoalItem clear() {
        return this;
    }

    public static class EntityClasses {
        public static Class<?> getEntityClass(EntityType type){
            return NMSManager.getNMSClass("Entity" + type.getEntityClass().getSimpleName());
        }
    }
}