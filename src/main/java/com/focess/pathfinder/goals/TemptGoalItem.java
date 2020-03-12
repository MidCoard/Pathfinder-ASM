package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class TemptGoalItem extends NMSGoalItem {
    protected TemptGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalTempt", true), 4, NMSManager.getNMSClass("EntityCreature", true), double.class, boolean.class, NMSManager.getNMSClass("RecipeItemStack", true));
    }

    public TemptGoalItem writeEntityCreature(com.focess.pathfinder.wrapped.WrappedEntityCreature arg) {
        this.write(0, arg);
        return this;
    }

    public TemptGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public TemptGoalItem writeBoolean(boolean arg) {
        this.write(2, arg);
        return this;
    }

    public TemptGoalItem writeRecipeItemStack(com.focess.pathfinder.wrapped.WrappedRecipeItemStack arg) {
        this.write(3, arg);
        return this;
    }

    @Override
    public TemptGoalItem clear() {
        return this;
    }
}