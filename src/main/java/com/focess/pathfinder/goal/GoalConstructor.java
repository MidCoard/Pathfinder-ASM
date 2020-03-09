package com.focess.pathfinder.goal;

import com.google.common.collect.Lists;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

public class GoalConstructor {

    private final List<Class<?>> parameters;
    private int point;

    public GoalConstructor(List<Class<?>> parameters) {
        this.parameters = parameters;
        this.point = 0;
    }

    private final List<Object> values = Lists.newArrayList();


    public void write(Object object) {
        if (this.isEnd())
            return;
        if (parameters.get(point).isAssignableFrom(object.getClass())) {
            values.add(object);
            point++;
        }
        else throw new IllegalArgumentException(object + " is not the type of " + parameters.get(point));
    }

    public boolean isEnd() {
        return point == parameters.size();
    }

    public Object build(GoalItem goalItem) {
        try {
            return goalItem.getGoalClass().getConstructor(this.parameters.toArray(new Class<?>[0])).newInstance(this,values.toArray(new Object[0]));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
