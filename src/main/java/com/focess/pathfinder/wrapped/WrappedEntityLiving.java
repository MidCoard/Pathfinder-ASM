package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.LivingEntity;

public class WrappedEntityLiving extends WrappedType {

    static {
        register(NMSManager.getNMSClass("EntityLiving",true),WrappedEntityLiving.class);
    }

    private final Object nmsLivingEntity;

    private WrappedEntityLiving(Object nmsLivingEntity) {
        this.nmsLivingEntity = nmsLivingEntity;
    }

    @Override
    public Object toNMS() {
        return this.nmsLivingEntity;
    }

    private static WrappedEntityLiving getWrappedEntityLiving(Object nmsLivingEntity) {
            return new WrappedEntityLiving(nmsLivingEntity);
    }

    public static WrappedEntityLiving getWrappedEntityLiving(LivingEntity livingEntity) {
        Object nmsLivingEntity = NMSManager.getNMSEntity(livingEntity);
        return getWrappedEntityLiving(nmsLivingEntity);
    }
}
