package com.focess.pathfinder.core.goal;

import com.focess.pathfinder.core.goal.util.NMSManager;
import com.focess.pathfinder.goal.Goal;
import com.focess.pathfinder.goal.GoalItem;
import com.google.common.collect.Lists;

import java.util.List;

public abstract class NMSGoalItem extends GoalItem {

    private List<Object> values;

    private List<Class<?>> parameters;

    public NMSGoalItem(Class<?> clz,int args,Class<?>... parameters) {
        super(GoalType.NMS, clz);
        this.values =  Lists.newArrayList(args);
        this.parameters = Lists.newArrayList(parameters);
    }

    public abstract NMSGoalItem clear();

    @Override
    public Goal build(int priority) {
        Object nmsGoal = null;
        try {
            nmsGoal = getGoalClass().getConstructor(this.parameters.toArray(new Class<?>[0])).newInstance(this, values.toArray(new Object[0]));
        } catch (Exception e) {
            e.printStackTrace();
        }
        char[] names = NMSManager.getPathfinderGoalMethodNames();
        Object finalNmsGoal = nmsGoal;
        return new Goal(this,priority,nmsGoal) {
            @Override
            public boolean canStart() {
                try {
                    return (boolean) finalNmsGoal.getClass().getDeclaredMethod(String.valueOf(names[0])).invoke(finalNmsGoal);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }

            @Override
            public boolean shouldContinue() {
                try {
                    return (boolean) finalNmsGoal.getClass().getDeclaredMethod(String.valueOf(names[1])).invoke(finalNmsGoal);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }

            @Override
            public void start() {
                try {
                    finalNmsGoal.getClass().getDeclaredMethod(String.valueOf(names[2])).invoke(finalNmsGoal);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void stop() {
                try {
                    finalNmsGoal.getClass().getDeclaredMethod(String.valueOf(names[3])).invoke(finalNmsGoal);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void tick() {
                try {
                    finalNmsGoal.getClass().getDeclaredMethod(String.valueOf(names[4])).invoke(finalNmsGoal);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public boolean canStop() {
                try {
                    return (boolean) finalNmsGoal.getClass().getDeclaredMethod(String.valueOf(names[5])).invoke(finalNmsGoal);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }

        };
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
