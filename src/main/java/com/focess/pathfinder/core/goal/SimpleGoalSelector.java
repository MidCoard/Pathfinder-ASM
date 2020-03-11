package com.focess.pathfinder.core.goal;

import com.focess.pathfinder.core.builder.PathfinderClassLoader;
import com.focess.pathfinder.core.goal.util.NMSManager;
import com.focess.pathfinder.goal.Goal;
import com.focess.pathfinder.goal.GoalItem;
import com.focess.pathfinder.goal.GoalSelector;
import com.focess.pathfinder.goal.Goals;
import com.focess.pathfinder.goal.entity.FocessEntity;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class SimpleGoalSelector implements GoalSelector {

    private final FocessEntity entity;

    public SimpleGoalSelector(FocessEntity focessEntity) {
        this.entity = focessEntity;
    }

    private List<Goal> goals = Lists.newArrayList();

    private void update() {
        Object nmsEntity = NMSManager.getNMSEntity(this.entity.getBukkitEntity());
        Field goalSelector = NMSManager.getField(NMSManager.EntityInsentient, "goalSelector");
        Field targetSelector = NMSManager.getField(NMSManager.EntityInsentient, "targetSelector");
        try {
            Collection<?> nmsWrappedGoals = (Collection<?>) NMSManager.PathfinderGoalsField.get(goalSelector.get(nmsEntity));
            Collection<?> nmsWrappedGoals2 = (Collection<?>) NMSManager.PathfinderGoalsField.get(targetSelector.get(nmsEntity));
            for (Object nmsWrappedGoal : nmsWrappedGoals) {
                Object nmsGoal = NMSManager.PathfinderGoalItema.get(nmsWrappedGoal);
                if (nmsGoal.getClass().getName().equals("com.focess.pathfinder.core.goal.NMSGoal")) {
                    Goal goal = (Goal) PathfinderClassLoader.NMSGoal.getDeclaredField("goal").get(nmsGoal);
                    Field field = Goal.class.getDeclaredField("nmsGoal");
                    field.setAccessible(true);
                    field.set(goal,nmsGoal);
                    goals.add((goal);
                    continue;
                }
                NMSGoalItem goalItem = Goals.getNMSGoalItem(nmsGoal.getClass());
                int priority = (int) NMSManager.PathfinderGoalItemb.get(nmsWrappedGoal);
                char[] names = NMSManager.getPathfinderGoalMethodNames();
                goals.add(new Goal(goalItem, priority, nmsGoal) {
                    @Override
                    public boolean canStart() {
                        try {
                            return (boolean) nmsGoal.getClass().getDeclaredMethod(String.valueOf(names[0])).invoke(nmsGoal);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    }

                    @Override
                    public boolean shouldContinue() {
                        try {
                            return (boolean) nmsGoal.getClass().getDeclaredMethod(String.valueOf(names[1])).invoke(nmsGoal);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    }

                    @Override
                    public void start() {
                        try {
                            nmsGoal.getClass().getDeclaredMethod(String.valueOf(names[2])).invoke(nmsGoal);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void stop() {
                        try {
                            nmsGoal.getClass().getDeclaredMethod(String.valueOf(names[3])).invoke(nmsGoal);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void tick() {
                        try {
                            nmsGoal.getClass().getDeclaredMethod(String.valueOf(names[4])).invoke(nmsGoal);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public boolean canStop() {
                        try {
                            return (boolean) nmsGoal.getClass().getDeclaredMethod(String.valueOf(names[5])).invoke(nmsGoal);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    }
                });
            }
            for (Object nmsWrappedGoal : nmsWrappedGoals2) {
                Object nmsGoal = NMSManager.getField(NMSManager.getNMSClass("PathfinderGoalWrapped"), "a").get(nmsWrappedGoal);
                NMSGoalItem goalItem = Goals.getNMSGoalItem(nmsGoal.getClass());
                int priority = (int) NMSManager.getField(NMSManager.getNMSClass("PathfinderGoalWrapped"), "b").get(nmsWrappedGoal);
                char[] names = NMSManager.getPathfinderGoalMethodNames();
                goals.add(new Goal(goalItem, priority, nmsGoal) {
                    @Override
                    public boolean canStart() {
                        try {
                            return (boolean) nmsGoal.getClass().getDeclaredMethod(String.valueOf(names[0])).invoke(nmsGoal);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    }

                    @Override
                    public boolean shouldContinue() {
                        try {
                            return (boolean) nmsGoal.getClass().getDeclaredMethod(String.valueOf(names[1])).invoke(nmsGoal);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    }

                    @Override
                    public void start() {
                        try {
                            nmsGoal.getClass().getDeclaredMethod(String.valueOf(names[2])).invoke(nmsGoal);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void stop() {
                        try {
                            nmsGoal.getClass().getDeclaredMethod(String.valueOf(names[3])).invoke(nmsGoal);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void tick() {
                        try {
                            nmsGoal.getClass().getDeclaredMethod(String.valueOf(names[4])).invoke(nmsGoal);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public boolean canStop() {
                        try {
                            return (boolean) nmsGoal.getClass().getDeclaredMethod(String.valueOf(names[5])).invoke(nmsGoal);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Set<GoalItem> getGoalItems() {
        update();
        Set<GoalItem> items = Sets.newHashSet();
        for (Goal goal : goals)
            items.add(goal.toGoalItem());
        return items;
    }

    @Override
    public void removeExactGoal(Goal goal) {
        Object nmsEntity = NMSManager.getNMSEntity(this.entity.getBukkitEntity());
        try {
            if (goal.getControls().contains(Goal.Control.TARGET)) {
                Object targetSelector = NMSManager.getField(NMSManager.EntityInsentient, "targetSelector").get(nmsEntity);
                Field nmsGoalField = Goal.class.getDeclaredField("nmsGoal");
                nmsGoalField.setAccessible(true);
                NMSManager.PathfinderGoalSelectorRemove.invoke(targetSelector, nmsGoalField.get(goal));
            } else {
                Object goalSelector = NMSManager.getField(NMSManager.EntityInsentient, "goalSelector").get(nmsEntity);
                Field nmsGoalField = Goal.class.getDeclaredField("nmsGoal");
                nmsGoalField.setAccessible(true);
                NMSManager.PathfinderGoalSelectorRemove.invoke(goalSelector, nmsGoalField.get(goal));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addGoal(Goal goal) {
        try {
            Object nmsGoal = PathfinderClassLoader.NMSGoal.getConstructor(Goal.class).newInstance(goal);
            if (NMSManager.getVersionInt() > 13)
                NMSManager.PathfinderGoalMutex.invoke(nmsGoal, NMSManager.toNMSControls(goal.getControls()));
            else {
                int value = 0;
                for (Goal.Control control : goal.getControls())
                    value += control.getValue();
                NMSManager.PathfinderGoalMutex.invoke(nmsGoal, value);
            }
            Object nmsEntity = NMSManager.getNMSEntity(this.entity.getBukkitEntity());
            if (goal.getControls().contains(Goal.Control.TARGET)) {
                Object targetSelector = NMSManager.getField(NMSManager.EntityInsentient, "targetSelector").get(nmsEntity);
                NMSManager.PathfinderGoalSelectorAdd.invoke(targetSelector,goal.getPriority(),nmsGoal);
            } else {
                Object goalSelector = NMSManager.getField(NMSManager.EntityInsentient, "goalSelector").get(nmsEntity);
                NMSManager.PathfinderGoalSelectorAdd.invoke(goalSelector,goal.getPriority(),nmsGoal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean containsExactGoal(Goal goal) {
        update();a
        for (Goal g : goals)
            if (g.equals(goal))
                return true;
        return false;
    }

    @Override
    public List<Goal> getGoal(GoalItem goalItem) {
        update();
        List<Goal> foundGoals = Lists.newArrayList();
        for (Goal goal : goals)
            if (goal.toGoalItem().equals(goalItem))
                foundGoals.add(goal);
        return foundGoals;
    }
}
