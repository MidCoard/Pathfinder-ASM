package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Pillager;

public class WrappedICrossbow extends WrappedType {
    
    static {
        register(NMSManager.getNMSClass("ICrossbow",true),WrappedICrossbow.class);
    }

    private final Object nmsPillager;

    private WrappedICrossbow(Object nmsPillager) {
        this.nmsPillager = nmsPillager;
    }


    public static WrappedICrossbow getWrappedICrossbow(Pillager pillager) {
        Object nmsPillager = NMSManager.getNMSEntity(pillager);
        return getWrappedICrossbow(nmsPillager);
    }

    private static WrappedICrossbow getWrappedICrossbow(Object nmsPillager) {
        if (NMSManager.getNMSClass("ICrossbow").isAssignableFrom(nmsPillager.getClass()))
            return new WrappedICrossbow(nmsPillager);
        throw new ClassCastException(nmsPillager.getClass().getTypeName() + " cannot be cast to " + WrappedICrossbow.class.getTypeName());
    }

    @Override
    public Object toNMS() {
        return this.nmsPillager;
    }
}
