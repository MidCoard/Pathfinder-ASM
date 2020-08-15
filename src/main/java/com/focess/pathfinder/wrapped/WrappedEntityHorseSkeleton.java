package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Horse;

public class WrappedEntityHorseSkeleton extends WrappedType {

    static {
        register(NMSManager.getNMSClass("EntityHorseSkeleton",true),WrappedEntityHorseSkeleton.class);
    }

    private final Object nmsHorse;

    private WrappedEntityHorseSkeleton(Object nmsHorse) {
        this.nmsHorse = nmsHorse;
    }

    public static WrappedEntityHorseSkeleton getWrappedEntityHorseSkeleton(Horse horse) {
        Object nmsHorse = NMSManager.getNMSEntity(horse);
        return getWrappedEntityHorseSkeleton(nmsHorse);
    }

    private static WrappedEntityHorseSkeleton getWrappedEntityHorseSkeleton(Object nmsHorse) {
        if (NMSManager.getNMSClass("EntityHorseSkeleton").isAssignableFrom(nmsHorse.getClass()))
            return new WrappedEntityHorseSkeleton(nmsHorse);
        throw new ClassCastException(nmsHorse.getClass().getTypeName() + " cannot be cast to " + WrappedEntityHorseSkeleton.class.getTypeName());
    }

    @Override
    public Object toNMS() {
        return this.nmsHorse;
    }
}
