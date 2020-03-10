package com.focess.pathfinder.core.goal;

import com.focess.pathfinder.core.builder.PathfinderClassLoader;
import com.focess.pathfinder.core.goal.util.NMSManager;
import com.focess.pathfinder.goal.Goal;
import com.focess.pathfinder.goal.GoalItem;
import com.focess.pathfinder.goal.GoalSelector;
import com.focess.pathfinder.goal.Goals;
import com.focess.pathfinder.goal.entity.FocessEntity;
import com.google.common.collect.Sets;
import net.minecraft.server.v1_13_R1.Pathfinder;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class SimpleGoalSelector implements GoalSelector {

    private final FocessEntity entity;

    public SimpleGoalSelector(FocessEntity focessEntity) {
        this.entity = focessEntity;

    }

    public Set<GoalItem> getGoalItems() {
        Set<GoalItem> items = Sets.newHashSet();
        Object nmsEntity = NMSManager.getNMSEntity(this.entity.getBukkitEntity());
        Field goalSelector = NMSManager.getField(NMSManager.EntityInsentient,"goalSelector");
        Field targetSelector = NMSManager.getField(NMSManager.EntityInsentient,"targetSelector");
        if (NMSManager.isHighVersion()) {

            try {
                Set<?> nmsGoals = (Set<?>) NMSManager.PathfinderGoalsField.get(goalSelector.get(nmsEntity));
                for (Object nmsGoal: nmsGoals)
                    items.add(Goals.getNMSGoalItem((Class<?>)NMSManager.getField(NMSManager.getNMSClass("PathfinderGoalWrapped"),"a").get(nmsGoal)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        else {

        }
        return items;
    }

    @Override
    public void removeExactGoal(GoalItem goalItem, Goal goal) {

    }

    @Override
    public void addGoal(Goal goal) {
            try {
                Object nmsGoal = PathfinderClassLoader.NMSGoal.getConstructor(Goal.class).newInstance(goal);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

    }

    @Override
    public boolean containsExactGoal(GoalItem goalItem, Goal goal) {
        return false;
    }

    @Override
    public Object getGoal(GoalItem goalItem) {
        return null;
    }

    private static class GoalItemInfo {
        private final GoalItem goalItem;
        private final Goal goal;

        private GoalItemInfo(GoalItem goalItem, Goal goal) {
            this.goalItem = goalItem;
            this.goal = goal;
        }
    }
}
