package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Horse;

public class WrappedEntityHorse extends  WrappedType {

    static {
        register(NMSManager.getNMSClass("EntityHorse",true),WrappedEntityHorse.class);
    }

    private final Object nmsHorse;

    private WrappedEntityHorse(Object nmsHorse) {
        this.nmsHorse = nmsHorse;
    }

    public static WrappedEntityHorse getWrappedEntityHorse(Horse horse) {
        Object nmsHorse = NMSManager.getNMSEntity(horse);
        return getWrappedEntityHorse(nmsHorse);
    }

    private static WrappedEntityHorse getWrappedEntityHorse(Object nmsHorse) {
            return new WrappedEntityHorse(nmsHorse);
     }

    @Override
    public Object toNMS() {
        return this.nmsHorse;
    }
}
