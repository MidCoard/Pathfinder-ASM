package com.focess.pathfinder.core.goal;

import com.focess.pathfinder.goal.GoalItem;
import com.google.common.collect.Lists;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;

public class NMSGoalItem extends GoalItem {

    private final Class<?> clz;

    public NMSGoalItem(Class<?> clz) {
        super(GoalType.NMS);
        this.clz = clz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NMSGoalItem)) return false;
        NMSGoalItem that = (NMSGoalItem) o;
        return clz.equals(that.clz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clz);
    }

    @Override
    public Object build(Object... objects) {
        GoalConstructor goalConstructor = new GoalConstructor(this.parameters);
        for (Object object : objects)
            goalConstructor.write(object);
        if (!goalConstructor.isEnd())
            throw new IllegalArgumentException("Some arguments are lost in building NMS goal.");
        return goalConstructor.build(this);
    }

    public Class<?> getGoalClass() {
        return clz;
    }

    private static class GoalConstructor {

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
            } else throw new IllegalArgumentException(object + " is not the type of " + parameters.get(point));
        }

        public boolean isEnd() {
            return point == parameters.size();
        }

        public Object build(NMSGoalItem goalItem) {
            try {
                return goalItem.getGoalClass().getConstructor(this.parameters.toArray(new Class<?>[0])).newInstance(this, values.toArray(new Object[0]));
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
}
