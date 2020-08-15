package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.wrapped.WrappedItem;

public class TemptGoalItem_1_8 extends NMSGoalItem {
    protected TemptGoalItem_1_8() {
        super(NMSManager.getNMSClass("PathfinderGoalTempt", true), 4, NMSManager.getNMSClass("EntityCreature", true), double.class, boolean.class, NMSManager.getNMSClass("RecipeItemStack", true));
    }

    public TemptGoalItem_1_8 writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public TemptGoalItem_1_8 writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public TemptGoalItem_1_8 writeBoolean(boolean arg) {
        this.write(2, arg);
        return this;
    }

    public TemptGoalItem_1_8 writeItem(WrappedItem arg) {
        this.write(3, arg);
        return this;
    }

    @Override
    public TemptGoalItem_1_8 clear() {
        return this;
    }
}