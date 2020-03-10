package com.focess.pathfinder.goal;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.goal.util.NMSManager;
import com.focess.pathfinder.goals.ArrowAttackGoalItem;
import com.google.common.collect.Sets;

import java.util.Set;

public class Goals {

    protected static Set<GoalItem> goalItems = Sets.newHashSet();

    public static NMSGoalItem getNMSGoalItem(Class<?> clz) {
        for (GoalItem goalItem:goalItems)
            if (goalItem.getGoalClass().equals(clz))
                return (NMSGoalItem) goalItem;
        return null;
    }

    public static class MOVE {
        public static final ArrowAttackGoalItem ArrowAttack = new ArrowAttackGoalItem();
    }

    public static class LOOK {

    }

    public static class JUMP {

    }

    public static class TARGET {

    }
}
