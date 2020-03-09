package com.focess.pathfinder.goal.entity;

import org.bukkit.entity.Entity;

public class EntityManager {

    public static FocessEntity getFocessEntity(Entity entity) {
        return new FocessEntity(entity);
    }

    public static void registerEntity(Class<? extends FocessEntity> entity,String name) {

    }
}
