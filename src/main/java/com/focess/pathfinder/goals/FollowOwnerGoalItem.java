package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class FollowOwnerGoalItem extends NMSGoalItem {
    private PointerWriter floatWriter = new PointerWriter(2, 2);

    protected FollowOwnerGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalFollowOwner", true), 5, NMSManager.getNMSClass("EntityTameableAnimal", true), double.class, float.class, float.class, boolean.class);
    }

    public FollowOwnerGoalItem writeEntityTameableAnimal(com.focess.pathfinder.wrapped.WrappedEntityTameableAnimal arg) {
        this.write(0, arg);
        return this;
    }

    public FollowOwnerGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public FollowOwnerGoalItem writeFloat(float arg) {
        floatWriter.write(arg);
        return this;
    }

    public FollowOwnerGoalItem writeBoolean(boolean arg) {
        this.write(4, arg);
        return this;
    }

    @Override
    public FollowOwnerGoalItem clear() {
        floatWriter.clear();
        return this;
    }
}