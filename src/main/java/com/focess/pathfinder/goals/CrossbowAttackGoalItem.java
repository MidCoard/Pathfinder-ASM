package com.focess.pathfinder.goals;

import com.focess.pathfinder.core.goal.NMSGoalItem;
import com.focess.pathfinder.core.util.NMSManager;
import com.focess.pathfinder.wrapped.WrappedEntityMonster;
import com.focess.pathfinder.wrapped.WrappedICrossbow;
import com.focess.pathfinder.wrapped.WrappedIRangedEntity;
import com.focess.pathfinder.wrapped.WrappedType;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.Pillager;

import java.util.Objects;

public class CrossbowAttackGoalItem extends NMSGoalItem {
    protected CrossbowAttackGoalItem() {
        super(NMSManager.getNMSClass("PathfinderGoalCrossbowAttack", true), 3, NMSManager.getNMSClass("EntityMonster", true), double.class, float.class);
    }

    public CrossbowAttackGoalItem writeEntityMonster(WrappedEntityMonsterAndIRangedEntityAndICrossbow arg) {
        this.write(0, arg);
        return this;
    }

    public CrossbowAttackGoalItem writeDouble(double arg) {
        this.write(1, arg);
        return this;
    }

    public CrossbowAttackGoalItem writeFloat(float arg) {
        this.write(2, arg);
        return this;
    }

    @Override
    public CrossbowAttackGoalItem clear() {
        return this;
    }

    public static class WrappedEntityMonsterAndIRangedEntityAndICrossbow extends WrappedType {

        private final Object nms;

        private WrappedEntityMonsterAndIRangedEntityAndICrossbow(Object nms) {
            this.nms = nms;
        }

        public static WrappedEntityMonsterAndIRangedEntityAndICrossbow getWrappedEntityMonsterAndIRangedEntityAndICrossbow(Pillager pillager) {
            WrappedEntityMonster wrappedEntityMonster = WrappedEntityMonster.getWrappedEntityMonster(pillager);
            WrappedIRangedEntity iRangedEntity = WrappedIRangedEntity.getWrappedIRangedEntity(pillager);
            WrappedICrossbow iCrossbow = WrappedICrossbow.getWrappedICrossbow(pillager);
            if (Objects.equals(wrappedEntityMonster.toNMS(), iRangedEntity.toNMS()) && Objects.equals(iRangedEntity, iCrossbow))
                return new WrappedEntityMonsterAndIRangedEntityAndICrossbow(wrappedEntityMonster.toNMS());
            throw new IllegalArgumentException(pillager.getClass().getTypeName());
        }

        public static WrappedEntityMonsterAndIRangedEntityAndICrossbow getWrappedEntityMonsterAndIRangedEntityAndICrossbow(Piglin piglin) {
            WrappedEntityMonster wrappedEntityMonster = WrappedEntityMonster.getWrappedEntityMonster(piglin);
            WrappedIRangedEntity iRangedEntity = WrappedIRangedEntity.getWrappedIRangedEntity(piglin);
            WrappedICrossbow iCrossbow = WrappedICrossbow.getWrappedICrossbow(piglin);
            if (Objects.equals(wrappedEntityMonster.toNMS(), iRangedEntity.toNMS()) && Objects.equals(iRangedEntity, iCrossbow))
                return new WrappedEntityMonsterAndIRangedEntityAndICrossbow(wrappedEntityMonster.toNMS());
            throw new IllegalArgumentException(piglin.getClass().getTypeName());
        }

        @Override
        public Object toNMS() {
            return this.nms;
        }
    }
}