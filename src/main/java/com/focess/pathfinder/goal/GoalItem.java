package com.focess.pathfinder.goal;

import com.google.common.collect.Lists;

import java.util.EnumSet;
import java.util.List;

public class GoalItem {

    private final GoalType type;
    private Class<?> clz;
    private EnumSet<Goal.Control> controls = EnumSet.noneOf(Goal.Control.class);
    private List<Class<?>> parameters = Lists.newArrayList();
    private Goal goal;
    private GoalConstructor goalConstructor;

    public GoalItem(Class<?> clz) {
        this.clz = clz;
        this.type = GoalType.NMS;
        Goals.goalItems.add(this);
    }

    public GoalItem() {this.type = GoalType.FOCESS;}

    protected GoalItem addControl(Goal.Control control) {
        controls.add(control);
        return this;
    }

    protected GoalItem addParameters(Class<?>... classes) {
        for (Class<?> clz:classes)
            addParameter(clz);
        return this;
    }

    protected GoalItem addParameter(Class<?> clz) {
        parameters.add(clz);
        return this;
    }

    protected GoalItem setGoalConstructor(GoalConstructor goalConstructor) {
        this.goalConstructor = goalConstructor;
        return this;
    }

    protected GoalItem buildByGoal(Goal goal) {
        for (Goal.Control control:goal.getControls())
            this.addControl(control);
        return this;
    }

    public Object build(Object... objects) {
        if (this.type != GoalType.NMS)
            throw new IllegalStateException("FocessGoal must be built by default.");
        this.goalConstructor = new GoalConstructor(this.parameters);
        for (Object object:objects)
            goalConstructor.write(object);
        if (!goalConstructor.isEnd())
            throw new IllegalArgumentException("Some arguments are lost in building NMS goal.");
        return goalConstructor.build(this);
    }

    protected Class<?> getGoalClass() {
        return this.clz;
    }

    private static enum GoalType{
        NMS,FOCESS;
    }
}
