package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.wrapped.WrappedEntityInsentient;
import com.focess.pathfinder.wrapped.WrappedNMSPredicate;

import java.util.function.Predicate;

public class UseItemGoalItem extends NMSGoalItem {
    protected UseItemGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalUseItem", true), 4, NMSManager.getNMSClass("EntityInsentient", true), NMSManager.getNMSClass("ItemStack", true), NMSManager.getNMSClass("SoundEffect", true), Predicate.class);
    }

    public UseItemGoalItem writeEntityInsentient(WrappedEntityInsentient arg) {
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

    public UseItemGoalItem writePredicate(WrappedNMSPredicate<WrappedEntityInsentient> arg) {
        this.write(3, arg);
        return this;
    }

    @Override
    public UseItemGoalItem clear() {
        return this;
    }
}