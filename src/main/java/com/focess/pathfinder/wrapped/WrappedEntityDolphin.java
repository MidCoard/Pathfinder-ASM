package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Dolphin;

public class WrappedEntityDolphin extends WrappedType {

    static {
        register(NMSManager.getNMSClass("EntityDolphin", true), WrappedEntityDolphin.class);
    }

    private final Object nmsDolphin;

    private WrappedEntityDolphin(Object nmsDolphin) {
        this.nmsDolphin = nmsDolphin;
    }

    public static WrappedEntityDolphin getWrappedEntityDolphin(Dolphin dolphin) {
        Object nmsDolphin = NMSManager.getNMSEntity(dolphin);
        return getWrappedEntityDolphin(nmsDolphin);
    }

    private static WrappedEntityDolphin getWrappedEntityDolphin(Object nmsDolphin) {
        return new WrappedEntityDolphin(nmsDolphin);
    }

    @Override
    public Object toNMS() {
        return this.nmsDolphin;
    }
}
