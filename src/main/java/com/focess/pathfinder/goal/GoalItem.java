package com.focess.pathfinder.goal;

import java.util.EnumSet;
import java.util.Objects;

public abstract class  GoalItem {

    private final GoalType type;
    private final Class<?> clz;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoalItem)) return false;
        GoalItem goalItem = (GoalItem) o;
        return type == goalItem.type &&
                Objects.equals(clz, goalItem.clz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, clz);
    }

    protected GoalItem(Class<?> clz) {
        this.clz = clz;
        if (clz.getName().startsWith("net.minecraft")) {
            this.type = GoalType.NMS;
            Goals.goalItems.add(this);
        }
        else this.type = GoalType.FOCESS;
    }

    public Class<?> getGoalClass(){
        return this.clz;
    }

    public GoalType getType() {
        return this.type;
    }

    public abstract WrappedGoal build(int priority);

    public enum GoalType{
        NMS,FOCESS;
    }
}
