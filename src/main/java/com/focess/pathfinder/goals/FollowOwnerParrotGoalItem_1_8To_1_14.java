package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class FollowOwnerParrotGoalItem_1_8To_1_14 extends NMSGoalItem {
    private final PointerWriter floatWriter = new PointerWriter(2, 2);

    protected FollowOwnerParrotGoalItem_1_8To_1_14() {
        super(NMSManager.getNMSClass("PathfinderGoalFollowOwnerParrot", true), 4, NMSManager.getNMSClass("EntityTameableAnimal", true), double.class, float.class, float.class);
    }

    public FollowOwnerParrotGoalItem_1_8To_1_14 writeEntityTameableAnimal(com.focess.pathfinder.wrapped.WrappedEntityTameableAnimal arg) {
        this.write(0, arg);
        return this;
    }

    public FollowOwnerParrotGoalItem_1_8To_1_14 writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public FollowOwnerParrotGoalItem_1_8To_1_14 writeFloat(float arg) {
        floatWriter.write(arg);
        return this;
    }

    @Override
    public FollowOwnerParrotGoalItem_1_8To_1_14 clear() {
        floatWriter.clear();
        return this;
    }
}