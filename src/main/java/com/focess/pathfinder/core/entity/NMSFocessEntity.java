package com.focess.pathfinder.core.entity;

import com.focess.pathfinder.core.goal.SimpleGoalSelector;
import com.focess.pathfinder.core.navigation.SimpleNavigation;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.entity.FocessEntity;
import com.focess.pathfinder.goal.GoalSelector;
import com.focess.pathfinder.navigation.Navigation;
import org.bukkit.entity.Entity;

import java.util.Random;

public class NMSFocessEntity implements FocessEntity {
    private final Navigation navigation;
    private final Entity entity;
    private final GoalSelector goalSelector;
    private final int id;
    private Random random;

    public NMSFocessEntity(Entity entity) {
        this.entity = entity;
        this.goalSelector = new SimpleGoalSelector(this);
        this.navigation = new SimpleNavigation(this);
        try {
            this.random = (Random) NMSManager.getField(NMSManager.getNMSClass("Entity"), "random").get(NMSManager.getNMSEntity(entity));
            this.id = NMSManager.getField(NMSManager.getNMSClass("Entity"),"id").getInt(NMSManager.getNMSEntity(entity));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public GoalSelector getGoalSelector() {
        return this.goalSelector;
    }

    @Override
    public Entity getBukkitEntity() {
        return this.entity;
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public Navigation getNavigationManager() {
        return this.navigation;
    }

    @Override
    public Random getRandom() {
        return this.random;
    }
}
