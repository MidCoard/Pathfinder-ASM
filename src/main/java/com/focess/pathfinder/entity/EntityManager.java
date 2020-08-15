package com.focess.pathfinder.entity;

import com.focess.pathfinder.core.entity.NMSFocessEntity;
import org.bukkit.entity.Entity;

public class EntityManager {

    public static NMSFocessEntity getFocessEntity(Entity entity) {
        return new NMSFocessEntity(entity);
    }

    public static void registerEntity(Class<? extends IFocessEntity> entity,String name) {

    }
}
