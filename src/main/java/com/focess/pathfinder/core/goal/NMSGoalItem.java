package com.focess.pathfinder.core.goal;

import com.focess.pathfinder.goal.GoalItem;
import com.focess.pathfinder.goal.WrappedGoal;
import com.google.common.collect.Lists;

import java.util.List;

public abstract class NMSGoalItem extends GoalItem {

    private final List<Object> values;

    private final List<Class<?>> parameters;

    protected NMSGoalItem(Class<?> clz,int args,Class<?>... parameters) {
        super(clz);
        this.values =  Lists.newArrayList(args);
        this.parameters = Lists.newArrayList(parameters);
    }

    public abstract NMSGoalItem clear();

    @Override
    public WrappedGoal build(int priority) {
        Object nmsGoal = null;
        try {
            nmsGoal = getGoalClass().getConstructor(this.parameters.toArray(new Class<?>[0])).newInstance(this, values.toArray(new Object[0]));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new WrappedGoal(this,nmsGoal,priority);
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

        public void clear() {
            this.pointer = 0;
        }
    }


}
