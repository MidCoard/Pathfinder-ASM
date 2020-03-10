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
import net.minecraft.block.GoldBlock;
import net.minecraft.server.v1_13_R1.Pathfinder;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
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
        Field goalSelector = NMSManager.getField(NMSManager.EntityInsentient,"goalSelector");
        Field targetSelector = NMSManager.getField(NMSManager.EntityInsentient,"targetSelector");
        if (NMSManager.isHighVersion()) {
            try {
                Collection<?> nmsWrappedGoals = (Collection<?>) NMSManager.PathfinderGoalsField.get(goalSelector.get(nmsEntity));
                for (Object nmsWrappedGoal: nmsWrappedGoals) {
                    Object nmsGoal = NMSManager.getField(NMSManager.getNMSClass("PathfinderGoalWrapped"), "a").get(nmsWrappedGoal);
                    NMSGoalItem goalItem = Goals.getNMSGoalItem(nmsGoal.getClass());
                    int priority = (int) NMSManager.getField(NMSManager.getNMSClass("PathfinderGoalWrapped"), "b").get(nmsWrappedGoal);
                    char[] names = NMSManager.getPathfinderGoalMethodNames();
                    goals.add(new Goal(goalItem,priority,nmsGoal) {
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
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        else {

        }
    }

    public Set<GoalItem> getGoalItems() {
        Set<GoalItem> items = Sets.newHashSet();

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
