package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Horse;

public class WrappedEntityHorseAbstract extends WrappedType {

    static {
        register(NMSManager.getNMSClass("WrappedEntityHorseAbstract"), WrappedEntityHorseAbstract.class);
    }

    private final Object nmsHorse;

    private WrappedEntityHorseAbstract(Object nmsHorse) {
        this.nmsHorse = nmsHorse;
    }

    public static WrappedEntityHorseAbstract getWrappedEntityHorseAbstract(Horse horse) {
        Object nmsHorse = NMSManager.getNMSEntity(horse);
        return getWrappedEntityHorseAbstract(nmsHorse);
    }

    private static WrappedEntityHorseAbstract getWrappedEntityHorseAbstract(Object nmsHorse) {
        return new WrappedEntityHorseAbstract(nmsHorse);
    }

    @Override
    public Object toNMS() {
        return this.nmsHorse;
    }
}
