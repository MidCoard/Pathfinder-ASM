package com.focess.pathfinder.goal;

import com.focess.pathfinder.goal.entity.FocessEntity;
import com.google.common.collect.Sets;

import java.util.Set;

public interface GoalSelector {

    Set<GoalItem> getGoalItems();

}
