package com.focess.pathfinder.core.goal;

import com.focess.pathfinder.core.exceptions.PathfinderGoalNotFoundException;
import com.focess.pathfinder.goal.GoalItem;
import com.focess.pathfinder.goal.WrappedGoal;
import com.focess.pathfinder.goals.BreedGoalItem_1_11;
import com.focess.pathfinder.wrapped.WrappedSet;
import com.focess.pathfinder.wrapped.WrappedType;
import com.google.common.collect.Lists;

import java.util.List;

public abstract class NMSGoalItem extends GoalItem {

    private final List<Object> fixedValues = Lists.newArrayList();

    private final Object[] values;

    private final Class<?>[] parameters;

    protected NMSGoalItem(Class<?> clz, int args, Class<?>... parameters) {
        super(clz);
        this.values = new Object[args];
        this.parameters = parameters;
    }

    public abstract NMSGoalItem clear();

    @Override
    public WrappedGoal build(int priority, boolean isTarget) {
        this.fixedValues.clear();
        for (Object object : values)
            fixedValues.add(buildParameter(object));
        Object nmsGoal;
        try {
            if (this.getGoalClass() == null)
                throw new PathfinderGoalNotFoundException(this.getClass().getSimpleName());
            nmsGoal = getGoalClass().getConstructor(this.parameters).newInstance(fixedValues.toArray(new Object[0]));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new WrappedGoal(this, nmsGoal, priority, isTarget);
    }

    private Object buildParameter(Object object) {
        if (object instanceof WrappedType)
            return ((WrappedType) object).toNMS();
        if (object instanceof BreedGoalItem_1_11.WrappedClass)
            return ((BreedGoalItem_1_11.WrappedClass) object).getClass(this.fixedValues);
        if (object instanceof WrappedSet)
            return ((WrappedSet) object).toNMS();
        return object;
    }


    protected void write(int i, Object object) {
        this.values[i] = object;
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
            NMSGoalItem.this.write(this.pointer + this.start, object);
            if (this.isEnd())
                pointer = 0;
            else pointer++;
        }

        private boolean isEnd() {
            return (this.pointer + this.start) == this.end;
        }

        public void clear() {
            this.pointer = 0;
        }
    }


}
