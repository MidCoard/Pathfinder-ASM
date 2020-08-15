package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class FollowOwnerGoalItem_1_8 extends NMSGoalItem {
    private final PointerWriter floatWriter = new PointerWriter(2, 2);

    protected FollowOwnerGoalItem_1_8() {
        super(NMSManager.getNMSClass("PathfinderGoalFollowOwner", true), 4, NMSManager.getNMSClass("EntityTameableAnimal", true), double.class, float.class, float.class);
    }

    public FollowOwnerGoalItem_1_8 writeEntityTameableAnimal(com.focess.pathfinder.wrapped.WrappedEntityTameableAnimal arg) {
        this.write(0, arg);
        return this;
    }

    public FollowOwnerGoalItem_1_8 writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public FollowOwnerGoalItem_1_8 writeFloat(float arg) {
        floatWriter.write(arg);
        return this;
    }

    @Override
    public FollowOwnerGoalItem_1_8 clear() {
        floatWriter.clear();
        return this;
    }
}