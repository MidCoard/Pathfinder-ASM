package com.focess.pathfinder.entity;

import com.focess.pathfinder.core.entity.NMSFocessEntity;
import com.focess.pathfinder.goal.FocessGoalItem;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.bukkit.entity.Entity;

import java.util.List;
import java.util.Map;

public class EntityManager {

    private static Map<Entity,FocessEntity> entities = Maps.newHashMap();

    public static void register(Entity entity, FocessEntity focessEntity) {
        entities.put(entity,focessEntity);
    }

    public static FocessEntity getFocessEntity(Entity entity) {
        return entities.get(entity);
    }

    public static void registerEntity(Class<? extends FocessEntity> entity, String name) {

    }

    public static List<FocessEntity> getAllFocessEntities() {
        return Lists.newArrayList(entities.values());
    }
}
