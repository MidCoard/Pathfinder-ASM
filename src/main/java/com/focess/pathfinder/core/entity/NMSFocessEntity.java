package com.focess.pathfinder.core.entity;

import com.focess.pathfinder.core.goal.SimpleGoalSelector;
import com.focess.pathfinder.goal.GoalSelector;
import com.focess.pathfinder.entity.FocessEntity;
import org.bukkit.entity.Entity;

public class NMSFocessEntity implements FocessEntity {


    private final Entity entity;
    private final GoalSelector goalSelector;

    public NMSFocessEntity(Entity entity) {
        this.entity = entity;
        this.goalSelector = new SimpleGoalSelector(this);
    }
    @Override
    public GoalSelector getGoalSelector() {
        return this.goalSelector;
    }

    @Override
    public Entity getBukkitEntity() {
        return this.entity;
    }
}
