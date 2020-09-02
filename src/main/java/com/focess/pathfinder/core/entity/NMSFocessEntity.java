package com.focess.pathfinder.core.entity;

import com.focess.pathfinder.core.goal.SimpleGoalSelector;
import com.focess.pathfinder.core.navigation.SimpleNavigationManager;
import com.focess.pathfinder.core.navigation.WrappedNavigation;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.entity.FocessEntity;
import com.focess.pathfinder.goal.GoalSelector;
import com.focess.pathfinder.navigation.Navigation;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

import java.util.Objects;
import java.util.Random;

public class NMSFocessEntity implements FocessEntity {
    private final SimpleNavigationManager navigation;
    private final Entity entity;
    private final GoalSelector goalSelector;
    private final int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NMSFocessEntity that = (NMSFocessEntity) o;
        return Objects.equals(entity, that.entity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entity);
    }

    private Random random;

    public NMSFocessEntity(Entity entity) {
        this.entity = entity;
        this.goalSelector = new SimpleGoalSelector(this);
        this.navigation = new SimpleNavigationManager(this);
        try {
            this.random = (Random) NMSManager.getField(NMSManager.getNMSClass("Entity"), "random").get(NMSManager.getNMSEntity(entity));
            this.id = NMSManager.getField(NMSManager.getNMSClass("Entity"), "id").getInt(NMSManager.getNMSEntity(entity));
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
    public SimpleNavigationManager getNavigationManager() {
        return this.navigation;
    }

    @Override
    public Random getRandom() {
        return this.random;
    }

    @Override
    public Location getLocation() {
        return this.getBukkitEntity().getLocation();
    }
}
