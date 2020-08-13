package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class FollowOwnerGoalItem_1_15 extends NMSGoalItem {
    private final PointerWriter floatWriter = new PointerWriter(2, 2);

    protected FollowOwnerGoalItem_1_15() {
        super(NMSManager.getNMSClass("PathfinderGoalFollowOwner", true), 5, NMSManager.getNMSClass("EntityTameableAnimal", true), double.class, float.class, float.class, boolean.class);
    }

    public FollowOwnerGoalItem_1_15 writeEntityTameableAnimal(com.focess.pathfinder.wrapped.WrappedEntityTameableAnimal arg) {
        this.write(0, arg);
        return this;
    }

    public FollowOwnerGoalItem_1_15 writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public FollowOwnerGoalItem_1_15 writeFloat(float arg) {
        floatWriter.write(arg);
        return this;
    }

    public FollowOwnerGoalItem_1_15 writeBoolean(boolean arg) {
        this.write(4, arg);
        return this;
    }

    @Override
    public FollowOwnerGoalItem_1_15 clear() {
        floatWriter.clear();
        return this;
    }
}