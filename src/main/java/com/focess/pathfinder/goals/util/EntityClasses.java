package com.focess.pathfinder.goals.util;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.EntityType;

public class EntityClasses {
    public static Class<?> getEntityClass(EntityType type){
        return NMSManager.getNMSClass("Entity" + type.getEntityClass().getSimpleName());
    }
}
