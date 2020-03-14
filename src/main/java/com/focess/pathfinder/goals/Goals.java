package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.goal.GoalItem;
import com.focess.pathfinder.goal.WrappedGoal;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

public class Goals {

    public static Set<NMSGoalItem> goalItems = Sets.newHashSet();

    public static List<GoalItem> getNMSGoalItem(Class<?> clz) {
        List<GoalItem> goalItems = Lists.newArrayList();
        for (NMSGoalItem goalItem : Goals.goalItems)
            if (goalItem.getGoalClass().equals(clz))
                goalItems.add(goalItem);
        if (goalItems.size() == 0)
            goalItems.add(new NMSGoalItem(clz, 0) {
                @Override
                public NMSGoalItem clear() {
                    return this;
                }

                @Override
                public WrappedGoal build(int priority) {
                    throw new UnsupportedOperationException("Unknown NMSGoal cannot be built.");
                }

                @Override
                protected void write(int i, Object object) {
                    throw new UnsupportedOperationException("Unknown NMSGoal cannot be written.");
                }
            });
        return goalItems;
    }

    public static class MOVE {
//        public static final ArrowAttackGoalItem ArrowAttack = new ArrowAttackGoalItem();
    }

    public static class LOOK {

    }

    public static class JUMP {

    }

    public static class TARGET {

    }
}
