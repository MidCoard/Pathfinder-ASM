package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.LivingEntity;

public class WrappedIEntityAngerable extends WrappedType{

    static {
        register(NMSManager.getNMSClass("IEntityAngerable", true), WrappedIEntityAngerable.class);
    }

    private final Object nmsIEntityAngerable;

    private WrappedIEntityAngerable(Object nmsIEntityAngerable) {
        this.nmsIEntityAngerable = nmsIEntityAngerable;
    }

    private static WrappedIEntityAngerable getWrappedIRangedEntity(Object nmsLivingEntity) {
        if (NMSManager.getNMSClass("IEntityAngerable").isAssignableFrom(nmsLivingEntity.getClass()))
            return new WrappedIEntityAngerable(nmsLivingEntity);
        throw new ClassCastException(nmsLivingEntity.getClass().getTypeName() + " cannot be cast to " + WrappedIEntityAngerable.class.getTypeName());
    }

    public static WrappedIEntityAngerable getWrappedIEntityAngerable(LivingEntity livingEntity) {
        Object nmsLivingEntity = NMSManager.getNMSEntity(livingEntity);
        return getWrappedIRangedEntity(nmsLivingEntity);
    }

    @Override
    public Object toNMS() {
        return this.nmsIEntityAngerable;
    }
}
