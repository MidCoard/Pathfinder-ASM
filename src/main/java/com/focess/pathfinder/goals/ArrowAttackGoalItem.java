package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.wrapped.WrappedIRangedEntity;

public class ArrowAttackGoalItem extends NMSGoalItem {
    private final PointerWriter intWriter = new PointerWriter(2, 2);

    protected ArrowAttackGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalArrowAttack", true), 5, NMSManager.getNMSClass("IRangedEntity", true), double.class, int.class, int.class, float.class);
    }

    public ArrowAttackGoalItem writeIRangedEntity(WrappedIRangedEntity arg) {
        this.write(0, arg);
        return this;
    }

    public ArrowAttackGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public ArrowAttackGoalItem writeInt(int arg) {
        intWriter.write(arg);
        return this;
    }

    public ArrowAttackGoalItem writeFloat(float arg) {
        this.write(4, arg);
        return this;
    }

    @Override
    public ArrowAttackGoalItem clear() {
        intWriter.clear();
        return this;
    }
}