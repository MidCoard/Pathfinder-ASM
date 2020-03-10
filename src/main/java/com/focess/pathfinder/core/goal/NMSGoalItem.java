package com.focess.pathfinder.core.goal;

import com.focess.pathfinder.goal.GoalItem;
import com.focess.pathfinder.wrapped.WrappedIRangedEntity;
import com.google.common.collect.Lists;
import jdk.nashorn.internal.objects.NativeFloat32Array;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;

public class NMSGoalItem extends GoalItem {

    private List<Object> values;

    public NMSGoalItem(Class<?> clz,int args) {
        super(GoalType.NMS, clz);
        this.values =  Lists.newArrayList(args);
    }

    @Override
    public Object build(Object... objects) {
        GoalConstructor goalConstructor = new GoalConstructor();
        for (Object object : objects)
            goalConstructor.write(object);
        if (!goalConstructor.isEnd())
            throw new IllegalArgumentException("Some arguments are lost in building NMS goal.");
        return goalConstructor.build(this);
    }

    protected void write(int i, Object object) {
        this.values.set(i,object);
    }

    public class PointerWriter {

        private final int start;
        private final int len;
        private final int end;
        private int pointer;

        public PointerWriter(int start, int len) {
            this.start = start;
            this.len = len;
            this.end = start + len - 1;
            this.pointer = 0;
        }

        public void write(Object object) {
            NMSGoalItem.this.write(this.pointer+this.start,object);
            if (this.isEnd())
                pointer = 0;
            else pointer++;
        }

        private boolean isEnd() {
            return (this.pointer + this.start) == this.end;
        }
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
