package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class LlamaFollowGoalItem extends NMSGoalItem {
    protected LlamaFollowGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalLlamaFollow", true), 2, NMSManager.getNMSClass("EntityLlama", true), double.class);
    }

    public LlamaFollowGoalItem writeEntityLlama(com.focess.pathfinder.wrapped.WrappedEntityLlama arg) {
        this.write(0, arg);
        return this;
    }

    public LlamaFollowGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    @Override
    public LlamaFollowGoalItem clear() {
        return this;
    }
}