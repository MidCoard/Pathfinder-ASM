package com.focess.pathfinder.wrapped;

import com.focess.pathfinder.core.util.NMSManager;
import org.bukkit.entity.Raider;

public class WrappedEntityRaider extends WrappedType {

    static {
        register(NMSManager.getNMSClass("EntityRaider", true), WrappedEntityRaider.class);
    }

    private final Object nmsRaider;

    private WrappedEntityRaider(Object nmsRaider) {
        this.nmsRaider = nmsRaider;
    }

    public static WrappedEntityRaider getWrappedEntityRaider(Raider raider) {
        Object nmsRaider = NMSManager.getNMSEntity(raider);
        return getWrappedEntityRaider(nmsRaider);
    }

    private static WrappedEntityRaider getWrappedEntityRaider(Object nmsRaider) {
        return new WrappedEntityRaider(nmsRaider);
    }

    @Override
    public Object toNMS() {
        return this.nmsRaider;
    }
}
