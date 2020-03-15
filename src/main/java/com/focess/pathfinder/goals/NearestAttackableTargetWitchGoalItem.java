package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.EntityType;

import java.util.function.Predicate;

public class NearestAttackableTargetWitchGoalItem extends NMSGoalItem {
    private final PointerWriter booleanWriter = new PointerWriter(3, 2);

    protected NearestAttackableTargetWitchGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalNearestAttackableTargetWitch", true), 6, NMSManager.getNMSClass("EntityRaider", true), Class.class, int.class, boolean.class, boolean.class, Predicate.class);
    }

    public NearestAttackableTargetWitchGoalItem writeEntityRaider(com.focess.pathfinder.wrapped.WrappedEntityRaider arg) {
        this.write(0, arg);
        return this;
    }

    public NearestAttackableTargetWitchGoalItem writeClass(Class<?> arg) {
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

    public NearestAttackableTargetWitchGoalItem writePredicate(Predicate<com.focess.pathfinder.wrapped.WrappedEntityLiving> arg) {
        this.write(5, arg);
        return this;
    }

    @Override
    public NearestAttackableTargetWitchGoalItem clear() {
        booleanWriter.clear();
        return this;
    }
    public static class EntityClasses {
        public static Class<?> getEntityClass(EntityType type){
            return NMSManager.getNMSClass("Entity" + type.getEntityClass().getSimpleName());
        }
    }
}