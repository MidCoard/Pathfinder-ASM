package com.focess.pathfinder.core.goal;

import com.focess.pathfinder.core.builder.PathfinderClassLoader;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.goal.*;
import com.focess.pathfinder.goal.entity.FocessEntity;
import com.focess.pathfinder.goals.Goals;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.nio.channels.WritePendingException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class SimpleGoalSelector implements GoalSelector {

    private final FocessEntity entity;

    public SimpleGoalSelector(FocessEntity focessEntity) {
        this.entity = focessEntity;
    }

    private final List<WrappedGoal> wrappedGoals = Lists.newArrayList();

    private void update() {
        Object nmsEntity = NMSManager.getNMSEntity(this.entity.getBukkitEntity());
        Field goalSelector = NMSManager.getField(NMSManager.EntityInsentient, "goalSelector");
        Field targetSelector = NMSManager.getField(NMSManager.EntityInsentient, "targetSelector");
        try {
            Collection<?> nmsWrappedGoals = (Collection<?>) NMSManager.PathfinderGoalsField.get(goalSelector.get(nmsEntity));
            Collection<?> nmsWrappedGoals2 = (Collection<?>) NMSManager.PathfinderGoalsField.get(targetSelector.get(nmsEntity));
            for (Object nmsWrappedGoal : nmsWrappedGoals) {
                Object nmsGoal = NMSManager.PathfinderGoalItema.get(nmsWrappedGoal);
                int priority = (int) NMSManager.PathfinderGoalItemb.get(nmsWrappedGoal);
                if (nmsGoal.getClass().getName().equals("com.focess.pathfinder.core.goal.NMSGoal")) {
                    Goal goal = (Goal) PathfinderClassLoader.NMSGoal.getDeclaredField("goal").get(nmsGoal);
                    wrappedGoals.add(new WrappedGoal(goal.getGoalItem(),nmsGoal,priority));
                    continue;
                }
                NMSGoalItem goalItem = Goals.getNMSGoalItem(nmsGoal.getClass());
                wrappedGoals.add(new WrappedGoal(goalItem,nmsGoal,priority));
            }
            for (Object nmsWrappedGoal : nmsWrappedGoals2) {
                Object nmsGoal = NMSManager.PathfinderGoalItema.get(nmsWrappedGoal);
                int priority = (int) NMSManager.PathfinderGoalItemb.get(nmsWrappedGoal);
                if (nmsGoal.getClass().getName().equals("com.focess.pathfinder.core.goal.NMSGoal")) {
                    Goal goal = (Goal) PathfinderClassLoader.NMSGoal.getDeclaredField("goal").get(nmsGoal);
                    wrappedGoals.add(new WrappedGoal(goal.getGoalItem(),nmsGoal,priority));
                    continue;
                }
                NMSGoalItem goalItem = Goals.getNMSGoalItem(nmsGoal.getClass());
                wrappedGoals.add(new WrappedGoal(goalItem,nmsGoal,priority));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Set<GoalItem> getGoalItems() {
        update();
        Set<GoalItem> items = Sets.newHashSet();
        for (WrappedGoal goal : wrappedGoals)
            items.add(goal.getGoalItem());
        return items;
    }

    @Override
    public void removeGoal(GoalItem goalItem) {
        update();
        for (WrappedGoal goal: wrappedGoals)
            if (goal.getGoalItem().equals(goalItem))
                removeExactGoal(goal);
    }

    @Override
    public boolean containsGoal(GoalItem goalItem) {
        update();
        for (WrappedGoal goal:wrappedGoals)
            if (goal.getGoalItem().equals(goalItem))
                return true;
        return false;
    }

    @Override
    public void removeExactGoal(WrappedGoal goal) {
        Object nmsEntity = NMSManager.getNMSEntity(this.entity.getBukkitEntity());
        try {
            if (goal.getControls().contains(Goal.Control.TARGET)) {
                Object targetSelector = NMSManager.getField(NMSManager.EntityInsentient, "targetSelector").get(nmsEntity);
                NMSManager.PathfinderGoalSelectorRemove.invoke(targetSelector, goal.getNmsGoal());
            } else {
                Object goalSelector = NMSManager.getField(NMSManager.EntityInsentient, "goalSelector").get(nmsEntity);
                Field nmsGoalField = Goal.class.getDeclaredField("nmsGoal");
                nmsGoalField.setAccessible(true);
                NMSManager.PathfinderGoalSelectorRemove.invoke(goalSelector,  goal.getNmsGoal());
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addGoal(WrappedGoal goal) {
        try {
            Object nmsEntity = NMSManager.getNMSEntity(this.entity.getBukkitEntity());
            if (goal.getControls().contains(Goal.Control.TARGET)) {
                Object targetSelector = NMSManager.getField(NMSManager.EntityInsentient, "targetSelector").get(nmsEntity);
                NMSManager.PathfinderGoalSelectorAdd.invoke(targetSelector,goal.getPriority(),goal.getNmsGoal());
            } else {
                Object goalSelector = NMSManager.getField(NMSManager.EntityInsentient, "goalSelector").get(nmsEntity);
                NMSManager.PathfinderGoalSelectorAdd.invoke(goalSelector,goal.getPriority(),goal.getNmsGoal());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean containsExactGoal(WrappedGoal goal) {
        update();
        for (WrappedGoal g : wrappedGoals)
            if (g.equals(goal))
                return true;
        return false;
    }

    @Override
    public List<WrappedGoal> getGoal(GoalItem goalItem) {
        update();
        List<WrappedGoal> foundGoals = Lists.newArrayList();
        for (WrappedGoal goal :wrappedGoals)
            if (goal.getGoalItem().equals(goalItem))
                foundGoals.add(goal);
        return foundGoals;
    }

    @Override
    public List<WrappedGoal> getGoals(GoalItem goalItem) {
        return null;
    }
}
