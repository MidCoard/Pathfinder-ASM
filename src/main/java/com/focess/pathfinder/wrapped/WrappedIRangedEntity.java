package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.LivingEntity;

public class WrappedIRangedEntity extends WrappedType {

    static  {
        register(NMSManager.getNMSClass("IRangedEntity",true),WrappedIRangedEntity.class);
    }

    private final Object nmsIRangedEntity;

    private WrappedIRangedEntity(Object nmsIRangedEntity) {
        this.nmsIRangedEntity = nmsIRangedEntity;
    }

    @Override
    public Object toNMS() {
        return this.nmsIRangedEntity;
    }

    private static WrappedIRangedEntity getWrappedIRangedEntity(Object nmsLivingEntity) {
        if (NMSManager.getNMSClass("IRangedEntity").isAssignableFrom(nmsLivingEntity.getClass()))
            return new WrappedIRangedEntity(nmsLivingEntity);
        throw new ClassCastException(nmsLivingEntity.getClass().getTypeName() + " cannot be cast to " + WrappedIRangedEntity.class.getTypeName());
    }

    public static WrappedIRangedEntity getWrappedIRangedEntity(LivingEntity livingEntity) {
        Object nmsLivingEntity = NMSManager.getNMSEntity(livingEntity);
        return getWrappedIRangedEntity(nmsLivingEntity);
    }
}
