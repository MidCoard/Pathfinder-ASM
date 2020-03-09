package com.focess.pathfinder.goal.entity;

import com.focess.pathfinder.goal.GoalSelector;
import org.bukkit.entity.Entity;

public class FocessEntity {

    private final Entity entity;
    private final GoalSelector goalSelector;

    protected FocessEntity(Entity entity) {
        this.entity = entity;
        this.goalSelector = new GoalSelector(this);
    }

    public GoalSelector getGoalSelector() {
        return this.goalSelector;
    }
}