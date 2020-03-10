package com.focess.pathfinder.goal;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.goals.ArrowAttackGoalItem;
import com.google.common.collect.Sets;

import java.util.Set;

public class Goals {

    protected static Set<GoalItem> goalItems = Sets.newHashSet();

    public static NMSGoalItem getNMSGoalItem(Class<?> clz) {
        for (GoalItem goalItem:goalItems)
            if (goalItem.getGoalClass().equals(clz))
                return (NMSGoalItem) goalItem;
        return new NMSGoalItem(clz,0) {
            @Override
            public NMSGoalItem clear() {
                return this;
            }

            @Override
            public Goal build(int priority) {
                throw new UnsupportedOperationException("Unknown NMSGoal cannot be built.");
            }

            @Override
            protected void write(int i, Object object) {
                throw new UnsupportedOperationException("Unknown NMSGoal cannot be written.");
            }
        };
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
