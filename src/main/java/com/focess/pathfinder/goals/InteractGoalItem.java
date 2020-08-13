package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class InteractGoalItem extends NMSGoalItem {
    private final PointerWriter floatWriter = new PointerWriter(2, 2);

    protected InteractGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalInteract", true), 4, NMSManager.getNMSClass("EntityInsentient", true), Class.class, float.class, float.class);
    }

    public InteractGoalItem writeEntityInsentient(com.focess.pathfinder.wrapped.WrappedEntityInsentient arg) {
        this.write(0, arg);
        return this;
    }

    public InteractGoalItem writeClass(Class<?> arg) {
        this.write(1, arg);
        return this;
    }

    public InteractGoalItem writeFloat(float arg) {
        floatWriter.write(arg);
        return this;
    }

    @Override
    public InteractGoalItem clear() {
        floatWriter.clear();
        return this;
    }
}