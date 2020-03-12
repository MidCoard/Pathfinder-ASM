package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class FollowEntityGoalItem extends NMSGoalItem {
    private PointerWriter floatWriter = new PointerWriter(2, 2);

    protected FollowEntityGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalFollowEntity", true), 4, NMSManager.getNMSClass("EntityInsentient", true), double.class, float.class, float.class);
    }

    public FollowEntityGoalItem writeEntityInsentient(com.focess.pathfinder.wrapped.WrappedEntityInsentient arg) {
        this.write(0, arg);
        return this;
    }

    public FollowEntityGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public FollowEntityGoalItem writeFloat(float arg) {
        floatWriter.write(arg);
        return this;
    }

    @Override
    public FollowEntityGoalItem clear() {
        floatWriter.clear();
        return this;
    }
}