package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;

public class UseItemGoalItem extends NMSGoalItem {
    protected UseItemGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalUseItem", true), 4, NMSManager.getNMSClass("EntityInsentient", true), NMSManager.getNMSClass("ItemStack", true), NMSManager.getNMSClass("SoundEffect", true), java.util.function.Predicate.class);
    }

    public UseItemGoalItem writeEntityInsentient(T arg) {
        this.write(0, arg);
        return this;
    }

    public UseItemGoalItem writeItemStack(com.focess.pathfinder.wrapped.WrappedItemStack arg) {
        this.write(1, arg);
        return this;
    }

    public UseItemGoalItem writeSoundEffect(com.focess.pathfinder.wrapped.WrappedSoundEffect arg) {
        this.write(2, arg);
        return this;
    }

    public UseItemGoalItem writePredicate(java.util.function.Predicate<? super T> arg) {
        this.write(3, arg);
        return this;
    }

    @Override
    public UseItemGoalItem clear() {
        return this;
    }
}