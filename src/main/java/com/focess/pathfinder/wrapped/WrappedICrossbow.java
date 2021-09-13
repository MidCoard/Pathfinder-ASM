package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.Pillager;

public class WrappedICrossbow extends WrappedType {

    static {
        register(NMSManager.getNMSClass("ICrossbow", true), WrappedICrossbow.class);
    }

    private final Object nmsICrossbow;

    private WrappedICrossbow(Object nmsICrossbow) {
        this.nmsICrossbow = nmsICrossbow;
    }


    public static WrappedICrossbow getWrappedICrossbow(Pillager pillager) {
        Object nmsPillager = NMSManager.getNMSEntity(pillager);
        return getWrappedICrossbow(nmsPillager);
    }

    public static WrappedICrossbow getWrappedICrossbow(Piglin piglin) {
        Object nmsPiglin = NMSManager.getNMSEntity(piglin);
        return getWrappedICrossbow(nmsPiglin);
    }

    private static WrappedICrossbow getWrappedICrossbow(Object nmsICrossbow) {
        if (NMSManager.getNMSClass("ICrossbow").isAssignableFrom(nmsICrossbow.getClass()))
            return new WrappedICrossbow(nmsICrossbow);
        throw new ClassCastException(nmsICrossbow.getClass().getTypeName() + " cannot be cast to " + WrappedICrossbow.class.getTypeName());
    }

    @Override
    public Object toNMS() {
        return this.nmsICrossbow;
    }
}
