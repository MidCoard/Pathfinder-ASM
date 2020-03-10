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

    private List<Class<?>> parameters;

    public NMSGoalItem(Class<?> clz,int args,Class<?>... parameters) {
        super(GoalType.NMS, clz);
        this.values =  Lists.newArrayList(args);
        this.parameters = Lists.newArrayList(parameters);
    }

    @Override
    public Object build(Object... objects) {
        return getGoalClass().getConstructor(this.parameters.toArray(new Class<?>[0])).newInstance(this, values.toArray(new Object[0]));
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


}
