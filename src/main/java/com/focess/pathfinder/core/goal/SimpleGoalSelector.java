package com.focess.pathfinder.core.goal;

import com.focess.pathfinder.core.goal.util.NMSManager;
import com.focess.pathfinder.goal.GoalItem;
import com.focess.pathfinder.goal.GoalSelector;
import com.focess.pathfinder.goal.entity.FocessEntity;
import com.google.common.collect.Sets;

import java.util.Set;

public class SimpleGoalSelector implements GoalSelector {

    private final FocessEntity entity;

    public SimpleGoalSelector(FocessEntity focessEntity) {
        this.entity = focessEntity;

    }

    public Set<GoalItem> getGoalItems() {
        Set<GoalItem> items = Sets.newHashSet();
        if (NMSManager.isHighVersion()) {
            
        }
        else {

        }
        return items;
    }

    @Override
    public void removeExactGoal(GoalItem goalItem, Object object) {

    }

    @Override
    public void addGoal(Object object) {

    }

    @Override
    public boolean containsExactGoal(GoalItem goalItem, Object object) {
        return false;
    }

    @Override
    public Object getGoal(GoalItem goalItem) {
        return null;
    }

    private static class GoalItemInfo {
        private final GoalItem goalItem;
        private final Object goal;

        private GoalItemInfo(GoalItem goalItem, Object goal) {
            this.goalItem = goalItem;
            this.goal = goal;
        }
    }
}
