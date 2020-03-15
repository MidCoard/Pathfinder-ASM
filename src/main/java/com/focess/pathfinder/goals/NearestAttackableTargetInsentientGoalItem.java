package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.wrapped.WrappedEntityInsentient;
import org.bukkit.entity.EntityType;

public class NearestAttackableTargetInsentientGoalItem extends NMSGoalItem {

    protected NearestAttackableTargetInsentientGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalNearestAttackableTargetInsentient",true),2,NMSManager.getNMSClass("EntityInsentient",true),Class.class);
    }
    public NearestAttackableTargetInsentientGoalItem writeEntityInsentient(WrappedEntityInsentient arg) {
        this.write(0,arg);
        return this;
    }

    public NearestAttackableTargetInsentientGoalItem writeClass(Class<?> arg){
        this.write(0,arg);
        return this;
    }

    @Override
    public NearestAttackableTargetInsentientGoalItem clear() {
        return this;
    }

    public static class EntityClasses {
        public static Class<?> getEntityClass(EntityType type){
            return NMSManager.getNMSClass("Entity" + type.getEntityClass().getSimpleName());
        }
    }
}
