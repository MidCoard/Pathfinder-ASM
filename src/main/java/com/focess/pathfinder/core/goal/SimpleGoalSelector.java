package com.focess.pathfinder.core.goal;

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
        return items;
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
